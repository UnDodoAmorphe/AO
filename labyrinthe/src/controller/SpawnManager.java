package controller;
import java.util.Random;

import model.Arc;
import model.Button;
import model.Candy;
import model.Doors;
import model.Exit;
import model.GameObject;
import model.Player;

public class SpawnManager {



	public static void spawnEntityAtPosition(GameObject e, int x, int y){
			e.setX(x);
			e.setY(y);
			TheDirector.addGameObject(e);
		}
	

	public static GameObject spawnPlayer(int x, int y){
		GameObject e = new Player(true);
		spawnEntityAtPosition(e, x, y);
		return e;
	}
	public static GameObject spawnButton(int x, int y){
		GameObject e = new Button();
		spawnEntityAtPosition(e, x, y);
		return e;
	}
	public static GameObject spawnCandy(int x, int y){
		GameObject e = new Candy();
		spawnEntityAtPosition(e, x, y);
		return e;
	}

	public static GameObject spawnMonster(int x, int y) {
		GameObject e = new Player(false);
		spawnEntityAtPosition(e, x, y);
		return e;
	}

	public static GameObject spawnDoor(Arc edge) {
		GameObject e = new Doors(edge);
		spawnEntityAtPosition(e, x, y);
		return e;
	}

	public static GameObject spawnExitDoor(int x, int y) {
		GameObject e = new Exit();
		spawnEntityAtPosition(e, x, y);
		return e;
	}
}

