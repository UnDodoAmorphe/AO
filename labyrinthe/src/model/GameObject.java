package model;

public abstract class GameObject {
	private int x;
	private int y;
	private KindOfGameObject type;
	private ImageGameObject image;

	public GameObject (int x, int y, KindOfGameObject type){
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	public enum KindOfGameObject {
	    PLAYER,
	    MONSTER,
	    EXIT,
	    DOORS,
	    BONUS
	}
	
	public enum ImageGameObject {
	    PLAYER,
	    MONSTER,
	    EXIT,
	    SWITCH_ON,
	    SWITCH_OFF,
	    CANDY1,
	    CANDY2,
	    CANDY3,
	    CANDY4
	}

	public GameObject (KindOfGameObject type){
		this.type = type;
	}

	public KindOfGameObject getType() {
		return type;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setImageGameObject(ImageGameObject ImageGameObject) {
		this.image = ImageGameObject;
	}

	public ImageGameObject getImageGameObject() {
		return image;
	}

	public boolean ifCollision(GameObject e){
		return (this.x == e.x && this.y == e.y);
	}

	public abstract void eventCollision();

}
