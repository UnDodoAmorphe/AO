package model;

public class Model {

	private static Model INSTANCE = null;
	
	private Model () {}

	public static Model getInstance () {
		if (INSTANCE == null)
			INSTANCE = new Model();
		else
			System.out.println("Instance de Model déjà créée.");
		return INSTANCE;
	}

}
