package game.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BorderLine extends GameObject {

	private int width, height;
	
	public BorderLine(double x, double y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		
		g.fillRect((int) x, (int) y, width, height);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, width, height);
	}

}
