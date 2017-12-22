package model;
import java.util.ArrayList;

import java.util.Random;
import java.util.Vector;

import controller.Controller;
import model.Arc.Type;
import model.Labyrinthe.Directions;
import controller.SpawnManager;
public class Labyrinthe {

	private static Graph graph = null;
	private static Labyrinthe labyrinthe = null;

	private Labyrinthe() {

	}

	public static Graph getGraphe() {
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

	
	 public void initialize(int nbButton, int nbMonsters) {
		 
		// Place porte de sortie
		Sommet exitDoorVertex = graph.getEmptyVertex();
		exitDoorVertex.setObj(SpawnManager.spawnExitDoor(exitDoorVertex));
		
		
		// Place le player
		Sommet playerVertex = graph.getEmptyVertex();
		playerVertex.setObj(SpawnManager.spawnPlayer(playerVertex));
		
		//place les portes ferm�es puis les boutons en fonction du nb de boutons en argument
		//  --> place les portes ferm�es 
		for (int i=0; i<nbButton; i++) {
			
					 Arc randomEdge = graph.randomEdge();
					 Sommet buttonVertex = graph.getEmptyVertex();
					 while (randomEdge.getType() != (Type.WALL)) {
						 randomEdge = graph.randomEdge();
					 }
					 randomEdge.setType(Type.CLOSED_DOOR);	 
					 buttonVertex.setObj(SpawnManager.spawnButton (buttonVertex, (Doors)SpawnManager.spawnDoor(randomEdge)));
					 
		
		 }
		// place les monstres
		for (int i=0; i<nbMonsters; i++) {
			 Sommet buttonVertex = graph.getEmptyVertex();
			 buttonVertex.setObj(SpawnManager.spawnMonster(buttonVertex));
		}
		
		
		//place les bonbons sur toutes les cases restantes 
		 for (int i=0; i< graph.getSizeX(); i++) {
			 for (int j=0; j < graph.getSizeY(); i++) {
				 Sommet myVertex = graph.getVertex(i, j); 
				 if (!myVertex.containObject()) {
				 	 myVertex.setObj(SpawnManager.spawnCandy(myVertex));
					 
				 }
			 }
		}
	 }


	public static Directions getMonsterDirection(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
}