package game.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import game.object.Ball;
import game.object.BorderLine;
import game.object.GameObject;
import game.object.Move;

public class Handler {

	private static List<GameObject> objects;
	private Game game;
	
	public Handler(Game game){
		objects = new LinkedList<GameObject>();
		this.game = game;
	}
	
	public void render(Graphics g){
		for(int i = 0; i < objects.size(); i++)
			objects.get(i).render(g);
	}
	
	public static boolean canMove(double x, double y, double x2, double y2){
		if(x == x2 && y == y2) return false;
		if(x == 2 && y == 2 && x2 == 3 && y2 == 1) return false;
		if(x == 6 && y == 2 && x2 == 5 && y2 == 1) return false;
		if(x == 2 && y == 14 && x2 == 3 && y2 == 15) return false;
		if(x == 6 && y == 14 && x2 == 5 && y2 == 15) return false;
		
		for(int i = 0; i < objects.size(); i++){
			GameObject temp = objects.get(i);
			if(temp instanceof Move){
				Move move = (Move) temp;
				if(move.getX() == x && move.getY() == y && move.getX2() == x2 && move.getY2() == y2) return false;
				if(move.getX() == x2 && move.getY() == y2 && move.getX2() == x && move.getY2() == y) return false;
			} else if(temp instanceof BorderLine){
				if(temp.getBounds().intersects(new Rectangle((int)x * Game.WIDTH_UNIT, (int)y * Game.HEIGHT_UNIT, 1, 1)) && temp.getBounds().intersects(new Rectangle((int)x2*Game.WIDTH_UNIT, (int)y2*Game.HEIGHT_UNIT, 1, 1))) return false;
			}
		}
		return true;
	}
	
	public static boolean canMoveFurther(double x, double y){
		for(int i = 0; i < objects.size(); i++){
			GameObject temp = objects.get(i);
			if(temp instanceof Move){
				Move move = (Move) temp;
				if(move.getX() == x && move.getY() == y) return true;
				if(move.getX2() == x && move.getY2() == y) return true;
			} else if(temp instanceof BorderLine){
				if(temp.getBounds().intersects(new Rectangle((int)x * Game.WIDTH_UNIT, (int)y * Game.HEIGHT_UNIT, 1, 1))) return true;
			}
		}
		return false;
	}
	
	public static boolean fieldHasGot(double x, double y){
		if(x < 0 || y < 0) return false;
		if(x > 7 || y > 15) return false;
		if(x > 1 && x < 7 && y > 2 && y < 14) return true;
		if((x == 1 || x == 7) && (y >= 2 && y <= 14)) return true;
		if((y == 1 || y == 15) && (x >= 3 && x <= 5)) return true;
		
		
		return false;
	}
	
	public void checkWin(){
		Ball ball = null;
		for(int i = 0; i < objects.size(); i++){
			if(objects.get(i) instanceof Ball)
				ball = (Ball) objects.get(i);
		}
		
		if((ball.getX() == 3 || ball.getX() == 4 || ball.getX() == 5) && ball.getY() == 1){
			JOptionPane.showMessageDialog(game, "Player 2 WON!", "Game over!", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		if((ball.getX() == 3 || ball.getX() == 4 || ball.getX() == 5) && ball.getY() == 15){
			JOptionPane.showMessageDialog(game, "Player 1 WON!", "Game over!", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}
	
	public void add(GameObject g){
		objects.add(g);
	}
	
	public void remove(GameObject g){
		objects.remove(g);
	}
	
	public List<GameObject> getObjects(){
		return objects;
	}
	
}
