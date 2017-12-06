package model;

import model.Arc.Type;

public class Button{

public Type buttonType;
private int x, y;

	public enum Type{
		OPEN_BUTTON, CLOSE_BUTTON;
		};
		public Button() {
			this.x=-1;
			this.y=-1;
		}
		public void addButton(Sommet vertex) {
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
		public void setType(Type type) {
			// TODO Auto-generated method stub
			this.buttonType = type;
		}
		public Type getType() {
			return this.buttonType;
		}
//		public void pushButton() {
//			if (this.getType == OPEN_BUTTON) {
//				Arc edge= Labyrinthe.graphe.randomEdge();
//				if (edge.isClosed(vertex, dir)) {
//					edge.openDoorRandom();
//				}
//			}
//		}
}
