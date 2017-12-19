package model;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import controller.Controller;
import model.Arc.Type;
import model.Labyrinthe.Directions;

public class Labyrinthe {

	private Graph graph = null;
	private static Labyrinthe labyrinthe = null;

	private Labyrinthe() {

	}

	public Graph getGraphe() {
		return graph;
	}

	public static Labyrinthe getInstance () {
		if (labyrinthe == null)
			labyrinthe = new Labyrinthe();
		else
			System.out.println("Instance de Labyrinthe déjà créée.\n");
		return labyrinthe;
	}

	public void makeGraph (int width, int height) {
		graph = new Graph(Arc.class);
		graph.setSizeX(width);
		graph.setSizeY(height);
		graph.createVertexArray();
		graph.generateGraph();
	}


	public enum Directions {
		NORTH,
		SOUTH,
		EAST,
		WEST;
	}




	public ArrayList<Sommet[]> getWalls() {

		ArrayList<Sommet[]> walls = new ArrayList<Sommet[]>();

		for(int x = 0; x < graph.getSizeX(); x++) {
			for(int y = 0; y < graph.getSizeY(); y++) {

				Sommet v = graph.getVertex(x, y);
				Vector<Directions> dir = v.getArcsClosed();
				for(Directions d : dir) {
					Sommet[] paire = new Sommet[2];
					paire[0] = v;
					switch(d) {
					case EAST:
						if (x < graph.getSizeX() - 1)
							paire[1] = graph.getVertex(v.getX() + 1, v.getY());
						break;
					case WEST:
						if (x > 0)
							paire[1] = graph.getVertex(v.getX() - 1, v.getY());
						break;
					case NORTH:
						if (y > 0)
							paire[1] = graph.getVertex(v.getX(), v.getY() - 1);
						break;
					case SOUTH:
						if (y < graph.getSizeY() - 1)
							paire[1] = graph.getVertex(v.getX(), v.getY() + 1);
						break;
					}

					if (paire [0] != null && paire [1] != null)
						walls.add(paire);
				}
			}
		}

		return walls;


	}
	//FONCTIONS A FAIRE :
	//Boutons/monstres/Player/sortie/porte
	 /*public boolean putCandy() {
	    	if ((isButton()==true) || (isCandy()==true)) {
	    		return false;
	    	}
	    	else {
	    		Candy myCandy = new Candy();
	    		myCandy.addCandy(this);
	    		this.containCandy = true;
	    		return true;
	    	}
	    }
	 
	 public boolean setButton() {
			if ((isButton()==true) || (isCandy()==true)) {
				return false;
			}
			else {
				Button myButton = new Button();
				myButton.addButton(this);
				this.containButton = true;
				return true;
			}
		}
*/

	public static Directions getMonsterDirection(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
}