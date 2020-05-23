package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		FileRecorder fr1 = new FileRecorder();
		fr1.userInputSaver();
	}
	
	public void userInputSaver() {
		String msg = JOptionPane.showInputDialog("How is the weather today?");
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/test2.txt", true);
			
			fw.write("\n" + msg + "\n");
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


 //Copyright © 2020 Rachel Yang