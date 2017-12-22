package model;

import view.GameObjectDrawer.ImageGameObject;

public abstract class GameObject {
	protected Sommet sommet;
	private KindOfGameObject type;
	private ImageGameObject image;

	public GameObject (Sommet sommet, KindOfGameObject type){
		this.sommet = sommet;
		this.type = type;
	}
	
	public enum KindOfGameObject {
	    PLAYER,
	    MONSTER,
	    EXIT,
	    DOORS,
	    CANDY
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


	public void setSommet(Sommet sommet) {
		this.sommet = sommet;
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
