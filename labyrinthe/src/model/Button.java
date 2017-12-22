package model;

import model.Arc.Type;

public class Button extends GameObject{

public Type buttonType;
private int x, y;

	public enum Type{
		OPEN_BUTTON, CLOSE_BUTTON;
		};
		public Button(int x, int y) {
			super(x, y, KindOfGameObject.BUTTON);
		}

		public Button() {
			super(KindOfGameObject.BUTTON);
		}

		public void setType(Type type) {
			// TODO Auto-generated method stub
			this.buttonType = type;
		}
//		public void pushButton() {
//			if (this.getType == OPEN_BUTTON) {
//				Arc edge= Labyrinthe.graphe.randomEdge();
//				if (edge.isClosed(vertex, dir)) {
//					edge.openDoorRandom();
//				}
//			}
//		}
		@Override
		public void eventCollision() {
			// TODO Auto-generated method stub
			
		}
}
