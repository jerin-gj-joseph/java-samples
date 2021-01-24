package com.jerin.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecialCharTest {

	public static void main(String[] args) {
		
		System.out.println(containsSpecialCharacter("asdf$#"));

	}
	
	
	public static boolean containsSpecialCharacter(String s) {
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(s);
		boolean b = m.find();	
		return b;
		}


}
