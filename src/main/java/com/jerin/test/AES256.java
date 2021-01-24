package com.jerin.test;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AES256 {
	
	public static String SECRET_KEY_FACTORY_ALGORITHM = "PBKDF2WithHmacSHA256"; //Reference: https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#SecretKeyFactory
	public static String AES_ALGORITHM                = "AES";      // Algorithm Used
	public static String CIPHER_TRANSFORMATION        = "AES/CBC/PKCS5Padding";  //AES Algorithm, with Cipher Block Chaining (CBC) 
	
	public static int ITERATION_COUNT = 1500;   // Iteration count 
	public static int KEY_LENTH       = 128;     //AES Key Length (AES-265)

	
    //private static byte[] initializationVector = new byte[16];
	private static byte[] initializationVector = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private static IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);

    
	public static byte[] encryptToBytes(String stringToEncrypt, String encryptionKey, String salt) 
	{
	    try
	    {
	        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(SECRET_KEY_FACTORY_ALGORITHM);
	        KeySpec keySpec = new PBEKeySpec(encryptionKey.toCharArray(), salt.getBytes(), ITERATION_COUNT, KEY_LENTH);

	        SecretKey generatedSecretKey = secretKeyFactory.generateSecret(keySpec);
	        SecretKeySpec secretKeySpec = new SecretKeySpec(generatedSecretKey.getEncoded(), AES_ALGORITHM);
	         
	        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
	        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
	        
	        return cipher.doFinal(stringToEncrypt.getBytes("UTF-8"));
	        //return Base64.getEncoder().encodeToString(cipher.doFinal(stringToEncrypt.getBytes("UTF-8")));
	    } 
	    catch (Exception e) 
	    {
	        System.out.println("Error while encrypting: " + e.toString());
	    }
	    return null;
	}
    
	public static String encrypt(String stringToEncrypt, String encryptionKey, String salt) 
	{
	    try
	    {
	        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(SECRET_KEY_FACTORY_ALGORITHM);
	        KeySpec keySpec = new PBEKeySpec(encryptionKey.toCharArray(), salt.getBytes(), ITERATION_COUNT, KEY_LENTH);

	        SecretKey generatedSecretKey = secretKeyFactory.generateSecret(keySpec);
	        SecretKeySpec secretKeySpec = new SecretKeySpec(generatedSecretKey.getEncoded(), AES_ALGORITHM);
	         
	        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
	        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
	        return Base64.getEncoder().encodeToString(cipher.doFinal(stringToEncrypt.getBytes("UTF-8")));
	    } 
	    catch (Exception e) 
	    {
	        System.out.println("Error while encrypting: " + e.toString());
	    }
	    return null;
	}
	
	public static String decrypt(String stringToDecrypt, String encryptionKey, String salt) {
	    try
	    {
	        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(SECRET_KEY_FACTORY_ALGORITHM);
	        KeySpec keySpec = new PBEKeySpec(encryptionKey.toCharArray(), salt.getBytes(), ITERATION_COUNT, KEY_LENTH);

	        SecretKey generatedSecretKey = secretKeyFactory.generateSecret(keySpec);
	        SecretKeySpec secretKeySpec = new SecretKeySpec(generatedSecretKey.getEncoded(), AES_ALGORITHM);
	         
	        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
	        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
	        return new String(cipher.doFinal(Base64.getDecoder().decode(stringToDecrypt)));
	    } 
	    catch (Exception e) {
	        System.out.println("Error while decrypting: " + e.toString());
	    }
	    return null;
	}
	

	public static void main(String[] args) 
	{
		long startTime = System.currentTimeMillis();
		String secretKey = "asdfsdafd";
		String salt = "fdsfd";
		
		for(int i=0;i<100;i++) {

	    String originalString = "howtasdfodoinjava.com";
	     
	    String encryptedString = AES256.encrypt(originalString, secretKey, salt) ;
	    String decryptedString = AES256.decrypt(encryptedString, secretKey, salt) ;
	    
		}
	    
	    long endTime = System.currentTimeMillis();
	    System.out.println("Time Taken in Secs: "+(endTime - startTime));
	    
		/*System.out.println(originalString);
		System.out.println(encryptedString);
		System.out.println(decryptedString);*/
	    
	    
	}
}
