package controller;

import model.Labyrinthe;
import view.View;

import javafx.application.Application;
import javafx.stage.Stage;

public class Controller extends Application{

	private static View view = null;
	private static Labyrinthe labyrinthe = null;
	private static Controller INSTANCE = null;

	private Controller() {

		view = View.getInstance();
		view.setOnAction();
		labyrinthe = new Labyrinthe();
	}


	public static Controller makeInstance () {
		if (INSTANCE == null)
			INSTANCE = new Controller();
		else
			System.out.println("Instance de Controller déjà créée.\n");
		return INSTANCE;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//labyrinthe.buildRandomPath(labyrinthe.getRandomVertex);
		view.start(primaryStage);
		

	}

}
