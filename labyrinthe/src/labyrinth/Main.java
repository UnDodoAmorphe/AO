package labyrinth;

import javafx.application.Application;
import javafx.stage.Stage;
import controller.Controller;

public class Labyrinth extends Application{

	private static Controller controller;
	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage stage) throws Exception {
		controller = Controller.makeInstance();
		controller.start(stage);
		
	}

}
