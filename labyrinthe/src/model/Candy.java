package model;

import java.util.Random;

import controller.TheDirector;

// impl�menter "est ce qu'il reste des candies dans le graph"
public class Candy extends GameObject{
    public Candy(int x, int y) {
        super(x, y, KindOfGameObject.BONUS);
        randomizeSprite();//a modif
    }

    public Candy() {
        super(KindOfGameObject.BONUS);
        randomizeSprite();
    }

    public void randomizeSprite(){
        Random random = TheDirector.getRandom();
        ImageGameObject[] types = {ImageGameObject.CANDY1, ImageGameObject.CANDY2, ImageGameObject.CANDY3, ImageGameObject.CANDY4};
        setImageGameObject(types[random.nextInt(4)]);
    }

    @Override
    public void eventCollision() {
    	TheDirector.addNbBonus();
    	TheDirector.removeGameObject(this);
    }


    public void addCandy(Sommet vertex) {
    	//Candy myCandy= new Candy();//(vertex.getX(), vertex.getY());
    	this.x=vertex.getX();
    	this.y=vertex.getY();
    }
}


