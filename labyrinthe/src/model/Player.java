package model;

import model.Labyrinthe.Directions;

public class Player extends GameObject{

    public Player(int x, int y, boolean isPlayer){
        super(x, y, (isPlayer ? KindOfGameObject.PLAYER : KindOfGameObject.MONSTER));
        setImageGameObject((isPlayer ? ImageGameObject.PLAYER : ImageGameObject.MONSTER));
    }

    public Player(boolean isPlayer){
        super((isPlayer ? KindOfGameObject.PLAYER : KindOfGameObject.MONSTER));
        setImageGameObject((isPlayer ? ImageGameObject.PLAYER : ImageGameObject.MONSTER));
    }

    public void moveUp(){
        setY(getY() - 1);
    }

    public void moveDown(){
        setY(getY() + 1);
    }

    public void moveRight(){
        setX(getX() + 1);
    }

    public void moveLeft(){
        setX(getX() - 1);
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
