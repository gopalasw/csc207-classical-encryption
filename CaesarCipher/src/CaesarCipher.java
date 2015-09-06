import java.util.Scanner;

public class CaesarCipher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Would you like to encode or decode a message? ");
		Scanner input1 = new Scanner(System.in);
		String cryptType = input1.nextLine();

		//checks if the input is valid (encode or decode)
		if(cryptType.equals("encode") || cryptType.equals("decode")) {
			System.out.print("Enter the string to " + cryptType + " : ");
			Scanner input2 = new Scanner(System.in);
			String message = input2.nextLine();
			crypt(message, cryptType);
			input2.close();
		}
		else
			System.out.println("The only valid options are \"encode\" or \"decode\".");
		
		input1.close();
	}

	public static void crypt(String message, String cryptType) {
		//if the cryptType is encode, then key is positive
		if(cryptType.equals("encode")) {
			for(int key = 0; key < 26; key++) {
				System.out.print("\n" + "n = " + key + ": ");
				for(int i = 0; i < message.length(); i++) {
					System.out.print(codeChar(message.charAt(i), key));
				}
			}
		}
		//if the cryptType is decode, then key is negative
		else {
			for(int key = 0; key < 26; key++) {
				System.out.print("\n" + "n = " + key + ": ");
				for(int i = 0; i < message.length(); i++) {
					System.out.print(codeChar(message.charAt(i), -key));
				}
			}
		}
	}

	//this method encrypts/decrypts each character by key.
	public static char codeChar(char c, int key) {

		int base = (int) 'a';
		int convertedChar = (int) c - base;
		int changedChar = convertedChar + key;
		if(changedChar > 25) {
			changedChar = changedChar%26;
		}
		else if(changedChar < 0) {
			changedChar = (changedChar%26) + 26;
		}

		char finalChar = (char) (changedChar + base);
		return finalChar;

	}

}
