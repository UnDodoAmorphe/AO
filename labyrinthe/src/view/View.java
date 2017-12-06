package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class View extends Application{
	
	private static View INSTANCE = null;

	private View () {}

	public static View getInstance () {
		if (INSTANCE == null)
			INSTANCE = new View();
		else
			System.out.println("Instance de View déjà créée.");
		return INSTANCE;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Pac man");
		Frame.drawFrame(primaryStage, 16, 16);
		
		primaryStage.show();

	}


	public void setOnAction (View this) {
		
	}
	
}
