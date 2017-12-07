package model;

import java.util.Random;

import org.jgrapht.graph.DefaultEdge;

import model.Labyrinthe.Directions;

@SuppressWarnings("serial")
public class Arc extends DefaultEdge {
	//need constructeur
	public enum Type{
		OPENED_DOOR, CLOSED_DOOR, CORRIDOR;
	};

	private Type type;
	private Labyrinthe labyrinthe;

	public Arc() {
		super();
		this.type=Type.CORRIDOR;
	}

	public Arc(Type type) {
		super();
		this.type=type;
	}

	public Sommet getSource() {
		return (Sommet) super.getSource();
	}

	public Sommet getTarget() {
		return (Sommet) super.getTarget();
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type=type;
	}

	public int compareTo(Arc o) {
		int source= this.getSource().compareTo((o).getTarget());
		if (source!=0)
			return source;
		else {
			return this.getTarget().compareTo((o).getTarget());
		}
	}

	public void closeDoor(Arc edge) {
		edge.setType(Arc.Type.CLOSED_DOOR);
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

	//A BOUGER DE PLACE
	
}

