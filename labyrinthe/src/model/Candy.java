package model;
// implémenter "est ce qu'il reste des candies dans le graph"
public class Candy{
int x, y;

	public Candy() {
		this.x=-1;
		this.y=-1;
	}
	
	public void addCandy(Sommet vertex) {
		//Candy myCandy= new Candy();//(vertex.getX(), vertex.getY());
		this.setX(vertex.getX());
		this.setY(vertex.getY());
	}
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.y = y;
	}
	public void setX(int x) {
		// TODO Auto-generated method stub
		this.x = x;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}
