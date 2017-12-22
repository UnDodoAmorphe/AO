package model;

import view.GameObjectDrawer.ImageGameObject;
/**
 * The GameObject class describes all the different objects that be on the board.
 * This includes the enemies, the bonus, the doors, the buttons, the player and the exit door.
 * 
 * @author DE MECQUENEM N
 * @author DEJONGHE V
 * @author GAUTIER F
 * @author GROSJEAN L
 * 
 */
public abstract class GameObject {
	protected Sommet sommet;
	protected Arc edge;
	private KindOfGameObject type;
	private ImageGameObject image;

	public GameObject (Sommet sommet, KindOfGameObject type){
		this.sommet = sommet;
		this.type = type;
	}

	public GameObject (Arc edge, KindOfGameObject type){
		this.edge = edge;
		this.type = type;
	}

	public enum KindOfGameObject {
		PLAYER,
		MONSTER,
		EXIT,
		DOORS,
		CANDY,
		BUTTON
	}


	public GameObject (KindOfGameObject type){
		this.type = type;
	}

	public KindOfGameObject getType() {
		return type;
	}

	 public Sommet getSommet() {
	        return sommet;
	    }

	 public void setSommet(int x, int y) {
	        sommet.setX(x);
	        sommet.setY(y);
	    }

	public void setImageGameObject(ImageGameObject ImageGameObject) {
		this.image = ImageGameObject;
	}

	public ImageGameObject getImageGameObject() {
		return image;
	}

	 public boolean ifCollision(GameObject e){
	        return (this.sommet == e.sommet);
	    }

	public abstract void eventCollision();

}
