package model;

import java.util.Random;

import controller.TheDirector;
import view.GameObjectDrawer.ImageGameObject;
/**
 * The Button class defines the GameObjects that the player need to collect to open the exit door and win the game
 * 
 * @author DE MECQUENEM N
 * @author DEJONGHE V
 * @author GAUTIER F
 * @author GROSJEAN L
 * 
 */
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


