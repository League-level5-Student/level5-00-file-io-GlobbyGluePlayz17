package _03_To_Do_List;

import javax.swing.JOptionPane;

public class CustomException extends Exception {
	static void Error() {
		JOptionPane.showMessageDialog(null, "Error. Please try again.");
	}
}
