
public class CaesarCipherTwo {	
	/* Include private fields for the alphabet, shiftedAlphabet1, and shiftedAlphabet2.*/
	private String alphabet;
	private String shiftedAlphabet1;
	private String shiftedAlphabet2;
	private int mainKey1;
	private int mainKey2;

	/* Write a constructor CaesarCipherTwo that has two int parameters key1 and key2. 
	 * This method should initialize all the private fields.
	 */
	CaesarCipherTwo (int key1, int key2){
		mainKey1 = key1;
		mainKey2 = key2;
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
		shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
	}	
	
	/* Write an encrypt method that has one String parameter named input. 
	 * This method returns a String that is the input encrypted using the two shifted alphabets.
	 */
	 public String encrypt(String input) {
	        //Make a StringBuilder with message (encrypted)
	        StringBuilder encrypted = new StringBuilder(input);
	        //Count from 0 to < length of encrypted, (call it i)
	        for(int i = 0; i < encrypted.length(); i++) {
	            //Look at the ith character of encrypted (call it currChar)
	            char currChar = encrypted.charAt(i);
	            //Find the index of currChar in the alphabet (call it idx)
	            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
	            //If currChar is in the alphabet
	            if(idx != -1){
	                //Get the idxth character of shiftedAlphabet1 or shiftedAlphabet2 (newChar)
	            	char newChar;
	            	if (i%2 ==0) {
	            		newChar = shiftedAlphabet1.charAt(idx);
	            	}
	            	else {
	            		newChar = shiftedAlphabet2.charAt(idx);
	            	}                
	                if (Character.isLowerCase(currChar)) {
	                	newChar = Character.toLowerCase(newChar);
	                }
	                //Replace the ith character of encrypted with newChar
	                encrypted.setCharAt(i, newChar);
	            }
	            //Otherwise: do nothing
	        }
	        //Your answer is the String inside of encrypted
	        return encrypted.toString();
	    }
	 
	 /* Write a decrypt method that has one String parameter named input. 
	  * This method returns a String that is the encrypted String decrypted using the 
	  * key1 and key2 associated with this CaesarCipherTwo object. 
	  * You might want to add more private fields to the class.
	  */
		public String decrypt(String input) {
			CaesarCipherTwo cc = new CaesarCipherTwo(26 - mainKey1, 26 - mainKey2);
			return cc.encrypt(input);
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
