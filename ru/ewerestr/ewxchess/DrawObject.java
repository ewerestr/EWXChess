package ru.ewerestr.ewxchess;

public class DrawObject {
	private int ID;
	private boolean r;
	private int x;
	private int y;
	public DrawObject(int id0,int x0,int y0,boolean r0){
		ID = id0;
		x = x0;
		y = y0;
		r = r0;
	}
	public int getID(){
		return ID;
	}
	public boolean isTrans(){
		return r;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}
