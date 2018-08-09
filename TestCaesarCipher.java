import edu.duke.FileResource;

public class TestCaesarCipher {
	
	//Include the methods countLetters and maxIndex that you wrote in the previous lesson.
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
	 * This method should read in a file as a String, create a CaesarCipher object with key 18, 
	 * encrypt the String read in using the CaesarCipher object, print the encrypted String, and 
	 * decrypt the encrypted String using the decrypt method.	 * 
	 */
	public void simpleTests() {
		FileResource resource = new FileResource("textfilesdata/smallHamlet.txt");
		String message = resource.asString();
		CaesarCipherOO cc = new CaesarCipherOO(15);
		String encrypted =  cc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");
		System.out.println("The encrypted string is "+ encrypted);
		System.out.println("The decrypted string is "+ cc.decrypt(encrypted));
		
		/* In the simpleTests method, add a call to breakCaesarCipher on the 
		 * encrypted String to decrypt it automatically by determining the key, 
		 * and print the decrypted String.		 * 
		 */
		breakCaesarCipher(encrypted);
	}
	
	/* Write the method breakCaesarCipher that has one String parameter named input. 
	 * This method should figure out which key was used to encrypt this message 
	 * (in a similar manner as the previous lesson), then create a CaesarCipher object 
	 * with that key and decrypt the message.	 * 
	 */
	public void breakCaesarCipher(String input) {
		int[] freqs = countLetters(input);
		int maxDex = maxIndex(freqs);
		System.out.println("The mx occuring letter is at index "+ maxDex);
		int dKey = maxDex - 4;		
		if (maxDex < 4) {
			dKey = 26 - (4 - maxDex);
		}
		System.out.println("The decryption key is " + dKey);
		CaesarCipherOO cc = new CaesarCipherOO(dKey);
		System.out.println("The decrypted string is "+ cc.decrypt(input));
	}

	public static void main(String[] args) {
		TestCaesarCipher tcc = new TestCaesarCipher();
		tcc.simpleTests();
	}

}
