package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void main(String[] args) {
		/*
		 * The following is an example of how to list all of the files in a
		 * directory. Once the program is running, the directory is chosen using
		 * the JFileChooser.
		 */
		int checkedfilescount = 0;
		
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File directory = jfc.getSelectedFile();
			File[] files = directory.listFiles();

			if (files != null) {
				for (File f : files) {
					System.out.println(f.getName());
//					boolean isDirectory = true;

					if (f.isDirectory() == true) {						
						File folder = new File(f.getPath());
						File[] listOfFiles = folder.listFiles();

						for (File file : listOfFiles) {
						    if (file.getName().contains(".java")) {
						    	try {
									FileWriter fw = new FileWriter(file.getPath(), true);

									fw.write("\n\n //Copyright © 2020 Rachel Yang");
									checkedfilescount+=1;
									System.out.println("check");

									fw.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
									
						    } 
						}

					} else {
						if (f.getName().contains(".java")) {
							try {
								FileWriter fw = new FileWriter(f.getPath(), true);

								fw.write("\n\n //Copyright © 2020 Rachel Yang");
								checkedfilescount+=1;
								System.out.println("check");

								fw.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		/*
		 * Your task is to write a program that iterates through the src folder
		 * of this current Java Project. For every .java file it finds, the
		 * program will add a (non-legally binding) copyright statement at the
		 * bottom. Be aware of possible directories inside of directories. (e.g
		 * //Copyright © 2019 FirstName LastName)
		 */
			
		}
	}
}


 //Copyright © 2020 Rachel Yang


//NOTES: to do it with the "infinite" iteration, you would need to use a recursive formula to 
//have the method call itself until there are no more directories
//*************RECURSIVE***************