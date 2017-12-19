package controller;

import model.Labyrinthe;

public class Game {
	
	private static Labyrinthe labyrinthe;
	
	public static void initGame() {
        labyrinthe = Labyrinthe.getInstance();
    }
	
	public static Labyrinthe getLabyrinthe() {
		return labyrinthe;
	}
	
}
