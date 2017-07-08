package com.rommer.vadim;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

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
	private ContentOrganizer() {
		
	}
	
	/**
	 * Creates an instance of the ContentOrganizer class. 
	 * Reads the current content of the folder <path>
	 * Organizes its content and sets up a folder listener.
	 * 
	 * @param String path - the path to the folder represented as a String.
	 */
	private ContentOrganizer(String path) {
		
	}
	
	private ContentOrganizer(Path path) {
		
	}
	
	public Path getPath() { return this.path; }
	
	public void setPath() {  }
	
	public static ContentOrganizer getOrganizer() {
		return new ContentOrganizer();
	}
	
	/**
	 * Organizes a content of the folder.
	 */
	public void organize() {
		boolean newContent = true;
		while(newContent) {
			getContentType();
			moveContentToRelevantFolder();	
		}	
	}
	
	/**
	 * Moves a single content (file or directory) to the relevant content folder.
	 */
	private void moveContentToRelevantFolder() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Retrieves the type of a file or folder
	 */
	private void getContentType() {
		// Read a folder and get all extensions.
		// Find out the type of content.
		// return the type of content.	
	}
}




