package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	
	public static void main(String[] args) {
		FileEncryptor fe1 = new FileEncryptor();
		fe1.MessageEncryptor();
	}
	
	public void MessageEncryptor() {
		String msg = JOptionPane.showInputDialog("Please enter in the message you wish to encrypt:");
		String tempkey = JOptionPane.showInputDialog("Enter in the key you wish to use to encrypt your message: (only integers)");
		int key = Integer.parseInt(tempkey);
		
		Character[] alphabetLC = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		Character[] alphabetUC = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		
		String encryptedmsg = "";
		for (int i = 0; i < msg.length(); i++) {
			boolean lettercheck = false;
			boolean found = false;
			
			if (msg.charAt(i).toUpperCase == true) {
				
			}
			for (int j = 0; j < alphabetLC.length; j++) {
				if (msg.charAt(i) == alphabetLC[j]) {					
					if (j+key > alphabetLC.length) {
						encryptedmsg = encryptedmsg + alphabetLC[(j+key)-alphabetLC.length];
						lettercheck = true;
						found = true;
						break;
					} else if (j+key < 0) {
						encryptedmsg = encryptedmsg + alphabetLC[alphabetLC.length-(j+key)];
						lettercheck = true;
						found = true;
						break;
					} else {
						encryptedmsg = encryptedmsg + alphabetLC[j+key];
						lettercheck = true;
						found = true;
						break;
					}
					
				} 
			} 
			
			if (!lettercheck) {
				encryptedmsg = encryptedmsg + msg.charAt(i);
			}
		}
		
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/Encrypt", true);
		
			fw.write("\n" + encryptedmsg + "\n");
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
}
