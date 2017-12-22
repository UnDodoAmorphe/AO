package view;
import java.util.LinkedList;

import controller.SpriteManager;
import controller.TheDirector;
import model.GameObject;

public class GameObjectDrawer {
	public GameObjectDrawer() {
;
	}
	public enum ImageGameObject {//a mettre dans view ? 
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
	
    /*public static void drawEntities(){
        LinkedList<GameObject> gameObjects = TheDirector.getGameObject();
        cleanEntities();
        for (GameObject e : gameObjects){
            ImageGameObject t = e.getImageGameObject();
            drawSprite(e.getX(), e.getY(), SpriteManager.getSprite(t));// a changer
        }

        renderEntities();
    }

    public static void cleanEntities(){
        for (Node n : drawnEntities)
            pane.getChildren().remove(n);

        drawnEntities = new Vector<>();
    }

    public static void renderEntities(){
        for (Node n : drawnEntities)
            pane.getChildren().add(n);
    }*/
}
