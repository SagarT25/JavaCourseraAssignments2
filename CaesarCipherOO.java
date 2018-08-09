
public class CaesarCipherOO {
	
	private String alphabet;
	private String shiftedAlphabet;
	private int mainKey;
	
	/* Write a constructor CaesarCipher that has one int parameter key. 
	 * This method should initialize all the private fields of the class. 
	 */
	CaesarCipherOO (int key){
		mainKey = key;
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
	}

	/* Write an encrypt method that has one String parameter named input. 
	 * This method returns a String that is the input encrypted using shiftedAlphabet.
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
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
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
	 * This method returns a String that is the encrypted String decrypted using the key 
	 * associated with this CaesarCipher object. One way to do this is to create another 
	 * private field mainKey, which is initialized to be the value of key. 
	 * Then you can create a CaesarCipher object within decrypt: CaesarCipher cc = new CaesarCipher(26 - mainKey); 
	 * and call cc.encrypt(input).
	 */
	public String decrypt(String input) {
		CaesarCipherOO cc = new CaesarCipherOO(26 - mainKey);
		return cc.encrypt(input);
	}
}
