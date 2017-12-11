package model;

import java.util.Vector;

import model.Labyrinthe.Directions;
import model.Arc.Type;

public class Sommet implements Comparable<Sommet>{
private int x, y, nbr;
private Graph graph;
private Vector<Arc> arcs;

private boolean containCandy;
private boolean containButton;

public Sommet(int x, int y, Graph g) {
	this.x=x;
	this.y=y;
	graph = g;
	arcs = new Vector<>();

	this.containCandy=false;
	this.containButton=false;

}

@Override
public int compareTo(Sommet o) {
	if (x != o.x)
		return o.x-x;
	else
		return o.y-y;
}

public Vector<Arc> getEdges() {
    return arcs;
}

public void addEdge(Arc a){
    arcs.add(a);
}

public Vector<Directions> getArcsClosed() {
	
	 Vector<Directions> dir = new Vector<>();
     for (Arc e : arcs){
    	 
         if (e.getType() == Type.WALL || e.getType() == Type.CLOSED_DOOR)
         dir.add(e.getDirection());
     }

     return dir;
}

public boolean hasArcOpen(Directions d){
    for (Arc e : arcs)
        if (e.getDirection() == d && e.getType() != Type.WALL && e.getType() != Type.CLOSED_DOOR)
            return true;

    return false;
}


public boolean inBorders(Directions dir) {
	
	switch (dir) {
	case NORTH:
		return y > 0;
	case SOUTH:
		return y < graph.getSizeY() - 1;
	case EAST:
		return x < graph.getSizeX() - 1;
	case WEST:
		return x > 0;
	default:
		return false;
	}
}

public int getX() {
	
	return x;
}

public int getY() {
	
	return y;
}

public int getNbr() {
	
	return nbr;
}
public boolean setCandy() {
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
public boolean isCandy() {
	return this.containCandy;
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
public boolean isButton() {
	return this.containButton;
}

public void setNbr(int nbr) {
	this.nbr = nbr;
}

public void setX(int x) {
	this.x = x;
}

public void setY(int y) {
	this.y = y;
}
}
