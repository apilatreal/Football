package game.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.main.Game;

public class Helper extends GameObject{
	
	public static int SIZE;
	
	private boolean display;

	public Helper(double x, double y, boolean display){
		this.x = x;
		this.y = y;
		this.display = display;
	}

	@Override
	public void render(Graphics g) {
		if(!display) return;
		
		g.setColor(Color.BLACK);
		
		g.fillOval((int) x * Game.WIDTH_UNIT - SIZE / 2, (int) y * Game.HEIGHT_UNIT - SIZE / 2, SIZE, SIZE);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x * Game.WIDTH_UNIT - SIZE / 2, (int) y * Game.HEIGHT_UNIT - SIZE / 2, SIZE, SIZE);
	}
	
}
