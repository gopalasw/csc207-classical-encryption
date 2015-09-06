import java.util.Scanner;

public class VigenereCipher {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Would you like to encode or decode a message? ");
		Scanner input1 = new Scanner(System.in);
		String cryptType = input1.nextLine();

		//checks if the input is valid (encode or decode) and takes in a message and key phrase
		if(cryptType.equals("encode") || cryptType.equals("decode")) {
			System.out.print("Enter the string to " + cryptType + " : ");
			Scanner input2 = new Scanner(System.in);
			String message = input2.nextLine();
			System.out.print("Enter the key : ");
			Scanner input3 = new Scanner(System.in);
			String key = input3.nextLine();
			crypt(message, key, cryptType);
			input2.close();
			input3.close();
		}
		else
			System.out.println("The only valid options are \"encode\" or \"decode\".");

		input1.close();
	}

	//this method loops through each char in the message (cipher/plaintext) and 
	//the corresponding key character.
	public static void crypt(String message, String key, String cryptType) {
		for(int i = 0; i < message.length(); i++) {
			System.out.print(codeChar(message.charAt(i), key.charAt(i%key.length()), cryptType));
		}
	}

	//This method, if its encode adds char c to char keyChar; if its decode, it subtracts.
	public static char codeChar(char c, char keyChar, String cryptType) {

		int base = (int) 'a';
		int convertedChar = (int) c - base;
		int convertedKey = (int) keyChar - base;
		int changedChar;

		if(cryptType.equals("encode")) {
			changedChar = convertedChar + convertedKey;
		}
		else {
			changedChar = convertedChar - convertedKey;
		}

		//This wraps around changedChar to ensure its within the boundries of 0-25
		if(changedChar > 25) {
			changedChar = changedChar%26;
		}
		else if(changedChar < 0) {
			changedChar = (changedChar%26) + 26;
		}
		//now it converts changedChar from an integer to a character and returns it.
		char finalChar = (char) (changedChar + base);
		return finalChar;

	}

}



