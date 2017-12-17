package controller;

import java.util.Random;

public class theDirector {
	public static void spawnRandom(GameObject e){
        Random r = GameManager.getRandom();
        int x = r.nextInt(GameManager.getMaze().getSizeX());
        int y = r.nextInt(GameManager.getMaze().getSizeY());
        spawnEntityAtPosition(e, x, y);
    }

}
