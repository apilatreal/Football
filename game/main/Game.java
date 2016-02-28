package game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game.event.MoveListener;
import game.object.Ball;
import game.object.Helper;

public class Game extends Canvas implements Runnable{

	public static int WIDTH, WIDTH_UNIT;
	public static int HEIGHT, HEIGHT_UNIT;
	
	static{
		Game.WIDTH = 600;
		Game.HEIGHT = 800;
		Helper.SIZE = 5;
		Ball.SIZE = 10;
		
		WIDTH_UNIT = WIDTH / 8;
		HEIGHT_UNIT = HEIGHT / 16;
	}
	
	private static final long serialVersionUID = 1L;

	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	private Ball ball;
	
	private int turn = 0;
	
	public Game(){
		handler = new Handler(this);
		handler.add(ball = new Ball(handler, this));
		addMouseListener(new MoveListener(handler, ball));
		new Window("Football", WIDTH, HEIGHT, this);
	}
	
	public void init(){
		GameInitializer.fieldInit(handler);
		GameInitializer.helperPointInit(handler);
	}
	
	public void start(){
		thread = new Thread(this);
		running = true;
		init();
		thread.start();
	}
	
	@Override
	public void run() {
		long time = System.nanoTime();
		float fps = 60;
		double ns = 1000000000 / fps;
		while(running){
			if(System.nanoTime() - time > ns){
				render();
			}
		}
	}
	
	public void stop(){
		try{
			thread.join();
		} catch(Throwable ignore){}
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(2);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		if(turn == 0){
			g.setFont(new Font(null, Font.PLAIN, 32));
			g.setColor(Color.RED);
			g.drawString("Player 1", WIDTH/2-60, 35);
			g.setColor(Color.BLACK);
			g.drawString("Player 2", WIDTH/2-60, HEIGHT-70);
		} else if(turn == 1){
			g.setFont(new Font(null, Font.PLAIN, 32));
			g.setColor(Color.BLACK);
			g.drawString("Player 1", WIDTH/2-60, 35);
			g.setColor(Color.RED);
			g.drawString("Player 2", WIDTH/2-60, HEIGHT-70);
		}
		
		handler.render(g);	
		
		g.dispose();
		bs.show();
	}
	
	public void swapTurn(){
		if(turn == 0){
			turn = 1;
		} else if(turn == 1){
			turn = 0;
		}
	}
	
	public static void main(String[] args){
		new Game();
	}
	
}
