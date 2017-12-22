package model;

import model.Labyrinthe.Directions;
import view.GameObjectDrawer.ImageGameObject;

/**
 *The Player class correspond to the mobile GameObjects.
 *The Player can be the controlled character or an enemy monster.
 * 
 * @author DE MECQUENEM N
 * @author DEJONGHE V
 * @author GAUTIER F
 * @author GROSJEAN L
 * 
 */
public class Player extends GameObject{

	public Player(Sommet sommet, boolean isPlayer){
		super(sommet, (isPlayer ? KindOfGameObject.PLAYER : KindOfGameObject.MONSTER));
		setImageGameObject((isPlayer ? ImageGameObject.PLAYER : ImageGameObject.MONSTER));
	}

	public Player(boolean isPlayer){
		super((isPlayer ? KindOfGameObject.PLAYER : KindOfGameObject.MONSTER));
		setImageGameObject((isPlayer ? ImageGameObject.PLAYER : ImageGameObject.MONSTER));
	}

	public void moveUp(){
		setSommet(getSommet().getX(), getSommet().getY() - 1);
	}

	public void moveDown(){
		setSommet(getSommet().getX(), getSommet().getY() + 1);
	}

	public void moveRight(){
		setSommet(getSommet().getX() + 1, getSommet().getY());
	}

	public void moveLeft(){
		setSommet(getSommet().getX() - 1, getSommet().getY());
	}

	public void move(Directions d) {
		switch (d) {
		case EAST:
			moveRight();
			break;
		case SOUTH:
			moveDown();
			break;
		case WEST:
			moveLeft();
			break;
		case NORTH:
			moveUp();
			break;
		default:
			break;
		}

	}

	@Override
	public void eventCollision() {
		System.out.println("Collision");
	}
}
