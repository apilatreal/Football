package game.main;

import game.object.BorderLine;
import game.object.Helper;

public class GameInitializer {

	public static void fieldInit(Handler h){
		int widthDiff = 1;
		int heightDiff = 4;
		
		Game.WIDTH_UNIT -= widthDiff;
		Game.HEIGHT_UNIT -= heightDiff;
		
		h.add(new BorderLine(Game.WIDTH_UNIT * 5, Game.HEIGHT_UNIT * 1, 10, Game.HEIGHT_UNIT * 1 + 10));
		h.add(new BorderLine(Game.WIDTH_UNIT * 3, Game.HEIGHT_UNIT * 1, Game.WIDTH_UNIT * 2 + 10, 10));
		h.add(new BorderLine(Game.WIDTH_UNIT * 3, Game.HEIGHT_UNIT * 1, 10, Game.HEIGHT_UNIT * 1 + 10));
		h.add(new BorderLine(Game.WIDTH_UNIT * 1, Game.HEIGHT_UNIT * 2, Game.WIDTH_UNIT * 2 + 10, 10));
		h.add(new BorderLine(Game.WIDTH_UNIT * 1, Game.HEIGHT_UNIT * 2, 10, Game.HEIGHT_UNIT * 12 + 10));
		h.add(new BorderLine(Game.WIDTH_UNIT * 1, Game.HEIGHT_UNIT * 14, Game.WIDTH_UNIT * 2 + 10, 10));
		h.add(new BorderLine(Game.WIDTH_UNIT * 3, Game.HEIGHT_UNIT * 14, 10, Game.HEIGHT_UNIT * 1 + 10));
		h.add(new BorderLine(Game.WIDTH_UNIT * 3, Game.HEIGHT_UNIT * 15, Game.WIDTH_UNIT * 2 + 10, 10));
		h.add(new BorderLine(Game.WIDTH_UNIT * 5, Game.HEIGHT_UNIT * 14, 10, Game.HEIGHT_UNIT * 1 + 10));
		h.add(new BorderLine(Game.WIDTH_UNIT * 5, Game.HEIGHT_UNIT * 14, Game.WIDTH_UNIT * 2 + 10, 10));
		h.add(new BorderLine(Game.WIDTH_UNIT * 7, Game.HEIGHT_UNIT * 2, 10, Game.HEIGHT_UNIT * 12 + 10));
		h.add(new BorderLine(Game.WIDTH_UNIT * 5, Game.HEIGHT_UNIT * 2, Game.WIDTH_UNIT * 2 + 10, 10));
	}
	
	public static void helperPointInit(Handler h){
		for(int i = 1; i <= 7; i++){
			for(int j = 1; j <= 15; j++){
				if(i == 4 && (j == 1 || j == 15)){ h.add(new Helper(i, j, false)); }
				else if(i == 4 && j > 1 && j < 15){ h.add(new Helper(i, j, true)); }
				else if((i == 3 || i == 5) && (j == 1 || j == 2 || j == 14 || j == 15)){ h.add(new Helper(i, j, false)); }
				else if((i == 3 || i == 5) && (j > 2 && j < 14)){ h.add(new Helper(i, j, true)); }
				else if((i == 2 || i == 6) && (j == 1 || j == 2 || j == 14 || j == 15)){ h.add(new Helper(i, j, false)); }
				else if((i == 2 || i == 6) && (j > 2 && j < 14)){ h.add(new Helper(i, j, true)); }
				else if((i == 1 || i == 7)){ h.add(new Helper(i, j, false)); }
			}
		}
	}
	
}
