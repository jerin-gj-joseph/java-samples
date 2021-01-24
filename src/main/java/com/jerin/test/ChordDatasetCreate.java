package com.jerin.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChordDatasetCreate {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		
		System.out.println("Name1,Name2,NoOfDaysKnown,RelationStrength,Family");
		
		names.add("Jerin Joseph");
		names.add("Evelina Wilcox");
		names.add("Kirk Hurley");
		names.add("Aayush Butt");
		names.add("Troy Jarvis");
		names.add("Raya Alexander");
		names.add("Carla Neal");
		names.add("Tracy Scott");
		names.add("Marvin Vang");
		names.add("Simran Wilkins");
		names.add("Levison Randall");
		names.add("Lylah Puckett");
		names.add("Alexandru Duran");
		names.add("Rees Partridge");
		names.add("Kyla Everett");
		names.add("Shaun Wyatt");
		
		for(int i=0; i<names.size();i++) {
			for(int j=i+1;j<names.size();j++) {
				if(getRandomNumberInRange(1, 10) >7) {
					System.out.println(names.get(i)+","+names.get(j)+","+getRandomNumberInRange(20, 2000)+","+getRandomNumberInRange(1, 3)+","+getFamily());
				}
			}
			//System.out.println();
		}

	}
	
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	private static int getFamily() {
		
		if(getRandomNumberInRange(0,1)>0) {
			return getRandomNumberInRange(0,1);
		}
		
		return 0;
	}
	

}
