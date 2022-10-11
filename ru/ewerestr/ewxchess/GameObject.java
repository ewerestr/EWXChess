package ru.ewerestr.ewxchess;

public class GameObject 
{
	private int _id;
	private int _x;
	private int _y;
	
	public GameObject(int id, int x, int y)
	{
		_id = id;
		_x = x;
		_y = y;
	}
	
	public int getId()
	{
		return _id;
	}
	
	public int getX()
	{
		return _x;
	}
	
	public int getY()
	{
		return _y;
	}
	
	public boolean canConvert()
	{
		return (_id > 0 && _id <= 12) ? true : false;
	}
	
	public DrawObject toDrawObject()
	{
		return new DrawObject(EWXChess.getGame().resolveFigureToTexture(_id), _x*EWXChess.getGame().getTileSize(), _y*EWXChess.getGame().getTileSize(), true);
	}
}
