package application;

/**
 * 
 * @author John Mobarry for CMSC203 
 * This class is used to take input messages and convert them into a secret message by the use of an index
 * The Caesar Cypher uses a specific index and offsets the characters in the message by the defined index.
 * The Bellaso Cipher uses a bellasoStr index to offset the characters in the message according to the ASCII
 * value of the corresponding letter in the bellasoStr, which is repeated to correspond to the length of the plain text
 * The Caesar and Bellaso Cyphers also are then decrypted to return the original input from the encrypted message
 */

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		//throw new RuntimeException("method not implemented");
		
		//Defined variables
		boolean isValid = true;
		
		
		//Loop
		for (int i=0; i < plainText.length(); i++) {
			//Variable for loop
			char a = plainText.charAt(i);
			
			//Checks
			
			if(a< LOWER_BOUND || a> UPPER_BOUND) {
				isValid = false;
			}		
		}
		
		return isValid; //returns that the string is in fact in bounds if character is not above or below the bounds
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		//throw new RuntimeException("method not implemented");
		//Variables
		
		String encrypted = ""; //Initializes the encrypted string as empty
		key%=RANGE;
		int size = plainText.length();
		for (int i=0; i < size; i++) {
			int cip = (int)plainText.charAt(i)+ key;
			while (cip > UPPER_BOUND) {
				cip-=RANGE;
			}
			encrypted += (char) cip;
		}
		return encrypted;
		}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		
		//Variables
		String encrypted = "";
		int bl = bellasoStr.length();
		int ub = (int) UPPER_BOUND;
		
		//Loops
		
		for (int i =0; i < plainText.length(); i++) {
			//Variables
			char a = plainText.charAt(i);
			int cipher = (int) a + (int)bellasoStr.charAt(i % bl); 
			
			while (cipher>ub) {
				cipher -= RANGE;
			}
			encrypted += (char) cipher;
		}
		
	return encrypted;	
		
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		//throw new RuntimeException("method not implemented");
		
		//Variables
		String decrypted = "";
		key%=RANGE;
		int size = encryptedText.length();
		for(int i= 0; i < size; i++) {
			int cip = (char)(encryptedText.charAt(i)-key);
			while (cip < LOWER_BOUND) {
				cip+=RANGE;
			}
			decrypted += (char)cip;
		}
		return decrypted; 
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		
		String decrypted = "";
		int bl = bellasoStr.length();
		int lowerb = (int) LOWER_BOUND;
		
		for  (int i=0; i < encryptedText.length(); i++) {
			
			char a = encryptedText.charAt(i);
			int decr = (int)a - (int)bellasoStr.charAt(i % bl);
			
			while(decr < lowerb) {
				decr += RANGE;
			}
			decrypted += (char)decr;
		
		}
		
		return decrypted;
		
	}
}