package com.jerin.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

public class FindFileKey {

	private String fileName = "C:\\Jerin\\conf\\words.txt";
	
	private String cipherFromQuestion = "8d20e5056a8d24d0462ce74e4904c1b513e10d1df4a2ef2ad4540fae1ca0aaf9";
	
	private String textToEncrypt = "This is a top secret.";

	public static void main(String[] args) {
		
		FindFileKey find = new FindFileKey();
		find.process();
		
		

	}
	
	private void process() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				// read next line
				line = reader.readLine();
				
				if(isEmpty(line)) {
					continue;
				}
				
				String paddedLine = StringUtils.rightPad(line, 10);
				//byte[] cipher = AES1.encryptToBytes("This is a top secret.", paddedLine);
				String encryptedString = getEncryptedString(textToEncrypt, paddedLine);
				
				System.out.println(encryptedString);
				System.out.println(cipherFromQuestion);
				
				if(cipherFromQuestion.equalsIgnoreCase(encryptedString)) {
					System.out.println("#################  String found #############.  Key: "+paddedLine);
					break;
				}

			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static boolean isEmpty(String str) {
		if(str!=null && str.trim().length()>0) {
			return false;
		}
		return true;
	}
	
	private String getEncryptedString(String text, String key) {
		byte[] cipher1 = AES1.encryptToBytes(text, key);
		
		Hex h = new Hex();
		//h.decode(cipher1);
		

		//System.out.println();
        //System.out.print("cipher1:  ");
        String a = "";
        for (int i = 0; i < cipher1.length; i++) {
            // System.out.print(new Integer(cipher[i]) + " ");
            byte b = cipher1[i];
            
            a+= String.format("%02x", b & 0xFF);
            //System.out.print(String.format("%02x", b & 0xFF));

        }
        //System.out.println();
        //System.out.println(a);
        return a;
	}

}
