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
	Arc edge= Labyrinthe.graphe.randomEdge();
	closeDoor(edge);
}

private boolean isWall(Sommet vertex, Directions dir) {
	// TODO Auto-generated method stub
	return false;
	}

public boolean isClosed(Sommet vertex, Directions dir){
	Arc edge= Labyrinthe.graphe.getEdge(vertex, dir);
	return (edge==null || (edge.getType()==Arc.Type.CLOSED_DOOR));
}

public boolean isOpened(Sommet vertex, Directions dir){
	Arc edge= Labyrinthe.graphe.getEdge(vertex, dir);
	return (edge==null && (edge.getType()==Arc.Type.CLOSED_DOOR));
}

public boolean isOpenedDoor(Sommet vertex, Directions dir) {
	Arc edge= Labyrinthe.graphe.getEdge(vertex, dir);
	return ((edge!=null) && ((edge.getType()==Arc.Type.OPENED_DOOR)));
}

//A BOUGER DE PLACE
public void openDoorRandom() {
	Random random = new Random();
	for (int i=0; i<1000; i++) {
		Sommet vertex=Labyrinthe.graphe.randomVertex();
		if (vertex!=null) {
			Directions dir= Directions.values()[random.nextInt(Directions.values().length)];
			if (isWall(vertex, dir)){
				Sommet vertex2= Labyrinthe.graphe.getVertexByDir(vertex, dir);
				if (vertex2!=null) {
					Arc edge= Labyrinthe.graphe.getEdge(vertex, vertex2);
					if (edge==null) {
						new Arc(Type.OPENED_DOOR);
					}
				}
			}
		}
	}
}
}

