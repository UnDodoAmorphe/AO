package controller;

import javafx.stage.Stage;
import model.Labyrinthe;

public class Controller {

	private static Controller instance;
	private Labyrinthe labyrinthe;

	public static Controller getInstance() {
		// TODO Auto-generated method stub
		if (instance==null)
			instance = new Controller();
		
		return null;
	}

	
private Controller() {
	//view=new View();
	labyrinthe=new Labyrinthe();
	}


public void start(Stage stage) {
	// TODO Auto-generated method stub
	labyrinthe.buildRandomPath(labyrinthe.getRandomVertex);
	stage.show();
}
}
