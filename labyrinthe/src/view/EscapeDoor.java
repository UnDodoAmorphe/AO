package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EscapeDoor extends A_Static {

	@Override
	public void init(ImageView i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setState() {
		// TODO Auto-generated method stub
		
	}
	Image image= new Image(getClass().getResource("door_open.png").toExternalForm());
	imageView= new ImageView(image);
	Frame.pane.getChildren().add(this.imageView);
	double xt=(int)((ViewFrame.WALL+sprite.getX()*(ViewFrame.WALL+ViewFrame.CELL))*ViewFrame.SPAN);
	double yt=(int)((ViewFrame.WALL+sprite.getY()*(ViewFrame.WALL+ViewFrame.CELL))*ViewFrame.SPAN);
	imageView.setX(xt);
	imageView.setY(yt);
 }
}
