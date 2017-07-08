package com.rommer.vadim.app;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContentOrganizer {
	
	public static final String FILES = "files";
	public static final String FOLDERS = "folders";
	private Map<String, ContentType> suffixMap;
	private Map<ContentType, Path> pathsMap;
	private Path path;
	
	{
		suffixMap = new HashMap<>();
		pathsMap = new HashMap<>();
		suffixMap.put("pdf", ContentType.BOOK);
		suffixMap.put("epub", ContentType.BOOK);
		suffixMap.put("iso", ContentType.IMAGE);
		suffixMap.put("img", ContentType.IMAGE);
		suffixMap.put("bin", ContentType.IMAGE);
		suffixMap.put("cue", ContentType.IMAGE);
		suffixMap.put("mkv", ContentType.VIDEO);
		suffixMap.put("avi", ContentType.VIDEO);
		suffixMap.put("mp4", ContentType.VIDEO);
		suffixMap.put("exe", ContentType.SOFTWARE);
		suffixMap.put("rar", ContentType.ARCHIVE);
		suffixMap.put("zip", ContentType.ARCHIVE);
		suffixMap.put("7z", ContentType.ARCHIVE);
		
	}
	
	/**
	 * Creates an instance of the ContentOrganizer class. 
	 * Reads the current content of the folder <path> and sets up a folder listener.
	 * 
	 * @param String path - the path to the folder represented as a String.
	 */
	private ContentOrganizer(String path) {
		this.path = Paths.get(path);
		setUpContentFolders();
	}
	
	private ContentOrganizer(Path path) {
		this.path = path;
		setUpContentFolders();
	}
	
	public Path getPath() { return this.path; }
	
	public void setPath() {  }
	
	public static ContentOrganizer getOrganizer(String path) {
		return new ContentOrganizer(path);
	}
	
	public static ContentOrganizer getOrganizer(Path path) {
		return new ContentOrganizer(path);
	}
	
	/**
	 * Organizes a content of the folder.
	 * @throws IOException 
	 */
	public void organize() throws IOException {
		Map<String, ArrayList<Path>> rootContent = getRootContent();
		Map<ContentType, ArrayList<Path>> classifiedContent = classifyContent(rootContent);
		moveContentToRelevantFolders(classifiedContent);	
	}	
	
	private void setUpContentFolders() {
		for (ContentType type: ContentType.values()) {
			pathsMap.put(type, Paths.get(this.path.getParent().toString(), type.toString()));
			// System.out.println(String.format("Setting up folder %s for %s", pathsMap.get(type), type));
		}
	}

	private Map<ContentType, ArrayList<Path>> classifyContent(Map<String, ArrayList<Path>> rootContent) 
			throws IOException {
		Map<ContentType, ArrayList<Path>> classifiedContent = new HashMap<>();
		for(ContentType type: ContentType.values()) {
			classifiedContent.put(type, new ArrayList<>());
		}
		classifyFiles(rootContent.get(FILES), classifiedContent);
		classifyFolders(rootContent.get(FOLDERS), classifiedContent);
		return classifiedContent;
	}

	private void classifyFolders(ArrayList<Path> foldersList, Map<ContentType, ArrayList<Path>> classifiedContent) {
		foldersList.forEach(folder -> {
			try {
				Map <String, ArrayList<Path>> content = getAllContentInFolder(folder);
				ArrayList<Path> filesInFolder = content.get(FILES);
				Set<ContentType> typesSetInFolder = new HashSet<>();
				filesInFolder.forEach(file -> {
					typesSetInFolder.add(getContentType(file));
				});	
				if (typesSetInFolder.contains(ContentType.SOFTWARE)) {
					classifiedContent.get(ContentType.SOFTWARE).add(folder);
				}
				else if (typesSetInFolder.contains(ContentType.IMAGE)) {
					classifiedContent.get(ContentType.IMAGE).add(folder);
				}
				else if (typesSetInFolder.contains(ContentType.VIDEO)) {
					classifiedContent.get(ContentType.VIDEO).add(folder);
				}
				else if (typesSetInFolder.contains(ContentType.BOOK)) {
					classifiedContent.get(ContentType.BOOK).add(folder);
				}
				else if (typesSetInFolder.contains(ContentType.ARCHIVE)) {
					;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}

	private void classifyFiles(ArrayList<Path> filesList, Map<ContentType, ArrayList<Path>> classifiedContent) {
		filesList.forEach(file -> {
			classifiedContent.get(getContentType(file)).add(file);
		});		
	}

	/**
	 * Moves content to the relevant content folder.
	 */
	private void moveContentToRelevantFolders(Map<ContentType, ArrayList<Path>> classifiedContent) {
		classifiedContent.forEach((contentType, pathsList)->{
			pathsList.forEach(path->{
				Path targetParent = this.pathsMap.get(contentType);
				Path targetPath = Paths.get(targetParent.toString(),path.getFileName().toString());
				try {
					if (!Files.exists(targetParent)) {
						Files.createDirectories(targetParent);
					}
					System.out.println(String.format("Source: %s\nTraget: %s\n", path, targetPath));
					Files.move(path, targetPath, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		});
	}

	private Map<String, ArrayList<Path>> getAllContentInFolder(Path folder) throws IOException {
		SimpleFileVisitor<Path> visitor = new OrganizerFileVisitor();
		Files.walkFileTree(folder, visitor);
		return ((OrganizerFileVisitor) visitor).getVisitResults();
	}
	
	private Map<String, ArrayList<Path>> getRootContent() throws IOException {
		int maxDepth = 1;
		Set<FileVisitOption> options = new HashSet<>();
		SimpleFileVisitor<Path> visitor = new OrganizerFileVisitor();
		Files.walkFileTree(this.path, options, maxDepth, visitor);
		return ((OrganizerFileVisitor) visitor).getVisitResults();
	}

	private ContentType getContentType(Path file) {
		String[] nameParts = file.getFileName().toString().split("[.]");
		String suffix = nameParts[nameParts.length-1];
		ContentType fileType = suffixMap.get(suffix);
		return fileType;
	}
}


