package model;

import java.util.Random;

import controller.TheDirector;
import view.GameObjectDrawer.ImageGameObject;

// impl�menter "est ce qu'il reste des candies dans le graph"
public class Candy extends GameObject{
    public Candy(Sommet sommet) {
        super(sommet, KindOfGameObject.CANDY);
        randomizeSprite();//a modif
    }

    public Candy() {
        super(KindOfGameObject.CANDY);
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


}


