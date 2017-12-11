package controller;

import model.*;
import model.Labyrinthe.Directions;
import view.Frame;
import view.View;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javafx.application.Application;
import javafx.stage.Stage;

public class Controller extends Application{

	private static View view = null;
	private static Controller INSTANCE = null;

	private Controller() {

		view = View.getInstance();
		view.setOnAction();
	}


	public static Controller makeInstance () {
		if (INSTANCE == null)
			INSTANCE = new Controller();
		else
			System.out.println("Instance de Controller déjà créée.\n");
		return INSTANCE;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Game.initGame();
		Game.getLabyrinthe().makeGraph(16, 16);
		view.start(primaryStage);
		Frame.drawFrame(primaryStage, 16, 16);
		for(Sommet[] paire : Game.getLabyrinthe().getWalls()) {
			Frame.drawWall(paire[0].getX(), paire[0].getY(), paire[1].getX(), paire[1].getY());
		}
		
		/*
		for (Iterator<Sommet> i = sommets.iterator(); i.hasNext();) {
			sp = s;
			s = i.next();
			if (!labyrinthe.getGraphe().containsEdge(s, sp))
				Frame.drawWall(s.getX(), s.getY(), sp.getX(), sp.getY());
		}*/
		
		/*for (int y = 0 ; y < View.HEIGHT ; y++) {
			for (int x = 0 ; x < View.WIDTH ; x++) {
				s = new Sommet (x, y, y*View.WIDTH + x);
				if (x + 1 < View.WIDTH) {
					sp = new Sommet (x + 1, y, y*View.WIDTH + x);
					if (!labyrinthe.getGraphe().containsEdge(s, sp))
						Frame.drawWall(s.getX(), s.getY(), sp.getX(), sp.getY());
				}
				
				if (y + 1 < View.HEIGHT) {
					sp = new Sommet (x, y + 1, y*View.WIDTH + x);
					if (!labyrinthe.getGraphe().containsEdge(s, sp))
						Frame.drawWall(s.getX(), s.getY(), sp.getX(), sp.getY());
				}
				
			}
		} */
				
		
		

	}

}
