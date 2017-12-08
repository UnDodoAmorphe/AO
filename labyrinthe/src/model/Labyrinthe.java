package model;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import model.Arc.Type;
import model.Labyrinthe.Directions;

public class Labyrinthe {
//la labyrinthe doit etre compose de graphe

	private Graph graphe = null;
	private Sommet randomVertex = null;
	
	public Labyrinthe() {
		graphe = new Graph(Arc.class);
		randomVertex = new Sommet(1, 1);
	}
	
	public Graph getGraphe() {
		return graphe;
	}



	public Sommet getRandomVertex() {
		return randomVertex = new Sommet();
	}



	public enum Directions {
		NORTH,
		SOUTH,
		EAST,
		WEST;
		}
	
	
	public void buildRandomPath(Sommet vertex){
		//une liste aleatoire des 4 directions
		Vector<Directions>v=new Vector<Directions>();
		for(int i=0; i<4; ++i)
			v.add(Directions.values()[i]);
		Directions directions[]=new Directions[4];
		Random random = new Random();
		for(int i=0;i<directions.length;++i){
			int index=random.nextInt(v.size());
			directions[i]=v.get(index);
			v.remove(index);
		}



		//pour chacune de ces directions, on avance en profondeur d’abord
		for(int i=0;i<4;++i){
			Directions dir=directions[i];
			if(vertex.inBorders(dir)&&Graph.doesntExist(vertex,dir)){
				int x=vertex.getX();
				int y=vertex.getY();
				int xt=0,yt=0;
				switch(dir){
				case NORTH:xt=x;yt=y-1;break;
				case SOUTH:xt=x;yt=y+1;break;
				case EAST:xt=x+1;yt=y;break;
				case WEST:xt=x-1;yt=y;break;
				}
				Sommet next= new Sommet(xt,yt);
				next.setNbr(vertex.getNbr()+1);
				graphe.addVertex(next);
				graphe.addEdge(vertex,next);
				buildRandomPath(next);
			}
		}
	}
	
	public void openDoorRandom() {
		Random random = new Random();
		for (int i=0; i<1000; i++) {
			Sommet vertex=graphe.randomVertex();
			if (vertex!=null) {
				Directions dir= Directions.values()[random.nextInt(Directions.values().length)];
				if (isWall(vertex, dir)){
					Sommet vertex2= graphe.getVertexByDir(vertex, dir);
					if (vertex2!=null) {
						Arc edge= graphe.getEdge(vertex, vertex2);
						if (edge==null) {
							new Arc(Type.OPENED_DOOR);
						}
					}
				}
			}
		}
	}
	
	private boolean isWall(Sommet vertex, Directions dir) {
		// TODO Auto-generated method stub
		return false;
	}
	
}