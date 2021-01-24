package com.jerin.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.opencsv.CSVReader;

public class ModifyTableauData {
	List<FamilyClass> nameList = new ArrayList<>();
	
	FamilyClass empty = new FamilyClass("", "", 0,0,0);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ModifyTableauData mtd = new ModifyTableauData();
		mtd.readFile();

	}
	
	
	private FamilyClass getFamilyData(String fromName, String toName) {
		if(fromName.equals(toName)) {
			System.out.println("Returning empty");
			return empty;
		}
		
		for(FamilyClass fc: nameList) {
			
			if(fromName.equals(fc.getFromName()) && toName.equals(fc.getToName())) {
				return fc;
			}
			
			
		}
		System.out.println("ERRORRRRRRRRR: not found.  from Name: "+fromName+"; toName: "+toName);
		return null;
	}

	private void readFile() {
		
		loadNames();

		String fileName = "C:\\Users\\jerin\\Google Drive\\MS\\CSCE-5320-Data-Visualization\\FInalProject\\Dataset\\Relationship\\Relation-Length-Only-output-less-transpose Extract_Full Data";
		String inputFile = fileName + ".csv";
		String outputFile = fileName + "_out1.csv";
		
		


		Path p = Paths.get(outputFile);

		try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING )) {

			boolean firstLine = true;
			try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
				String append = "";
				String line;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
					StringReader r  = new StringReader(line);
				    CSVReader reader = new CSVReader(r);
				    String lineArr[] = reader.readNext();
				    reader.close();
				    
				    String from = lineArr[1];
				    String to = lineArr[7];
				    
				    FamilyClass fc = getFamilyData(from, to);
				    
				    if(fc==null) {
				    	fc = getFamilyData(to, from);
				    }
				    
				    if (firstLine) {
						append = ",Strength,Family";
						firstLine=false;
					}
					else {						
						//System.out.println("New Line: " + line);
						append = "," + fc.getStrength() + "," + fc.getFamily();
					}
					
					
					/*if (!line.startsWith(",")) {
						if (firstLine) {
							append = ",Strength,Family";
							firstLine=false;
						}
						else {						
							System.out.println("New Line: " + line);
							append = "," + getRandomNumberInRange(1, 3) + "," + getFamily();
						}
					}*/

					line += append;
					writer.write(line+"\n");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IOException ioe) {
			System.err.format("IOException: %s%n", ioe);
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

		if (getRandomNumberInRange(0, 1) > 0) {
			return getRandomNumberInRange(0, 1);
		}

		return 0;
	}
	
	
	public  void loadNames() {
		

		nameList.add(new FamilyClass("Jerin Joseph", "Evelina Wilcox", 150,  3, 0));
		nameList.add(new FamilyClass("Jerin Joseph", "Kirk Hurley", 35,  3, 1));
		nameList.add(new FamilyClass("Jerin Joseph", "Aayush Butt", 0,  0, 0));
		nameList.add(new FamilyClass("Jerin Joseph", "Troy Jarvis", 80,  1, 0));
		nameList.add(new FamilyClass("Jerin Joseph", "Raya Alexander", 477,  3, 0));
		nameList.add(new FamilyClass("Jerin Joseph", "Carla Neal", 220,  1, 0));
		nameList.add(new FamilyClass("Jerin Joseph", "Tracy Scott", 0,  0, 0));
		nameList.add(new FamilyClass("Jerin Joseph", "Marvin Vang", 31,  2, 0));
		nameList.add(new FamilyClass("Jerin Joseph", "Simran Wilkins", 0,  0, 0));
		nameList.add(new FamilyClass("Jerin Joseph", "Levison Randall", 111,  3, 0));
		nameList.add(new FamilyClass("Jerin Joseph", "Lylah Puckett", 0,  0, 0));
		nameList.add(new FamilyClass("Jerin Joseph", "Alexandru Duran", 479,  2, 1));
		nameList.add(new FamilyClass("Jerin Joseph", "Rees Partridge", 0,  0, 0));
		nameList.add(new FamilyClass("Jerin Joseph", "Kyla Everett", 0,  0, 0));
		nameList.add(new FamilyClass("Jerin Joseph", "Shaun Wyatt", 65,  1, 0));
		nameList.add(new FamilyClass("Evelina Wilcox", "Kirk Hurley", 443,  2, 0));
		nameList.add(new FamilyClass("Evelina Wilcox", "Aayush Butt", 0,  0, 0));
		nameList.add(new FamilyClass("Evelina Wilcox", "Troy Jarvis", 408,  3, 0));
		nameList.add(new FamilyClass("Evelina Wilcox", "Raya Alexander", 0,  0, 0));
		nameList.add(new FamilyClass("Evelina Wilcox", "Carla Neal", 0,  0, 0));
		nameList.add(new FamilyClass("Evelina Wilcox", "Tracy Scott", 109,  1, 0));
		nameList.add(new FamilyClass("Evelina Wilcox", "Marvin Vang", 0,  0, 0));
		nameList.add(new FamilyClass("Evelina Wilcox", "Simran Wilkins", 172,  3, 0));
		nameList.add(new FamilyClass("Evelina Wilcox", "Levison Randall", 0,  0, 0));
		nameList.add(new FamilyClass("Evelina Wilcox", "Lylah Puckett", 0,  0, 0));
		nameList.add(new FamilyClass("Evelina Wilcox", "Alexandru Duran", 390,  3, 1));
		nameList.add(new FamilyClass("Evelina Wilcox", "Rees Partridge", 0,  0, 0));
		nameList.add(new FamilyClass("Evelina Wilcox", "Kyla Everett", 0,  0, 0));
		nameList.add(new FamilyClass("Evelina Wilcox", "Shaun Wyatt", 27,  3, 0));
		nameList.add(new FamilyClass("Kirk Hurley", "Aayush Butt", 244,  3, 1));
		nameList.add(new FamilyClass("Kirk Hurley", "Troy Jarvis", 393,  2, 1));
		nameList.add(new FamilyClass("Kirk Hurley", "Raya Alexander", 0,  0, 0));
		nameList.add(new FamilyClass("Kirk Hurley", "Carla Neal", 0,  0, 0));
		nameList.add(new FamilyClass("Kirk Hurley", "Tracy Scott", 0,  0, 0));
		nameList.add(new FamilyClass("Kirk Hurley", "Marvin Vang", 96,  2, 0));
		nameList.add(new FamilyClass("Kirk Hurley", "Simran Wilkins", 0,  0, 0));
		nameList.add(new FamilyClass("Kirk Hurley", "Levison Randall", 0,  0, 0));
		nameList.add(new FamilyClass("Kirk Hurley", "Lylah Puckett", 0,  0, 0));
		nameList.add(new FamilyClass("Kirk Hurley", "Alexandru Duran", 0,  0, 0));
		nameList.add(new FamilyClass("Kirk Hurley", "Rees Partridge", 115,  1, 1));
		nameList.add(new FamilyClass("Kirk Hurley", "Kyla Everett", 0,  0, 0));
		nameList.add(new FamilyClass("Kirk Hurley", "Shaun Wyatt", 0,  0, 0));
		nameList.add(new FamilyClass("Aayush Butt", "Troy Jarvis", 0,  0, 0));
		nameList.add(new FamilyClass("Aayush Butt", "Raya Alexander", 0,  0, 0));
		nameList.add(new FamilyClass("Aayush Butt", "Carla Neal", 0,  0, 0));
		nameList.add(new FamilyClass("Aayush Butt", "Tracy Scott", 274,  3, 0));
		nameList.add(new FamilyClass("Aayush Butt", "Marvin Vang", 30,  2, 1));
		nameList.add(new FamilyClass("Aayush Butt", "Simran Wilkins", 0,  0, 0));
		nameList.add(new FamilyClass("Aayush Butt", "Levison Randall", 322,  2, 1));
		nameList.add(new FamilyClass("Aayush Butt", "Lylah Puckett", 0,  0, 0));
		nameList.add(new FamilyClass("Aayush Butt", "Alexandru Duran", 0,  0, 0));
		nameList.add(new FamilyClass("Aayush Butt", "Rees Partridge", 364,  1, 1));
		nameList.add(new FamilyClass("Aayush Butt", "Kyla Everett", 0,  0, 0));
		nameList.add(new FamilyClass("Aayush Butt", "Shaun Wyatt", 188,  3, 1));
		nameList.add(new FamilyClass("Troy Jarvis", "Raya Alexander", 300,  3, 1));
		nameList.add(new FamilyClass("Troy Jarvis", "Carla Neal", 232,  1, 0));
		nameList.add(new FamilyClass("Troy Jarvis", "Tracy Scott", 0,  0, 0));
		nameList.add(new FamilyClass("Troy Jarvis", "Marvin Vang", 60,  3, 1));
		nameList.add(new FamilyClass("Troy Jarvis", "Simran Wilkins", 203,  3, 0));
		nameList.add(new FamilyClass("Troy Jarvis", "Levison Randall", 404,  3, 1));
		nameList.add(new FamilyClass("Troy Jarvis", "Lylah Puckett", 25,  1, 1));
		nameList.add(new FamilyClass("Troy Jarvis", "Alexandru Duran", 0,  0, 0));
		nameList.add(new FamilyClass("Troy Jarvis", "Rees Partridge", 0,  0, 0));
		nameList.add(new FamilyClass("Troy Jarvis", "Kyla Everett", 0,  0, 0));
		nameList.add(new FamilyClass("Troy Jarvis", "Shaun Wyatt", 0,  0, 0));
		nameList.add(new FamilyClass("Raya Alexander", "Carla Neal", 200,  3, 1));
		nameList.add(new FamilyClass("Raya Alexander", "Tracy Scott", 0,  0, 0));
		nameList.add(new FamilyClass("Raya Alexander", "Marvin Vang", 0,  0, 0));
		nameList.add(new FamilyClass("Raya Alexander", "Simran Wilkins", 488,  2, 0));
		nameList.add(new FamilyClass("Raya Alexander", "Levison Randall", 0,  0, 0));
		nameList.add(new FamilyClass("Raya Alexander", "Lylah Puckett", 80,  1, 0));
		nameList.add(new FamilyClass("Raya Alexander", "Alexandru Duran", 0,  0, 0));
		nameList.add(new FamilyClass("Raya Alexander", "Rees Partridge", 275,  3, 1));
		nameList.add(new FamilyClass("Raya Alexander", "Kyla Everett", 0,  0, 0));
		nameList.add(new FamilyClass("Raya Alexander", "Shaun Wyatt", 150,  1, 0));
		nameList.add(new FamilyClass("Carla Neal", "Tracy Scott", 417,  3, 0));
		nameList.add(new FamilyClass("Carla Neal", "Marvin Vang", 0,  0, 0));
		nameList.add(new FamilyClass("Carla Neal", "Simran Wilkins", 0,  0, 0));
		nameList.add(new FamilyClass("Carla Neal", "Levison Randall", 118,  1, 0));
		nameList.add(new FamilyClass("Carla Neal", "Lylah Puckett", 0,  0, 0));
		nameList.add(new FamilyClass("Carla Neal", "Alexandru Duran", 0,  0, 0));
		nameList.add(new FamilyClass("Carla Neal", "Rees Partridge", 0,  0, 0));
		nameList.add(new FamilyClass("Carla Neal", "Kyla Everett", 0,  0, 0));
		nameList.add(new FamilyClass("Carla Neal", "Shaun Wyatt", 0,  0, 0));
		nameList.add(new FamilyClass("Tracy Scott", "Marvin Vang", 0,  0, 0));
		nameList.add(new FamilyClass("Tracy Scott", "Simran Wilkins", 0,  0, 0));
		nameList.add(new FamilyClass("Tracy Scott", "Levison Randall", 0,  0, 0));
		nameList.add(new FamilyClass("Tracy Scott", "Lylah Puckett", 117,  3, 1));
		nameList.add(new FamilyClass("Tracy Scott", "Alexandru Duran", 0,  0, 0));
		nameList.add(new FamilyClass("Tracy Scott", "Rees Partridge", 197,  3, 1));
		nameList.add(new FamilyClass("Tracy Scott", "Kyla Everett", 0,  0, 0));
		nameList.add(new FamilyClass("Tracy Scott", "Shaun Wyatt", 0,  0, 0));
		nameList.add(new FamilyClass("Marvin Vang", "Simran Wilkins", 123,  3, 1));
		nameList.add(new FamilyClass("Marvin Vang", "Levison Randall", 296,  3, 0));
		nameList.add(new FamilyClass("Marvin Vang", "Lylah Puckett", 0,  0, 0));
		nameList.add(new FamilyClass("Marvin Vang", "Alexandru Duran", 329,  2, 0));
		nameList.add(new FamilyClass("Marvin Vang", "Rees Partridge", 0,  0, 0));
		nameList.add(new FamilyClass("Marvin Vang", "Kyla Everett", 0,  0, 0));
		nameList.add(new FamilyClass("Marvin Vang", "Shaun Wyatt", 271,  2, 1));
		nameList.add(new FamilyClass("Simran Wilkins", "Levison Randall", 322,  2, 0));
		nameList.add(new FamilyClass("Simran Wilkins", "Lylah Puckett", 0,  0, 0));
		nameList.add(new FamilyClass("Simran Wilkins", "Alexandru Duran", 0,  0, 0));
		nameList.add(new FamilyClass("Simran Wilkins", "Rees Partridge", 0,  0, 0));
		nameList.add(new FamilyClass("Simran Wilkins", "Kyla Everett", 185,  2, 0));
		nameList.add(new FamilyClass("Simran Wilkins", "Shaun Wyatt", 0,  0, 0));
		nameList.add(new FamilyClass("Levison Randall", "Lylah Puckett", 22,  2, 1));
		nameList.add(new FamilyClass("Levison Randall", "Alexandru Duran", 324,  2, 1));
		nameList.add(new FamilyClass("Levison Randall", "Rees Partridge", 0,  0, 0));
		nameList.add(new FamilyClass("Levison Randall", "Kyla Everett", 0,  0, 0));
		nameList.add(new FamilyClass("Levison Randall", "Shaun Wyatt", 0,  0, 0));
		nameList.add(new FamilyClass("Lylah Puckett", "Alexandru Duran", 0,  0, 0));
		nameList.add(new FamilyClass("Lylah Puckett", "Rees Partridge", 0,  0, 0));
		nameList.add(new FamilyClass("Lylah Puckett", "Kyla Everett", 0,  0, 0));
		nameList.add(new FamilyClass("Lylah Puckett", "Shaun Wyatt", 203,  1, 1));
		nameList.add(new FamilyClass("Alexandru Duran", "Rees Partridge", 0,  0, 0));
		nameList.add(new FamilyClass("Alexandru Duran", "Kyla Everett", 0,  0, 0));
		nameList.add(new FamilyClass("Alexandru Duran", "Shaun Wyatt", 0,  0, 0));
		nameList.add(new FamilyClass("Rees Partridge", "Kyla Everett", 439,  3, 1));
		nameList.add(new FamilyClass("Rees Partridge", "Shaun Wyatt", 0,  0, 0));
		nameList.add(new FamilyClass("Kyla Everett", "Shaun Wyatt", 0,  0, 0));

		
	}

}


class FamilyClass{
	
	private String fromName;
	private String toName;
	private int length;
	private int strength;
	private int family;
	
	
	public FamilyClass(String fromName, String toName, int length, int strength, int family) {
		super();
		this.fromName = fromName;
		this.toName = toName;
		this.length = length;
		this.strength = strength;
		this.family = family;
	}


	public String getFromName() {
		return fromName;
	}


	public void setFromName(String fromName) {
		this.fromName = fromName;
	}


	public String getToName() {
		return toName;
	}


	public void setToName(String toName) {
		this.toName = toName;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public int getStrength() {
		return strength;
	}


	public void setStrength(int strength) {
		this.strength = strength;
	}


	public int getFamily() {
		return family;
	}


	public void setFamily(int family) {
		this.family = family;
	}
	
	

	
	
	
	
}