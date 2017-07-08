package com.rommer.vadim;

public enum ContentSuffix {
	PDF		("pdf", "book"), 
	EPUB	("epub", "book"), 
	ISO		("iso", "image"), 
	MKV		("mkv", "video"), 
	AVI		("avi", "video"),
	MP4		("mp4", "video");
	
	private final String type;
	private final String name;
	private ContentSuffix(String name, String type) {
		this.type = type;
		this.name = name;
	}
	
	public String type() { return type; }
	public String toString() { return name; }
}
