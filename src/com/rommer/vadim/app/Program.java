package com.rommer.vadim.app;

import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		try {
			ContentOrganizer.getOrganizer("D:\\Downloads\\Completed").organize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
