package view;

import controller.SpriteManager;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.GameObject.ImageGameObject;

public abstract class A_Moving implements I_Behaviour {

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}
	
	public Image getSprite(ImageGameObject type){
        String path = SpriteManager.getHashmap().get(type);
        Image i = new Image("file:" + path);
        return i;
    }

}
