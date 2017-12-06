package model;

import model.Labyrinthe.Directions;

public class Sommet implements Comparable<Sommet>{
private int x,y,nbr,nbrMonstreSpawn;

public Sommet(int x, int y, int nbr, int nbrMonstreSpawn) {
	this.x=x;
	this.y=y;
	this.nbr=nbr;
	this.nbrMonstreSpawn=nbrMonstreSpawn;
}

@Override
public int compareTo(Sommet o) {
	if (x != o.x)
		return o.x-x;
	else
		return o.y-y;
 	}

public boolean inBorders(Directions dir) {
	// TODO Auto-generated method stub
	return false;
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

public void setNbr(int i) {
	// TODO Auto-generated method stub
	this.nbr=i;
}

public void setNbrMonstreSpawn(int i) {
	// TODO Auto-generated method stub
	this.nbrMonstreSpawn=i;
}

public int getNbrMonstreSpawn() {
	// TODO Auto-generated method stub
	return nbrMonstreSpawn;
}
}
