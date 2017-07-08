package com.rommer.vadim.app;

import java.awt.List;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OrganizerFileVisitor extends SimpleFileVisitor<Path> {
	
	private Map<String, ArrayList<Path>> visitResults;
	
	{
		visitResults = new HashMap<>();
		visitResults.put(ContentOrganizer.FILES, new ArrayList<>());
		visitResults.put(ContentOrganizer.FOLDERS, new ArrayList<>());
	}
	
	public Map<String,ArrayList<Path>> getVisitResults() { return visitResults; }

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException ex) throws IOException {
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		ArrayList<Path> files = visitResults.get("files");
		ArrayList<Path> folders = visitResults.get("folders");
		if (attrs.isRegularFile()) { 
			files.add(file);
		}
		else if (attrs.isDirectory() ) {
			folders.add(file);
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path dir, IOException ex) throws IOException {
		System.err.println(ex.getMessage());
		return FileVisitResult.CONTINUE;
	}
	
}
