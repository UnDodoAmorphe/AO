package model;
import java.util.Random;
import java.util.Vector;

import org.jgrapht.graph.SimpleGraph;

import model.Labyrinthe.Directions;
import model.Arc.Type;
/**
 * The Graph class extends the SimpleGraph of JGraphT
 * The created graph correspond to a perfect maze and will be used to create the game board 
 * 
 * @author DE MECQUENEM N
 * @author DEJONGHE V
 * @author GAUTIER F
 * @author GROSJEAN L
 * 
 */
public class Graph extends SimpleGraph<Sommet, Arc> {
	
	private int sizeX = 16;
	private int sizeY = 16;
	private Random random = null;
	private Sommet[][] sommets;

	public Graph(Class<? extends Arc> edgeClass) {
		super(edgeClass);
		random = new Random();
	}
	
	 	public void addMyVertex(Sommet v){
	        sommets[v.getX()][v.getY()] = v;
	    }

	    public Sommet getVertex(int x, int y){
	        return sommets[x][y];
	    }
	    /**
         * Return a random empty Vertex of the graph
         * 
         * @return a random Vertex which does not contain an object
         */
		public Sommet getEmptyVertex() {
			 Sommet randomVertex = this.randomVertex();
			 while (randomVertex.containObject()) {
				 randomVertex = this.randomVertex();
			 }
			 return randomVertex;
		 }	

	    public int getSizeX() {
	        return sizeX;
	    }

	    public void setSizeX(int sizeX) {
	        this.sizeX = sizeX;
	    }

	    public int getSizeY() {
	        return sizeY;
	    }

	    public void setSizeY(int sizeY) {
	        this.sizeY = sizeY;
	    }

	    public void createVertexArray(){
	        sommets = new Sommet[sizeX][sizeY];
	    }
	    /**
         * Create a Graph of sizeX*sizeY which correspond to the maze
         * 
         */
	    public void generateGraph () {
	    int startX = random.nextInt(sizeX);
        int startY = random.nextInt(sizeY);

        System.out.println("Generation du graphe commencant en (" + startX + ", " + startY + ")");
        Sommet v = new Sommet(startX, startY, this);
        v.setNbr(0);
        addMyVertex(v);
        buildRandomPath(v);
	    }
	    
	    private void buildRandomPath(Sommet vertex){	
			
			//une liste aleatoire des 4 directions
	    	
			Vector<Directions>d=new Vector<Directions>();
			for(int i=0; i<4; ++i)
				d.add(Directions.values()[i]);
			Directions directions[]=new Directions[4];
			Random random = new Random();
			for(int i=0;i<directions.length;++i){
				int index=random.nextInt(d.size());
				directions[i]=d.get(index);
				d.remove(index);
			}



			//pour chacune de ces directions, on avance en profondeur d’abord

			for(int i=0;i<4;++i){
				Directions dir = directions[i];

				int xt = 0, yt = 0;
				Arc a = new Arc();
				Arc na = new Arc();

				switch(dir){
				case NORTH:
					yt = -1;
					a.setDirection(Directions.NORTH);
					na.setDirection(Directions.SOUTH);
					break;
				case SOUTH:
					yt = 1;
					a.setDirection(Directions.SOUTH);
					na.setDirection(Directions.NORTH);
					break;
				case EAST:
					xt = 1;
					a.setDirection(Directions.EAST);
					na.setDirection(Directions.WEST);
					break;
				case WEST:
					xt = -1;
					a.setDirection(Directions.WEST);
					na.setDirection(Directions.EAST);
					break;
				}

				Sommet v = new Sommet (vertex.getX() + xt, vertex.getY() + yt, this);

				if(vertex.inBorders(dir) && doesntExist(v)){

					v.setNbr(vertex.getNbr()+1);
					addMyVertex(v);
					vertex.addEdge(a);
					v.addEdge(na);
					buildRandomPath(v);
				} 
				else {
					boolean ae = false;
					for (Arc e : vertex.getEdges())
						if (e.getDirection() == dir)
							ae = true;

					if (!ae){
						a.setType(Type.WALL);
						vertex.addEdge(a);
					}
				}
			}
	    }



	public boolean doesntExist(Sommet vertex) {
		
		return getVertex (vertex.getX(), vertex.getY()) == null;
	}
	
	public void drawGraphOnConsole(){
		
        for (int j = 0; j < sizeY; j++){
            for (int i = 0; i < sizeX; i++){
            	
                System.out.print("o");
                
                if (getVertex(i, j).hasArcOpen(Directions.EAST))
                    System.out.print("--");
                else
                    System.out.print("  ");
            }
            
            System.out.println("");
            
            for (int i = 0; i < sizeX; i++){
                if (getVertex(i, j).hasArcOpen(Directions.SOUTH))
                    System.out.print("|");
                else
                    System.out.print(" ");

                System.out.print("  ");
            }
            System.out.println("");
        }
    }


	public Sommet randomVertex() {
		//myVertexes = this.vertexSet(); -> puis parcourir puis en choisisr un random ?
		return null;
	}

	public Arc randomEdge() {
		// TODO Auto-generated method stub
		return null;
	}

	public Arc getEdge(Sommet vertex, Directions dir) {
		// TODO Auto-generated method stub
		return null;
	}

	public Sommet getVertexByDir(Sommet vertex, Directions dir) {
		// TODO Auto-generated method stub
		return null;
	}
}