package _06_Pixel_Art_Save_State;

import java.awt.Color;
import java.io.Serializable;

public class Pix implements Serializable {
	public int x;
	public int y;
	public Color color;
	
	public Pix(int x, int y) {
		this.x = x;
		this.y = y;
		color = Color.WHITE;
	}
}


 //Copyright © 2020 Rachel Yang