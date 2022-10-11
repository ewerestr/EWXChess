package ru.ewerestr.ewxchess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
0	nothing
1	w_king
2	w_queen
3	w_bishop
4	w_knight
5	w_rook
6	w_pawn
7	b_king
8	b_queen
9	b_bishop
10	b_knight
11	b_rook
12	b_pawn
 */
public class GameBoard {
	private int[][] _boardmatrix = new int[8][8]; // first - horz, second - vert
	
	public GameBoard()
	{
		placeFigures((50 >= new Random().nextInt(100) ? true : false));
	}
	
	private void placeFigures(boolean color)
	{
		set('A',1,"rook",color);
		set('B',1,"knight",color);
		set('C',1,"bishop",color);
		set('D',1,color ? "king" : "queen",color);
		set('E',1,color ? "queen" : "king",color);
		set('F',1,"bishop",color);
		set('G',1,"knight",color);
		set('H',1,"rook",color);
		for(int i = 1; i < 9; i++) set(i,2,"pawn",color);
		set('A',8,"rook",!color);
		set('B',8,"knight",!color);
		set('C',8,"bishop",!color);
		set('D',8,color ? "king" : "queen",!color);
		set('E',8,color ? "queen" : "king",!color);
		set('F',8,"bishop",!color);
		set('G',8,"knight",!color);
		set('H',8,"rook",!color);
		for(int i = 1; i < 9; i++) set(i,7,"pawn",!color);
	}
	
	private void set(char horz, int vert, String figure, boolean color) // true - white
	{
		_boardmatrix[resolveOrdinate(horz)][vert-1] = resolveFigure(figure, color);
	}
	
	private void set(int horz, int vert, String figure, boolean color) // true - white
	{
		_boardmatrix[horz-1][vert-1] = resolveFigure(figure, color);
	}
	
	private void spawn(char horz, int vert, String figure, int col) // for debug
	{
		set(horz, vert, figure, col==1 ? true : false);
	}
	
	private void spawn(int horz, int vert, String figure, int col) // for debug
	{
		set(horz, vert, figure, col==1 ? true : false);
	}
	
	public List<GameObject> getMatrix()
	{
		List<GameObject> objlist = new ArrayList<GameObject>();
		for (int i = 0; i < 8; i++)
		{
			for (int o = 0; o < 8; o++)
			{
				objlist.add(new GameObject(_boardmatrix[i][o], i, o));
			}
		}
		return objlist;
	}
	
	private byte resolveOrdinate(char ord)
	{
		switch (ord)
		{
			case 'A':
			case 'a':
			{
				return 0;
			}
			case 'B':
			case 'b':
			{
				return 1;
			}
			case 'C':
			case 'c':
			{
				return 2;
			}
			case 'D':
			case 'd':
			{
				return 3;
			}
			case 'E':
			case 'e':
			{
				return 4;
			}
			case 'F':
			case 'f':
			{
				return 5;
			}
			case 'G':
			case 'g':
			{
				return 6;
			}
			case 'H':
			case 'h':
			{
				return 7;
			}
			default:
			{
				return 0;
			}
		}
	}
	
	private int resolveFigure(String name, boolean col)
	{
		switch (name)
		{
			case "king":
			{
				return (col ? 1 : 7);
			}
			case "queen":
			{
				return (col ? 2 : 8);
			}
			case "bishop":
			{
				return (col ? 3 : 9);
			}
			case "knight":
			{
				return (col ? 4 : 10);
			}
			case "rook":
			{
				return (col ? 5 : 11);
			}
			case "pawn":
			{
				return (col ? 6 : 12);
			}
			default:
			{
				return 0;
			}
		}
	}
}
