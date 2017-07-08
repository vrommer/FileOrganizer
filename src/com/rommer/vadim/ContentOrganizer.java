package com.rommer.vadim;

import java.nio.file.Path;
import java.nio.file.Paths;
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
	 */
	public void organize() {
		System.out.println("Organizing");
		boolean newContent = true;
		while(newContent) {
			getContentType();
			moveContentToRelevantFolder();	
			newContent = false;
		}	
	}
	
	/**
	 * Moves a single content (file or directory) to the relevant content folder.
	 */
	private void moveContentToRelevantFolder() {
		// TODO Auto-generated method stub
		System.out.println("Moving content to elevant folders");
		
	}
	
	/**
	 * Retrieves the type of a file or folder
	 */
	private void getContentType() {
		// Read a folder and get all extensions.
		// Find out the type of content.
		// return the type of content.	
		System.out.println("Getting content");
	}
}




