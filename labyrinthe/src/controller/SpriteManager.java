package controller;

import javafx.scene.image.Image;
import view.GameObjectDrawer.ImageGameObject;

import java.util.HashMap;
/**
 * The SpriteManager class attributes and stores the sprites corresponding to the type of GameObjects
 * 
 * @author DEJONGHE V
 * @author GAUTIER F
 * 
 */
public class SpriteManager {
    private static HashMap<ImageGameObject, String> spriteTable;

    public static void initialize(String directoryPath){
        String path = directoryPath;
        spriteTable = new HashMap<>();
        spriteTable.put(ImageGameObject.PLAYER, path + "/player.png");
        spriteTable.put(ImageGameObject.MONSTER, path + "/bad.png");
        spriteTable.put(ImageGameObject.CANDY1, path + "/candy-1.png");
        spriteTable.put(ImageGameObject.CANDY2, path + "/candy-2.png");
        spriteTable.put(ImageGameObject.CANDY3, path + "/candy-3.png");
        spriteTable.put(ImageGameObject.CANDY4, path + "/candy-4.png");
        spriteTable.put(ImageGameObject.SWITCH_OFF, path + "/button_close.png");
        spriteTable.put(ImageGameObject.SWITCH_ON, path + "/button_open.png");
        spriteTable.put(ImageGameObject.EXIT, path + "/door_open.png");
    }

   public static HashMap<ImageGameObject, String> getHashmap() {
       return spriteTable;
   }

}