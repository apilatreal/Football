package game.event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import game.main.Game;
import game.main.Handler;
import game.object.Ball;
import game.object.GameObject;
import game.object.Helper;

public class MoveListener extends MouseAdapter {
	
	private Handler handler;
	private Ball ball;
	
	public MoveListener(Handler handler, Ball ball){
		this.handler = handler;
		this.ball = ball;
	}
	
	@Override
	public void mousePressed(MouseEvent e){
		int x = e.getX();
		int y = e.getY();
		
		for(int i = 0; i < handler.getObjects().size(); i++){
			GameObject temp = handler.getObjects().get(i);
			if(!(temp instanceof Helper)) continue;
			
			int fixedX = (int) (temp.getX() * Game.WIDTH_UNIT);
			int fixedY = (int) (temp.getY() * Game.HEIGHT_UNIT);
			
			if(Math.abs(x - fixedX) < 10 && Math.abs(y - fixedY) < 10){
				double distance = Math.sqrt(Math.pow(Math.abs(temp.getX() - ball.getX()), 2) + Math.pow(Math.abs(temp.getY() - ball.getY()), 2));
				if(distance > 0 && distance < 2){
					ball.moveTo(temp.getX(), temp.getY());
				}
			}
		}
	}
	
}
