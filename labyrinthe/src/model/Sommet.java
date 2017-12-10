package model;

import model.Labyrinthe.Directions;

public class Sommet implements Comparable<Sommet>{
private int x,y,nbr;
private boolean containCandy;
private boolean containButton;

public Sommet(int x, int y) {
	this.x=x;
	this.y=y;

	this.containCandy=false;
	this.containButton=false;

}

public Sommet () {

}

@Override
public int compareTo(Sommet o) {
	if (x != o.x)
		return o.x-x;
	else
		return o.y-y;
 	}

public boolean inBorders(Directions dir) {// A FAIRE
	// TODO Auto-generated method stub
	if (x==0 && dir==Directions.WEST) {
		return false;
	}
	else if (x==15 && dir==Directions.EAST) {
		return false;
	}
	else if (y==0 && dir==Directions.NORTH) {
		return false;
	}
	else if (y==15 && dir==Directions.SOUTH) {
		return false;
	}
	else {
		return true;
	}
}

public int getX() {
	// TODO Auto-generated method stub
	return x;
}

public int getY() {
	// TODO Auto-generated method stub
	return y;
}

public int getNbr() {
	// TODO Auto-generated method stub
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
}
