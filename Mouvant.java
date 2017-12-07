package view;

import javafx.scene.image.ImageView;

public interface Mouvant {
	
	void rafraichir();
	void afficher();
	void init(ImageView image);

}
