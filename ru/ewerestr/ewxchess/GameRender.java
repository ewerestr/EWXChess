package ru.ewerestr.ewxchess;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class GameRender extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private GameRender instance;
	public GameRender(){
		System.out.println("GameRender has been started");
		this.setPreferredSize(new Dimension(EWXChess.getGame().getWeight(),EWXChess.getGame().getHeight()));
		JFrame fr = new JFrame("EWXChess");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLayout(new BorderLayout());
		fr.add(this, BorderLayout.CENTER);
		fr.pack();
		fr.setResizable(true);
		fr.setVisible(true);
		//addKeyListener(new KeyInputHandler());
		EWXChess.getGame().write("KeyController has been handled");
		start();
	}
	public void start()
	{
		EWXChess.getGame().run();
		instance = this;
		new Thread(this).start();
	}
	public void run(){
		long ltim = System.currentTimeMillis();
		long delta;
		while(EWXChess.getGame().isRunning() == true){
			delta = System.currentTimeMillis() - ltim;
			ltim = System.currentTimeMillis();
			EWXChess.getGame().update(delta);
			render();
		}
	}
	public void render()
	{
		BufferStrategy bs = getBufferStrategy();
		if (bs == null)
		{
			createBufferStrategy(2);
			requestFocus();
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		//int i = 1;
		for (DrawObject bl : EWXChess.getGame().getDrawableList())
		{
			//System.out.println("DrawObject" + i++ + " ID:" + bl.getID() + " x:" + bl.getX() + " y:" + bl.getY());
			EWXChess.getGame().getTexture(bl.getID()).draw(g, bl.getX(), bl.getY());
		}
		//ystem.out.println();
		bs.show();
//			if(EWXChess.getGame().hasAliveBullets()){
//				List<GameBullet> bg = EWXChess.getGame().getAliveBullets();
//				int mns = 0, ls;
//				for(int i = 0; i < bg.size(); i++){
//					GameBullet blt = bg.get(i);
//					EWXChess.getGame().getTexture(blt.getTexture()).draw(g, blt.getX(), blt.getY());
//					if(blt.getX() < 0 || blt.getY() < 0 || blt.getX() > EWXChess.getGame().getWeight() || blt.getY() > EWXChess.getGame().getHeight()){
//						ls = i;
//						if(i+mns >= ls){
//							EWXChess.getGame().disposeBullet(i-mns);
//						}else EWXChess.getGame().disposeBullet(i);
//						mns++;
//					}
//					blt.update();
//				}
//			}
//			g.dispose();
//			bs.show();
//		}
	}
	public void setRunning(boolean bool){
		
	}
//	private class KeyInputHandler extends KeyAdapter{
//		public void keyPressed(KeyEvent e){
//			if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) EWXChess.getGame().setPressed(0, true);
//			if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) EWXChess.getGame().setPressed(2, true);
//			if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) EWXChess.getGame().setPressed(1, true);
//			if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) EWXChess.getGame().setPressed(3, true);
//		}
//		public void keyReleased(KeyEvent e){
//			if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) EWXChess.getGame().setPressed(0, false);
//			if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) EWXChess.getGame().setPressed(2, false);
//			if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) EWXChess.getGame().setPressed(1, false);
//			if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) EWXChess.getGame().setPressed(3, false);
//		}
//	}
}
