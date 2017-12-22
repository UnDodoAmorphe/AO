package controller;
import java.util.Random;

import model.Arc;
import model.Button;
import model.Candy;
import model.Doors;
import model.Exit;
import model.GameObject;
import model.Player;
import model.Sommet;

public class SpawnManager {

	public static void spawnEntityAtPosition(GameObject e, Sommet sommet){
		e.setSommet(sommet.getX(),sommet.getY());
		TheDirector.addGameObject(e);
	}


	public static GameObject spawnPlayer(Sommet sommet){
		GameObject e = new Player(true);
		spawnEntityAtPosition(e, sommet);
		return e;
	}
	public static GameObject spawnButton(Sommet sommet, Doors door){
		GameObject e = new Button(sommet, door);
		spawnEntityAtPosition(e, sommet);
		return e;
	}
	public static GameObject spawnCandy(Sommet sommet){
		GameObject e = new Candy();
		spawnEntityAtPosition(e, sommet);
		return e;
	}

	public static GameObject spawnMonster(Sommet sommet) {
		GameObject e = new Player(false);
		spawnEntityAtPosition(e, sommet);
		return e;
	}

	public static GameObject spawnDoor(Arc edge) {
		GameObject e = new Doors(edge);
		TheDirector.addGameObject(e);
		return e;
	}

	public static GameObject spawnExitDoor(Sommet sommet) {
		GameObject e = new Exit();
		spawnEntityAtPosition(e, sommet);
		return e;
	}
}

