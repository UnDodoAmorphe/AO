package model;
// impl�menter "est ce qu'il reste des candies dans le graph"
public class Candy{
int x, y;

	public Candy() {
		this.x=-1;
		this.y=-1;
	}
	
	public void addCandy(Sommet vertex) {
		//Candy myCandy= new Candy();//(vertex.getX(), vertex.getY());
		this.x=vertex.getX();
		this.y=vertex.getY();
	}


	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}
