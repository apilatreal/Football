package game.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.main.Game;

public class Move extends GameObject{

	private double x2, y2;
	
	public Move(double x1, double y1, double x2, double y2){
		this.x = x1;
		this.y = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);

		g.drawLine((int) x * Game.WIDTH_UNIT, (int) y * Game.HEIGHT_UNIT, (int) x2 * Game.WIDTH_UNIT, (int) y2 * Game.HEIGHT_UNIT);
	}
	
	public void setX2(double x2){ this.x2 = x2; }
	public double getX2(){ return x2; }
	public void setY2(double y2){ this.y2 = y2; }
	public double getY2(){ return y2; }

	@Override
	public Rectangle getBounds() {
		return null;
	}
	
}
