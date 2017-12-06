package model;

import java.util.ArrayList;
import java.util.Random;

import model.Labyrinthe.Directions;

public class Monstre {
	private Sommet cible;
	private Sommet coordonnees;
	private ArrayList<Sommet> zoneSpawnInterdit = new ArrayList<Sommet>();
	//private Image monstre;
	
	public Monstre(Sommet cible, Sommet coordonnees) {
		this.cible=cible;
		this.coordonnees=coordonnees;
	}
	public Sommet getCoordonnees() {
		return this.coordonnees;
	}
	public Sommet getCible() {
		return this.cible;
	}
	
	public ArrayList zoneJoueur(Joueur joueur, Labyrinthe labyrinthe, ArrayList zone) {
		Sommet pos_Joueur = Joueur.getCoordonnees();
		zone.add(pos_Joueur);
		for(Directions dir:Directions.values()){
			for (int i=0; i<3;i++) {
				Sommet next=labyrinthe.graphe.getVertexByDir(pos_Joueur,dir);
				if(next.getNbrMonstreSpawn()==0){
					next.setNbrMonstreSpawn(pos_Joueur.getNbrMonstreSpawn()+1);
					zone.add(next);
				}
			}
		}
		return zone;
	}
	
	
	public void spawnMonstre(Labyrinthe labyrinthe, ArrayList zone) {
		Random random = new Random();
		for (int i=0;i<labyrinthe.graphe.length())//DEMANDER LA LISTE TOTALE DES SOMMETS D UN GRAPHE (jgraph method)
}
}
