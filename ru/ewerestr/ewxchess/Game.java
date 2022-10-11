package ru.ewerestr.ewxchess;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

public class Game{
	private List<String> _texturebinding = new ArrayList<String>();
	private List<DrawObject> _board = new ArrayList<DrawObject>();
	private GameSprite[] _textures;
	private GameBoard _gboard;
	private int _tilesize = 96;
	private boolean _running = false;
	private int W = 768;
	private int H = 768;
	@SuppressWarnings("unused")
	private byte ah = 0;
	@SuppressWarnings("unused")
	private ConsoleManager mng;
	
	public Game()
	{
		loadTextures();
		buildBoard();
		_gboard = new GameBoard();
	}
	
	private void buildBoard()
	{
		boolean white = true;
		for (int i = 0; i < 8; i++)
		{
			for (int o = 0; o < 8; o++)
			{
				_board.add(new DrawObject(_texturebinding.indexOf(white ? "w_tile" : "b_tile"), i*_tilesize, o*_tilesize, false));
				if (o != 7) white = !white;
			}
		}
	} //ENDPOINT
	
	private void loadTextures()
	{
		List<String> q = _texturebinding = getTextureList();
		_textures = new GameSprite[q.size()];
		for (int i = 0; i < q.size(); i++) _textures[i] = getSprite(q.get(i) + ".png");
	}
	
	public GameSprite getTexture(String texname)
	{
		return _textures[_texturebinding.indexOf(texname.toLowerCase())];
	}
	
	public GameSprite getTexture(int id)
	{
		return _textures[id];
	}
	
	public int resolveFigureToTexture(int figureId)
	{
		if (figureId > 0 && figureId <= 12)
		{
			return figureId + 6;
		}
		return -1;
	}

	public void start()
	{
		new Thread(new GameRender());
		new Thread(new ConsoleManager());
		//_running = true;
	}
	
	public int getWeight()
	{
		return W;
	}
	
	public int getHeight()
	{
		return H;
	}
	
	public int getTileSize()
	{
		return _tilesize;
	}
	
	public List<DrawObject> getDrawableList()
	{
		List<DrawObject> fdraw = _board;
		for (GameObject g : _gboard.getMatrix())
		{
			if (g.canConvert()) fdraw.add(g.toDrawObject());
		}
		return fdraw;
	}
	
	public boolean isRunning()
	{
		return _running;
	}
	
	public void run()
	{
		_running = true;
	}
	
	public void stop()
	{
		_running = false;
	}
	
	public void write(String ss)
	{
		System.out.println(ss);
	}
	
	private GameSprite getSprite(String path)
	{
		BufferedImage bi = null;
		try
		{
			URL url = getClass().getClassLoader().getResource(path);
			bi = ImageIO.read(url);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		GameSprite spr = new GameSprite(Toolkit.getDefaultToolkit().createImage(bi.getSource()));
		return spr;
	}
	
	public void update(long d)
	{
//		if(!cm && (lp || rp || up || dp)){
//			//int vb = p.c;
//			if(lp && (p.x > 0)){
//				p.x -= 3;
//				lp = !lp;
//			}
//			if(rp && (p.x+p2 < WDT)){
//				p.x += 3;
//				rp = !rp;
//			}
//			if(up && (p.y > 0)){
//				p.y -= 3;
//				up = !up;
//			}
//			if(dp && (p.y+p1 < HGT)){
//				p.y += 3;
//				dp = !dp;
//			}
//			cm = !cm;
//		}
	}
	
	private List<String> getTextureList()
	{
		List<String> texturelist = new ArrayList<String>();
		texturelist.add("w_tile");
		texturelist.add("b_tile");
		texturelist.add("selector");
		texturelist.add("w_tile_cbu");
		texturelist.add("b_tile_cbu");
		texturelist.add("mark_cbu");
		texturelist.add("tile_ua");
		texturelist.add("w_king");
		texturelist.add("w_queen");
		texturelist.add("w_bishop");
		texturelist.add("w_knight");
		texturelist.add("w_rook");
		texturelist.add("w_pawn");
		texturelist.add("b_king");
		texturelist.add("b_queen");
		texturelist.add("b_bishop");
		texturelist.add("b_knight");
		texturelist.add("b_rook");
		texturelist.add("b_pawn");
		return texturelist;
	}
}
