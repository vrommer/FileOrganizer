package com.rommer.vadim;

import java.awt.List;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContentOrganizer {
	
	private Map<String, ContentType> suffixMap;
	private Path path;
	
	{
		suffixMap = new HashMap<>();
		suffixMap.put("pdf", ContentType.BOOK);
		suffixMap.put("epub", ContentType.BOOK);
		suffixMap.put("iso", ContentType.IMAGE);
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
	}
	
	private ContentOrganizer(Path path) {
		this.path = path;
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
		rootContent.forEach((k,v)->{
			((Iterable<?>) v).forEach(entry->{
				
			});
		});
		boolean newContent = true;
		while(newContent) {
			try {
				getContentType();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			moveContentToRelevantFolder();	
			newContent = false;
		}	
	}	

	private Map<String, ArrayList<Path>> getRootContent() throws IOException {
		Set<FileVisitOption> options = new HashSet<>();
		SimpleFileVisitor<Path> visitor = new OrganizerFileVisitor();
		Files.walkFileTree(path, options, 1, visitor);
		return ((OrganizerFileVisitor) visitor).getVisitResults();
	}

	/**
	 * Moves a single content (file or directory) to the relevant content folder.
	 */
	private void moveContentToRelevantFolder() {
		// TODO Auto-generated method stub
		System.out.println("Moving content to relevant folders");
		
	}
	
	/**
	 * Retrieves the type of a file or folder
	 * @throws IOException 
	 */
	private void getContentType() throws IOException {
		// Read a folder and get all extensions.
		// Find out the type of content.
		// return the type of content.	
	}
}




