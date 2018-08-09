import edu.duke.FileResource;

public class TestCaesarCipherTwo {
	/* Create the TestCaesarCipherTwo class with the following parts:
In the simpleTests method, add a call to breakCaesarCipher on the encrypted String to decrypt it automatically by determining the keys, and then print the decrypted String.
 * 
 */
	/* Include the methods halfOfString, countLetters, 
	 * and maxIndex that you wrote in the previous lesson.
	 */
	private String halfOfString(String message, int start) {
		
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
	
	private int[] countLetters(String message) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int[] counts = new int[26];
		for (int k = 0; k < message.length(); k++) {
			char ch = Character.toLowerCase(message.charAt(k));
			int dex = alphabet.indexOf(ch);
			if (dex != -1) {
				counts[dex] += 1;
			}
		}
		/*for (int k = 0 ; k<counts.length; k++) {
			System.out.println("Print Letter count["+alphabet.charAt(k)+"] = "+counts[k]);
		}*/
		return counts;
	}
	
	public int maxIndex(int[] arrayOfLetterCounts) {
		int maxLetterOccurence = 0;
		int maxValue = -1;
		for (int k=0; k < arrayOfLetterCounts.length; k++) {
			if (arrayOfLetterCounts[k] > arrayOfLetterCounts[maxLetterOccurence] ) {
				maxLetterOccurence = k;
				maxValue = arrayOfLetterCounts[k];
			}
		}
		return maxLetterOccurence;
	}

	/* Write the void method simpleTests that has no parameters. 
	 * This method should read in a file as a String, create a CaesarCipherTwo object with 
	 * keys 17 and 3, encrypt the String using the CaesarCipherTwo object, print the encrypted 
	 * String, and decrypt the encrypted String using the decrypt method.
	 */
	public void simpleTests() {
		FileResource resource = new FileResource("textfilesdata/mysteryTwoKeysQuiz.txt");
		String message = resource.asString();
		CaesarCipherTwo cc = new CaesarCipherTwo(21,8);
		String encrypted =  cc.encrypt(message);
		System.out.println("The encrypted string is "+ encrypted);
		System.out.println("The decrypted string is "+ cc.decrypt(encrypted));
		
		breakCaesarCipher(encrypted);
	}

	/* Write the method breakCaesarCipher that has one String parameter named input. 
	 * This method should figure out which keys were used to encrypt this message 
	 * (in a similar manner as before), then create a CaesarCipherTwo object with that key 
	 * and decrypt the message.
	 */
	public int getKey(String s) {
		int[] freqs = countLetters(s);
		int maxDex = maxIndex(freqs);
		//System.out.println("The mx occuring letter is at index "+ maxDex);
		int dKey = maxDex - 4;		
		if (maxDex < 4) {
			dKey = 26 - (4 - maxDex);
		}
		//System.out.println("The decryption key is " + dKey);
		return dKey;		
	}	
	
	public void breakCaesarCipher(String input) {
		String encrypted1 = halfOfString(input,0);
		String encrypted2 = halfOfString(input,1);
		int dKey1 = getKey(encrypted1);
		int dKey2 = getKey(encrypted2);
		System.out.println("The decryption keys are " + dKey1 +" and "+ dKey2);
		CaesarCipherTwo cc = new CaesarCipherTwo(dKey1,dKey2);
		System.out.println("The decrypted string is "+ cc.decrypt(input));
	}	
	
	public static void main(String[] args) {
		TestCaesarCipherTwo tcct = new TestCaesarCipherTwo();
		tcct.simpleTests();
	}

}
