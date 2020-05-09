package _06_Pixel_Art_Save_State;

	import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

	public class kde implements MouseListener, ActionListener{
		private JFrame window;
		private JButton savebutton;
		private ewfa gip;
		private ejhf gp;
		bruh csp;
		
		public void start() {
			gip = new ewfa(this);	
			window = new JFrame("Pixel Art");
			window.setLayout(new FlowLayout());
			window.setResizable(false);
			
			window.add(gip);
			window.pack();
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setVisible(true);
			
			savebutton = new JButton("Save");
			savebutton.setSize(50, 70);
			savebutton.setLocation(ejhf.WIDTH-60, ejhf.HEIGHT);
			savebutton.addActionListener(this);
			window.add(savebutton);

		}

		public void submitGridData(int w, int h, int r, int c) {
			gp = new ejhf(w, h, r, c);
			csp = new bruh();
			window.remove(gip);
			window.add(gp);
			window.add(csp);
			gp.repaint();
			gp.addMouseListener(this);
			
			window.pack();
		}
		
		public static void main(String[] args) {
			new kde().start();
		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			gp.setColor(csp.getSelectedColor());
			System.out.println(csp.getSelectedColor());
			gp.clickPixel(e.getX(), e.getY());
			gp.repaint();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == savebutton) {
				try {
					FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt");
					
					fw.
						
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	
}
