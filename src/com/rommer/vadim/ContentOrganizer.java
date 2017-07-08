package com.rommer.vadim;

import java.nio.file.Path;

public class ContentOrganizer {
	
	private Path path;
	
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




