package ru.ewerestr.ewxchess;

public class EWXChess
{
	private static Game _game;
	
	public static void main(String[] args)
	{
		System.out.println("EWXChess v1.0 has been started");
		//check commands
		_game = new Game();
		_game.start();
	}
	public static boolean isInt(String z)
	{
		try
		{
			Integer.parseInt(z);
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
	
	public static Game getGame()
	{
		return _game;
	}
}
