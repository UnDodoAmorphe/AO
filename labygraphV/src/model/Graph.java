package model;
import org.jgrapht.graph.SimpleGraph;

import model.Labyrinthe.Directions;

public class Graph extends SimpleGraph<Sommet, Arc> {

	public Graph(Class<? extends Arc> edgeClass) {
		super(edgeClass);
		// TODO Auto-generated constructor stub
	}

	public static boolean doesntExist(Sommet vertex, Directions dir) {
		// TODO Auto-generated method stub
		return false;
	}
}