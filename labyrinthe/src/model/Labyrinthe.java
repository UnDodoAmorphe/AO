package model;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;
import java.util.Vector;

public class Labyrinthe {
	//la labyrinthe doit etre compose de graphe
	public static Graph graphe;
	public Sommet getRandomVertex;

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
				Sommet next= new Sommet(xt,yt,vertex.getNbr()+1,0/*pour ajout de monstre*/);
				graphe.addVertex(next);
				graphe.addEdge(vertex,next);
				buildRandomPath(next);
			}
		}
	}
	
	private void calculateManhattanDistance(Sommet source,Sommet target){
		Queue<Sommet> fifo = new ArrayDeque<Sommet>();
		target.setNbr(1);
		fifo.add(target);
		while(!fifo.isEmpty()){
			Sommet actual=fifo.remove();
			for(Directions dir:Directions.values()){
				if(this.isOpened(actual,dir)){
					Sommet next=graphe.getVertexByDir(actual,dir);
					if(next.getNbr()==0){
						next.setNbr(actual.getNbr()+1);
						if(next!=source)
							fifo.add(next);
					}
				}
			}
		}
	}
	
	private boolean isOpened(Sommet actual, Directions dir) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void launchManhattan(Sommet source,Sommet target){
		for(Sommet vertex:graphe.vertexSet())
			vertex.setNbr(0);
		calculateManhattanDistance(source,target);
	}	
	
	public Graph getGraph() {
		return graphe;
	}
}