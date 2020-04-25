package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other
	 * data and converting it back into text that you or the computer can read
	 * and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back
	 * up, at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is
	 * decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and
	 * decrypts the message, then display it to the user in a JOptionPane.
	 */


	public static void main(String[] args) {
		FileDecryptor fd1 = new FileDecryptor();
		fd1.MessageDecryptor();
	}

	public void MessageDecryptor() {
		String msg = "";		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/Encrypt"));
			
			String line = br.readLine();
			while(line != null){
				msg = line;
				line = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Character c = msg.charAt(1);
		String tempkey = c.toString();
		int key = Integer.parseInt(tempkey);
		
		Character[] alphabetLC = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		Character[] alphabetUC = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

		String decryptedmsg = "";
		for (int i = 0; i < msg.length(); i++) {
			System.out.println(msg.charAt(i));
			boolean lettercheck = false;
			boolean found = false;

			for (int j = 0; j < alphabetLC.length; j++) {
				if (msg.charAt(i) == alphabetLC[j]) {
					if (j - key + 1 > alphabetLC.length) {
						decryptedmsg = decryptedmsg + alphabetLC[(j - key) - alphabetLC.length];
						lettercheck = true;
						found = true;
						break;
					} else if (j - key < 0) {
						decryptedmsg = decryptedmsg + alphabetLC[alphabetLC.length - j - key];
						lettercheck = true;
						found = true;
						break;
					} else {
						decryptedmsg = decryptedmsg + alphabetLC[j - key];
						lettercheck = true;
						found = true;
						break;
					}
				}
			}

			if (!found) {
				for (int j = 0; j < alphabetUC.length; j++) {
					if (msg.charAt(i) == alphabetUC[j]) {
						if (j - key + 1 > alphabetUC.length) {
							decryptedmsg = decryptedmsg + alphabetUC[(j - key) - alphabetUC.length];
							lettercheck = true;
							break;
						} else if (j - key < 0) {
							/*itwasactuallydoingmath a - (b-c) = a - b + c*/
							decryptedmsg = decryptedmsg + alphabetUC[alphabetUC.length - j - key];
							lettercheck = true;
							break;
						} else {
							decryptedmsg = decryptedmsg + alphabetUC[j - key];
							lettercheck = true;
							break;
						}
					}
				}
			}

			if (!lettercheck) {
				decryptedmsg = decryptedmsg + msg.charAt(i);
			}
		}
		
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/Decrypt", true);

			fw.write("\n" + decryptedmsg + "\n");
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "Your decrypted message is: " + decryptedmsg);
	}
}