
public class CaesarBreaker {
	/* Complete the decryption method shown in the lesson by creating a CaesarBreaker class
	 * with the methods countLetters, maxIndex, and decrypt. Recall that the decrypt method 
	 * creates a CaesarCipher object in order to use the encrypt method you wrote for the 
	 * last lesson. Make sure that your CaesarCipher class is in the same folder as 
	 * CaesarBreaker! You may want to use the following code as part of your decrypt method.
	 * CaesarCipher cc = new CaesarCipher();
	 * String message = cc.encrypt(encrypted, 26 - key);	 * 
	 */
	
	public int[] countLetters(String message) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int[] counts = new int[26];
		for (int k = 0; k < message.length(); k++) {
			char ch = Character.toLowerCase(message.charAt(k));
			int dex = alphabet.indexOf(ch);
			if (dex != -1) {
				counts[dex] += 1;
			}
		}
		for (int k = 0 ; k<counts.length; k++) {
			System.out.println("Print Letter count["+alphabet.charAt(k)+"] = "+counts[k]);
		}
		return counts;
	}
	
	public int maxIndex(int[] arrayOfLetterCounts) {
		int maxLetterOccurence = -1;
		int maxValue = -1;
		for (int k=0; k < arrayOfLetterCounts.length; k++) {
			if (arrayOfLetterCounts[k] > maxValue ) {
				maxLetterOccurence = k;
				maxValue = arrayOfLetterCounts[k];
			}
		}
		return maxLetterOccurence;
	}
	
	public String decrypt(String encrypted) {
		CaesarCipher cc = new CaesarCipher();
		int[] freqs = countLetters(encrypted);
		int maxDex = maxIndex(freqs);
		System.out.println("The mx occuring letter is at index "+ maxDex);
		int dKey = maxDex - 4;
		
		if (maxDex < 4) {
			dKey = 26 - (4 - maxDex);
		}
		System.out.println("The decryption key is " + dKey);
		return cc.encrypt(encrypted, 26 - dKey);
	}

	
	/*Write a testDecrypt method in the CaesarBreaker class that prints the decrypted message, 
	 * and make sure it works for encrypted messages that were encrypted with one key.	 * 
	 */
	
	public void testDecrypt() {
		
		System.out.println("Half of String Xifqvximt tsdtlxzrx iijirvtl ek Uybi is "+ halfOfString("Xifqvximt tsdtlxzrx",0)+ " and "+ halfOfString("Xifqvximt tsdtlxzrx",1));
		//System.out.println("The decrypted message is "+ decrypt("WIVV TRBV ZE KYV TFEWVIVETV IFFD!"));
		
		System.out.println("Decryption with two keys for message Akag tjw Xibhr awoa aoee xakex znxag xwko = " + decryptTwoKeys("Akag tjw Xibhr awoa aoee xakex znxag xwko"));
		System.out.println("Decryption with two keys for message lfa = "+ decryptTwoKeys("lfa"));
		//System.out.println("Half of Strinf Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu is "+ halfOfString("Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu", 0));
		//System.out.println("The decrypted message is "+ decrypt("Gp  bqpok feiq cbbbbbbbbb"));
		

	}
	
	/* Write the method halfOfString in the CaesarBreaker class that has two parameters, 
	 * a String parameter named message and an int parameter named start. This method should 
	 * return a new String that is every other character from message starting with the start 
	 * position. For example, the call halfOfString(“Qbkm Zgis”, 0) returns the String “Qk gs” 
	 * and the call halfOfString(“Qbkm Zgis”, 1) returns the String “bmZi”. Be sure to test this 
	 * method with a small example.	 * 
	 */
	public String halfOfString(String message, int start) {
		
		StringBuilder halfString = new StringBuilder("");
		for (int k = 0; k < message.length(); k++) {
			//For odd locations like 1, 3, etc in a word, index starts at 0 an even position 
			if (start%2 == 0 && k%2==0) {
				halfString.append(message.charAt(k));
				//halfString.setCharAt(k, message.charAt(k));
				//System.out.println(halfString.toString());
			}
			// For even locations like 2, 4, etc. in a word , index starts at 1 an odd position
			else if (start%2 == 1 && k%2==1) {
				halfString.append(message.charAt(k));
			}
		}
		return halfString.toString();
	}	
	
	/* Write the method getKey in the CaesarBreaker class that has one parameter, a String s. 
	 * This method should call countLetters to get an array of the letter frequencies in String s 
	 * and then use maxIndex to calculate the index of the largest letter frequency, which is the 
	 * location of the encrypted letter ‘e’, which leads to the key, which is returned. 
	 */
	public int getKey(String s) {
		int[] freqs = countLetters(s);
		int maxDex = maxIndex(freqs);
		System.out.println("The mx occuring letter is at index "+ maxDex);
		int dKey = maxDex - 4;		
		if (maxDex < 4) {
			dKey = 26 - (4 - maxDex);
		}
		System.out.println("The decryption key is " + dKey);
		return dKey;
		
	}
	
	/* Write the method decryptTwoKeys in the CaesarBreaker class that has one parameter, 
	 * a String parameter named encrypted that represents a String that was encrypted with the 
	 * two key algorithm discussed in the previous lesson. This method attempts to determine the 
	 * two keys used to encrypt the message, prints the two keys, and then returns the decrypted 
	 * String with those two keys. More specifically, this method should  
	 * - Calculate a String of every other character starting with the first character of the 
	 * encrypted String by calling halfOfString.
	 * - Calculate a String of every other character starting with the second character of the 
	 * encrypted String.
	 * - Then calculate the key used to encrypt each half String.
	 * - You should print the two keys found.
	 * - Calculate and return the decrypted String using the encryptTwoKeys method from your 
	 * CaesarCipher class, again making sure it is in the same folder as your CaesarBreaker class.
	 */
	
	public String decryptTwoKeys (String encrypted) {
		CaesarCipher cc = new CaesarCipher();
		/*for (int k = 0; k < 26; k++) {
			System.out.println(cc.encrypt("Xifqvximt",26 - k));
		}
		
		for (int k = 0; k < 26; k++) {
			System.out.println(cc.encrypt("tsdtlxzrx", 26 -k));
		}
		*/
		/*for (int k = 0; k < 26; k++) {
			for (int j = 0; j < 26; j++){
			System.out.println(k +" and "+ j +" form "+ cc.encryptTwoKeys("Xifqvximt",26 - k, 26 - j));
			}
			}*/
		//int key1,key2;
		//String string1 = halfOfString("Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu",0);
		//System.out.println(string1);
		//key1 = getKey(halfOfString(encrypted,0));
		//System.out.println("The encrypted String is "+cc.encryptTwoKeys("Just a test string with lots of eeeeeeeeeeeeeeeees", 23, 2));
		System.out.println("The encrypted String is "+cc.encryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx", 26-2, 26-20));
		
		System.out.println("The encrypted String is "+cc.encryptTwoKeys("Xifqvximt tsdtlxzrx iijirvtl ek Uybi", 26-17, 26-4));
		String decryptedString = cc.encryptTwoKeys(encrypted,26-getKey(halfOfString(encrypted,0)), 26-getKey(halfOfString(encrypted,1)));
		return decryptedString; 
	}
	
    public static void main(String args[]) {
    	CaesarBreaker cb = new CaesarBreaker();
    	cb.testDecrypt();
    	//System.out.println("The decrypted message is "+ cb.decrypt("WIVV TRBV ZE KYV TFEWVIVETV IFFD!"));
    }  

}
