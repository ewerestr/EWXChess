package ru.ewerestr.ewxchess;

import java.awt.Graphics;
import java.awt.Image;

public class GameSprite {
	private Image img;
	public GameSprite(Image image){
		img = image;
	}
	public int getWidth(){
		return img.getWidth(null);
	}
	public int getHeight(){
		return img.getHeight(null);
	}
	public void draw(Graphics g, int x, int y){
		g.drawImage(img, x, y, null);
	}
}
