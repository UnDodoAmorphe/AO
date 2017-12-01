package controller;

import model.Model;
import view.View;

import javafx.application.Application;
import javafx.stage.Stage;

public class Controller extends Application{

	private static View view = null;
	private static Model model = null;
	private static Controller INSTANCE = null;

	private Controller() {

		view = View.getInstance();
		view.setOnAction();
		model = Model.getInstance();
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
		view.start(primaryStage);
		

	}

}
