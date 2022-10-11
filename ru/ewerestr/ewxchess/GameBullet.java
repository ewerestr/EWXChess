package ru.ewerestr.ewxchess;

public class GameBullet{
	private String t;
	private int x;
	private int y;
	private byte d;
	private byte m;
	private byte s;
	public GameBullet(String t0, int x0, int y0, byte d0, byte m0, byte s0){
		t = t0;
		x = x0;
		y = y0;
		d = d0;
		m = m0;
		s = s0;
	}
	public String getTexture(){
		return t;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void update(){
		switch(d){
		case 0:
			x -= s;
			break;
		case 1:
			y -= s;
//			if(y < 0) Game.disposeBullet(this);
			break;
		case 2:
			x += s;
//			if(x > Game.getHeight()) Game.disposeBullet(this);
			break;
		case 3:
			y += s;
//			if(y > Game.getWeight()) Game.disposeBullet(this);
			break;
		}
	}
	public byte getDamage(){
		return m;
	}
}
