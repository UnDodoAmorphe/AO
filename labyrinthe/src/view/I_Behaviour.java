package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.GameObjectDrawer.ImageGameObject;

public interface I_Behaviour {
	
	void init (ImageView i);
	void refresh();
	public Image getSprite(ImageGameObject type);
}
