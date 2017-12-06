package model;

import model.Labyrinthe.Directions;

public class Sprite implements ISprite{

	public void move(Labyrinthe labyrinth){
		Sommet vertex=this.getVertex(Labyrinthe.graphe);//attention graphe est public
		for(Directions dir:Directions.values()){
			Sommet next=Labyrinthe.graphe.getVertexByDir(vertex,dir);
			if(Labyrinthe.graphe.isConnected(vertex,next)
					&&(next.getNbr()==vertex.getNbr()-1)){
				this.move(labyrinth,dir);
			}
		}
	}

	private Sommet getVertex(Graph graphe) {
		//pour tout les monstres contenus dans graphe{ --> pourquoi monstres dans graph ?
			//monstres.getCoordonnees();
		return null;
	}

	@Override
	public void move(Labyrinthe labyrinth, Directions dir) {
		// TODO Auto-generated method stub
		
	}

}
