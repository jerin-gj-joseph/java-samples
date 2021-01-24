package com.jerin.test;

public class GeneratePassword {

	public static void main(String[] args) {
		
		
		for(int i=0;i<100;i++) {
		//System.out.println(gp.getRandomNumber(0, 10));
			System.out.println(generatePassword(20));
		}
		
		
        //String lowerCaseChars = "abcdefgijkmnopqrstwxyz";
        //System.out.println(lowerCaseChars.substring(4,5));
		
		//System.out.println(gp.generatePassword(8));

	}

	
	private static String generatePassword(int passwordMinLength) {

        String lowerCaseChars = "abcdefgijkmnopqrstwxyz";
        String upperCaseChars = "ABCDEFGHJKLMNPQRSTWXYZ";
        String numericChars = "23456789";
        String specialChars = "*$-+?_&=!%{}/";
        
        String strArr[] = new String[4];
        strArr[0]=lowerCaseChars;
        
        boolean lowerCaseUsed = false;
        boolean upperCaseUsed = false;
        boolean numericUsed = false;
        boolean specialUsed = false;
        
        String password = "";
        
        int i=0;
        while(i<passwordMinLength) {
            int randomIndex = getRandomNumber(0,3);
            String library = "";
            switch(randomIndex) {
            case 0:
            	library = lowerCaseChars;
            	lowerCaseUsed = true;
            	break;
            case 1:
            	library = upperCaseChars;
            	upperCaseUsed = true;
            	break;
            case 2:
            	library = numericChars;
            	numericUsed = true;
            	break;
            case 3: 
            	library = specialChars;
            	specialUsed = true;
            	break;
            }
            i++;
            
            int randomSubStr = getRandomNumber(0, (library.length()-1));
            
            String passwordChar = library.substring(randomSubStr, randomSubStr+1);
            
            password += passwordChar;
        }
        
		if (!lowerCaseUsed) {
			int randomSubStr = getRandomNumber(0, (lowerCaseChars.length() - 1));
			String passwordChar = lowerCaseChars.substring(randomSubStr, randomSubStr + 1);
			password += passwordChar;
		}

		if (!upperCaseUsed) {
			int randomSubStr = getRandomNumber(0, (upperCaseChars.length() - 1));
			String passwordChar = upperCaseChars.substring(randomSubStr, randomSubStr + 1);
			password += passwordChar;
		}

		if (!numericUsed) {
			int randomSubStr = getRandomNumber(0, (numericChars.length() - 1));
			String passwordChar = numericChars.substring(randomSubStr, randomSubStr + 1);
			password += passwordChar;
		}
		
		if (!specialUsed) {
			int randomSubStr = getRandomNumber(0, (specialChars.length() - 1));
			String passwordChar = specialChars.substring(randomSubStr, randomSubStr + 1);
			password += passwordChar;
		}
        
        
        
        return password;
        
        
        		
        

	}
	
	
	private  static int getRandomNumber(int min, int max) {
		return min + (int)(Math.random() * ((max - min) + 1));

	}
}
