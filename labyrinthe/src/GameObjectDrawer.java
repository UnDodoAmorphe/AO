import java.util.LinkedList;

import controller.TheDirector;
import model.GameObject;
import model.GameObject.ImageGameObject;

public class GameObjectDrawer {
	public GameObjectDrawer() {;}
	
    public static void drawEntities(){
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
    }
}
