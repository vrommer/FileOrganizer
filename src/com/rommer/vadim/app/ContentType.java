package com.rommer.vadim.app;

public enum ContentType {
	BOOK		("eBooks"), 
	IMAGE		("Images"), 
	VIDEO		("Movies"), 
	SOFTWARE	("Software"), 
	ARCHIVE		("Archives");
	
	private final String type;
	
	ContentType(String type){
		this.type = type;
	}
	
	public String toString() {
		return type;
	}
}
