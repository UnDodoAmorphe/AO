package model;

import model.Labyrinthe.Directions;

public interface ISprite {
	
	public void move(Labyrinthe labyrinth);
	public void move(Labyrinthe labyrinth, Directions dir);
	public Sommet getVertex(Graph graphe) ;
		
}
