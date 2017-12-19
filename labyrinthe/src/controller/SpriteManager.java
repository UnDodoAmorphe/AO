package controller;

import javafx.scene.image.Image;
import model.GameObject.ImageGameObject;

import java.util.HashMap;

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