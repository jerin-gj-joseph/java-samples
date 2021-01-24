package com.jerin.test;

import org.apache.commons.codec.digest.DigestUtils;

public class SHA256Hash {

	public static String getHashString(String stringText) {
		String sha256hex = DigestUtils.sha256Hex(stringText);  
		return sha256hex;
	}

	public static void main(String[] args) {
		System.out.println(getHashString("Jerin"));
		System.out.println(getHashString("George"));
		System.out.println(getHashString("Jerin"));

	}
	
	
}
