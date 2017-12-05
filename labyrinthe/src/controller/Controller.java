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
	private static Labyrinthe labyrinthe = null;
	private static Controller INSTANCE = null;

	private Controller() {

		view = View.getInstance();
		view.setOnAction();
		labyrinthe = new Labyrinthe();
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
		labyrinthe.buildRandomPath(labyrinthe.getRandomVertex());
		//HashSet<Sommet> sommets = (HashSet<Sommet>) labyrinthe.getGraphe().vertexSet();
		
		/*Sommet s = null, sp = null;
		
		for (Iterator<Sommet> i = sommets.iterator(); i.hasNext();) {
			s = sp;
			sp = i.next();
			sp.toString();
		}
		Graph.doesntExist(s, Directions.NORTH); */
		
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
				
		view.start(primaryStage);
		

	}

}
