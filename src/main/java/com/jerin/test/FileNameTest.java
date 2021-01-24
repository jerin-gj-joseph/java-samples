package com.jerin.test;

import java.io.File;

public class FileNameTest {

	public static void main(String[] args) {
		String filePath = "C:\\Jerin\\datasets\\genre-guesser1\\test-recorded-dataset\\classical-mozart.wav";
		File f = new File(filePath);
		System.out.println(f.getAbsolutePath());
	}

}
