package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Button extends A_Static {

	@Override
	public void init(ImageView i) {
		// TODO Auto-generated method stub

	}

	public void setState () {

	}
	Image imageButtonClose= new Image(getClass().getResource("button_close.png").toExternalForm());
	imageView= new ImageView(image);
	Frame.pane.getChildren().add(this.imageView);
	double xt_Close=(int)((ViewFrame.WALL+sprite.getX()*(ViewFrame.WALL+ViewFrame.CELL))*ViewFrame.SPAN);
	double yt_Close=(int)((ViewFrame.WALL+sprite.getY()*(ViewFrame.WALL+ViewFrame.CELL))*ViewFrame.SPAN);
	imageView.setX(xt);
	imageView.setY(yt);
}
	Image imageButtonOpen= new Image(getClass().getResource("button_open.png").toExternalForm());
	imageView= new ImageView(image);
	Frame.pane.getChildren().add(this.imageView);
	double xt_Open=(int)((ViewFrame.WALL+sprite.getX()*(ViewFrame.WALL+ViewFrame.CELL))*ViewFrame.SPAN);
	double yt_Open=(int)((ViewFrame.WALL+sprite.getY()*(ViewFrame.WALL+ViewFrame.CELL))*ViewFrame.SPAN);
	imageView.setX(xt);
	imageView.setY(yt);
	}
}
