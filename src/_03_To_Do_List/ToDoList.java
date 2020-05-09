package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task,
	 * save list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task
	 * and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt
	 * the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the
	 * user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */

	public static void main(String[] args) {
		ToDoList tdl1 = new ToDoList();
		tdl1.autoSaveLast();
		tdl1.createUI();
	}
	
	//String lastfileloc = "";
	public void autoSaveLast() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/ToDoList"));
			
			String line = br.readLine();
			while(line != null){
				list.add(line);
				line = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException i) {
			// TODO Auto-generated catch block
			i.printStackTrace();
		}
	}

	JFrame frame;
	JPanel panel;
	JButton add;
	JButton view;
	JButton remove;
	JButton save;
	JButton load;

	ArrayList<String> list = new ArrayList<String>();

	public void createUI() {
		frame = new JFrame();
		panel = new JPanel();
		add = new JButton();
		view = new JButton();
		remove = new JButton();
		save = new JButton();
		load = new JButton();

		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		frame.add(panel);
		frame.setTitle("To-Do List");
		frame.setSize(600, 110);

		add.setText("Add Task");
		add.addActionListener(this);

		view.setText("View Task");
		view.addActionListener(this);

		remove.setText("Remove Task");
		remove.addActionListener(this);

		save.setText("Save List");
		save.addActionListener(this);

		load.setText("Load List");
		load.addActionListener(this);

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			String input = JOptionPane.showInputDialog("Add task to to-do list:");
			list.add(input);
		}
		
		if (e.getSource() == view) {
			String format = "";
			for (int i = 0; i < list.size(); i++) {
				format+= "(" + (i+1) + ") " + list.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, format);
		}
		
		if (e.getSource() == remove) {
			String input = JOptionPane.showInputDialog("Choose which task to remove: (either by number or exact task title)");
			input.trim();
			try {
				int tasknum = Integer.parseInt(input);
				list.remove(tasknum);
			} catch (NumberFormatException c) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).equals(input)) {
						list.remove(i);
					}
				}  
			} catch (IndexOutOfBoundsException c) {
				CustomException.Error();
			}
		}
		
		if (e.getSource() == save) {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/ToDoList", true);
				
				for (int j = 0; j < list.size(); j++) {
					fw.write("(" + (j+1) + ") " + list.get(j) + "\n");
				}
				fw.close();
				
			} catch (IOException i) {
				i.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Saved.");
		}
		
		if (e.getSource() == load) {
			String input = JOptionPane.showInputDialog("Enter the location of the file you wish to load:");
			
			try {
				BufferedReader br = new BufferedReader(new FileReader(input));
				
				String line = br.readLine();
				while(line != null){
					list.add(line);
					line = br.readLine();
				}
				
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException i) {
				// TODO Auto-generated catch block
				i.printStackTrace();
			}
			
			lastfileloc = input;
		}
	}
}
