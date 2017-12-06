package model;

public class Joueur {
	private static Sommet coordonnees;
	//private Image joueur;
	
	public Joueur(Sommet coordonnees) {
		this.coordonnees=coordonnees;
	}
	
	public static Sommet getCoordonnees() {
		return coordonnees;
	}
}
