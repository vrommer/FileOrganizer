package com.rommer.vadim.app;

public enum ContentType {
	BOOK		("book"), 
	IMAGE		("cd image"), 
	VIDEO		("video"), 
	SOFTWARE	("software"), 
	ARCHIVE		("archive");
	
	private final String type;
	
	ContentType(String type){
		this.type = type;
	}
	
	public String toString() {
		return type;
	}
}
