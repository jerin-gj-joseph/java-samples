package com.jerin.test;

import org.apache.commons.codec.binary.Hex;

public class AESSample {

	public static void main(String[] args) {
		String encryptedValue = AES1.encrypt("This is a top secret.", "test");
		System.out.println(encryptedValue);
		
		
		byte[] cipher = AES1.encryptToBytes("This is a top secret.", "test");
		
        System.out.print("cipher :  ");
        for (int i = 0; i < cipher.length; i++) {
            // System.out.print(new Integer(cipher[i]) + " ");
            byte b = cipher[i];
            System.out.print(String.format("%02x", b & 0xFF) + " ");

        }
        
		byte[] cipher1 = AES1.encryptToBytes("This is a top secret.", "test");

		System.out.println();
        System.out.print("cipher1:  ");
        String a = "";
        for (int i = 0; i < cipher1.length; i++) {
            // System.out.print(new Integer(cipher[i]) + " ");
            byte b = cipher1[i];
            
            a+= String.format("%02x", b & 0xFF);
            System.out.print(String.format("%02x", b & 0xFF));

        }
        System.out.println();
        System.out.println(a);
        
		System.out.println("Hex: "+Hex.encodeHexString(cipher1));

        

		
	}

}
