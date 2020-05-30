package _06_Pixel_Art_Save_State;

	import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
import java.io.EOFException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

	public class PixArtMaker implements MouseListener, ActionListener{
		private JFrame window;
		private JButton savebutton;
		private JButton newbutton;
		private GridInputP gip;
		private GridP gp;
		ColorSelect csp;
		SaveWithSerialize sws;
		
		public void start() {
			window = new JFrame("Pixel Art");
			window.setLayout(new FlowLayout());
			window.setResizable(false);			
			
			
			try {
				sws = new SaveWithSerialize();
				gp = sws.LoadGrid();
				window.add(gp);
				csp = new ColorSelect();
				window.add(csp);
				gp.repaint();
				gp.addMouseListener(this);
				
				newbutton = new JButton("New");
				newbutton.addActionListener(this);
				window.add(newbutton);
				
				savebutton = new JButton("Save");
				savebutton.addActionListener(this);
				window.add(savebutton);		
				
				window.pack();
				
			} catch (NullPointerException e) {
				gip = new GridInputP(this);	
				window.add(gip);
				
				newbutton = new JButton("New");
				newbutton.addActionListener(this);
				
				savebutton = new JButton("Save");
				savebutton.addActionListener(this);
			}
			
			window.pack();
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setVisible(true);
			
		}

		public void submitGridData(int w, int h, int r, int c) {
			gp = new GridP(w, h, r, c);
			csp = new ColorSelect();
			window.remove(gip);
			window.add(gp);
			window.add(csp);
			gp.repaint();
			gp.addMouseListener(this);
			
			window.add(newbutton);
			window.add(savebutton);	
			
			window.pack();
		}
		
		public static void main(String[] args) {
			new PixArtMaker().start();
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
				sws.SaveGrid(gp);
				System.out.println("saved");
			}
			
			if (e.getSource() == newbutton) {
				try {
					FileWriter fw = new FileWriter("src/_06_Pixel_Art_Save_State/Saved");
					
					fw.write("");
						
					fw.close();
				} catch (IOException b) {
					b.printStackTrace();
				}
				
				System.out.println("cleared, begin start");
				
				window.dispose();
				start();
			}
		}
	
}


 //Copyright © 2020 Rachel Yang