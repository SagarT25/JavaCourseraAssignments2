import edu.duke.*;
public class CaesarCipher {
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
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
    
    /* Write the method encryptTwoKeys that has three parameters,
     *  a String named input, and two integers named key1 and key2. 
     *  This method returns a String that has been encrypted using the following algorithm. 
     *  Parameter key1 is used to encrypt every other character with the Caesar Cipher algorithm, 
     *  starting with the first character, and key2 is used to encrypt every other character, 
     *  starting with the second character. 
     *  For example, the call encryptTwoKeys(“First Legion”, 23, 17) should return “Czojq Ivdzle”. 
     *  Note the ‘F’ is encrypted with key 23, the first ‘i’ with 17, the ‘r’ with 23, and the ‘s’ with 17, etc.
     *   Be sure to test this method.*/
    public String encryptTwoKeys(String input, int key1, int key2) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet with key1
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
      //Compute the shifted alphabet with key2
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
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

    public void testCaesar() {
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);    	
    }
    
    public static void main(String args[]) {
    	CaesarCipher cc = new CaesarCipher();
    	//Uncomment the testCaesar to test from File
    	//cc.testCaesar(); 
    	System.out.println(cc.encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
    	// encrypt("First Legion", 23) should return "Cfopq Ibdflk"
    	System.out.println(cc.encrypt("First Legion", 23));
    	//encrypt("First Legion", 17) should return "Wzijk Cvxzfe"
    	System.out.println(cc.encrypt("First Legion", 17));
    	// the call encryptTwoKeys("First Legion", 23, 17) should return "Czojq Ivdzle"
    	System.out.println(cc.encryptTwoKeys("First Legion", 23, 17));
    	String practice = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
    	System.out.println(cc.encrypt(practice, 15));
    	System.out.println(cc.encryptTwoKeys(practice, 8 ,21));
    }    
}