package model;

import java.util.Random;

import org.jgrapht.graph.DefaultEdge;

import model.Arc.Type;
import model.Labyrinthe.Directions;

@SuppressWarnings("serial")
public class Arc extends DefaultEdge {
	
	public enum Type{
		OPENED_DOOR, CLOSED_DOOR, CORRIDOR, WALL;
	};

	private Type type;
	private Directions dir;

	public Arc() {
		super();
		this.type=Type.CORRIDOR;
	}

	public Arc(Type type) {
		super();
		this.type=type;
	}


	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type=type;
	}
	
	public Directions getDirection() {
		return dir;
	}
	
	public void setDirection(Directions dir) {
		this.dir = dir;
	}


/*
 * public void openDoorRandom() {
		Random random = new Random();
		for (int i=0; i<1000; i++) {
			Sommet vertex=graph.randomVertex();
			if (vertex!=null) {
				Directions dir= Directions.values()[random.nextInt(Directions.values().length)];
				if (isWall(vertex, dir)){
					Sommet vertex2= graph.getVertexByDir(vertex, dir);
					if (vertex2!=null) {
						Arc edge= graph.getEdge(vertex, vertex2);
						if (edge==null) {
							new Arc(Type.OPENED_DOOR);
						}
					}
				}
			}
		}
	}
	
	public void closeDoorRandom() {
		Arc edge= labyrinthe.getGraphe().randomEdge();
		closeDoor(edge);
	}


	public boolean isClosed(Sommet vertex, Directions dir){
		Arc edge= labyrinthe.getGraphe().getEdge(vertex, dir);
		return (edge==null || (edge.getType()==Arc.Type.CLOSED_DOOR));
	}

	public boolean isOpened(Sommet vertex, Directions dir){
		Arc edge= labyrinthe.getGraphe().getEdge(vertex, dir);
		return (edge==null && (edge.getType()==Arc.Type.CLOSED_DOOR));
	}

	public boolean isOpenedDoor(Sommet vertex, Directions dir) {
		Arc edge= labyrinthe.getGraphe().getEdge(vertex, dir);
		return ((edge!=null) && ((edge.getType()==Arc.Type.OPENED_DOOR)));
	}
*/
	
}

