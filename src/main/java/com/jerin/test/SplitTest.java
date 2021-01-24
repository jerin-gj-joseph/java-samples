package com.jerin.test;

import java.util.ArrayList;
import java.util.Vector;

public class SplitTest {

	public static void main(String[] args) {
		String str = "abcdesfasd";
		String strArr[] = str.split("");
		
		System.out.println(strArr);
		
		for(int i=0;i<strArr.length;i++) {
			System.out.println(strArr[i]);
		}
		
		ArrayList<Integer> a = new ArrayList<>();

		Vector v = new Vector();
	}

}
