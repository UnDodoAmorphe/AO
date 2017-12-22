package model;
/**
 * The Button class defines the GameObjects that will open or close a door when the player step on it
 * 
 * @author DE MECQUENEM N
 * @author DEJONGHE V
 * @author GAUTIER F
 * @author GROSJEAN L
 * 
 */
public class Button extends GameObject{

	public TypeB buttonType;
	public Doors door;

	public enum TypeB{
		OPEN_BUTTON, CLOSE_BUTTON;
	};

	public Button(Sommet sommet, Doors door) {
		super(sommet, KindOfGameObject.BUTTON);
		this.door = door;
	}

	public Button() {
		super(KindOfGameObject.BUTTON);
	}

	public void setType(TypeB type) {
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
