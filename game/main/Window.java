package game.main;

import javax.swing.JFrame;

public class Window {

	private JFrame frame;
	
	public Window(String title, int width, int height, Game game){
		frame = new JFrame(title);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.setSize(width, height);
		frame.setVisible(true);
		game.start();
	}
	
}
