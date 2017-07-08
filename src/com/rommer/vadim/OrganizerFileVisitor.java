package com.rommer.vadim;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class OrganizerFileVisitor extends SimpleFileVisitor<Path> {

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException ex) throws IOException {
		System.out.println("Just visited" + dir);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		System.out.println("About to visit" + dir);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if (attrs.isRegularFile()) {}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path dir, IOException ex) throws IOException {
		System.err.println(ex.getMessage());
		return FileVisitResult.CONTINUE;
	}
	
}
