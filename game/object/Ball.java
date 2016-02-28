package game.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.main.Game;
import game.main.Handler;

public class Ball extends GameObject {

	public static int SIZE;
	
	private Handler handler;
	private Game game;
	
	public Ball(Handler handler, Game game){
		this.handler = handler;
		this.game = game;
		x = 4;
		y = 8;
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		
		g.fillOval((int) x * Game.WIDTH_UNIT - SIZE / 2, (int) y * Game.HEIGHT_UNIT - SIZE / 2, SIZE, SIZE);
	}
	
	public void moveTo(double x2, double y2){
		if(Handler.canMove(x, y, x2, y2)){
			boolean b = !Handler.canMoveFurther(x2, y2);
			handler.add(new Move(x, y, x2, y2));
			this.x = x2;
			this.y = y2;
			handler.checkWin();
			if(b) game.swapTurn();
		}
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x * Game.WIDTH_UNIT - SIZE / 2, (int) y * Game.HEIGHT_UNIT - SIZE / 2, SIZE, SIZE);
	}

}
