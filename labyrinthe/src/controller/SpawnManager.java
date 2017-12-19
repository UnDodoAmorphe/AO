package controller;
import java.util.Random;

import model.Candy;
import model.Doors;
import model.Exit;
import model.GameObject;
import model.Player;

public class SpawnManager {

	public static void spawnAtRandomPosition(GameObject e){
		Random r = TheDirector.getRandom();
		int x = r.nextInt(TheDirector.getLab().getGraphe().getSizeX());
		int y = r.nextInt(TheDirector.getLab().getGraphe().getSizeY());
		spawnEntityAtPosition(e, x, y);
	}

	public static void spawnEntityAtPosition(GameObject e, int x, int y){
		e.setX(x);
		e.setY(y);
		TheDirector.addGameObject(e);
	}

	public static void spawnPlayerAtRandomPosition(){
		GameObject e = new Player(true);
		spawnAtRandomPosition(e);
	}

	public static void spawnCandyAtRandomPosition(){
		GameObject e = new Candy();
		spawnAtRandomPosition(e);
	}

	public static void spawnMonterAtRandomPosition() {
		GameObject e = new Player(false);
		spawnAtRandomPosition(e);
	}

	public static void spawnDoorsAtRandomPosition() {
		GameObject e = new Doors();
		spawnAtRandomPosition(e);
	}

	public static void spawnExitAtRandomPosition() {
		GameObject e = new Exit();
		spawnAtRandomPosition(e);
	}
}

