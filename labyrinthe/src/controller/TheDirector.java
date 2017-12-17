package controller;

import java.util.LinkedList;
import java.util.Random;

import model.GameObject;
import model.GameObject.KindOfGameObject;
import model.Labyrinthe;
import model.Labyrinthe.Directions;
import model.Player;

public class TheDirector {

    private static LinkedList<GameObject> gameObjectList;
    private static Random random;

    private static Labyrinthe lab;

    private static Player player = null;
    private static LinkedList<Player>  monsters = null;
    private static int CandiesNumber;

    public static void initialize() {
        gameObjectList = new LinkedList<>();
        monsters = new LinkedList<>();
        random = new Random();
        CandiesNumber = 0;
        lab = Labyrinthe.getInstance();
    }

    public static void addGameObject(GameObject gameObject){
        if (gameObject.getType() == KindOfGameObject.PLAYER)
            setPlayer((Player) gameObject);
        else if(gameObject.getType() == KindOfGameObject.MONSTER)
        	monsters.push((Player)gameObject);

        gameObjectList.push(gameObject);
    }

    public static void setPlayer(Player player) {
        TheDirector.player = player;
    }

    public static Player getPlayer(){
        return player;
    }

    public static void removeGameObject(GameObject gameObject){
        gameObjectList.remove(gameObject);
    }

    public static LinkedList<GameObject> getGameObject(){
        return gameObjectList;
    }

    public static Random getRandom() {
        return random;
    }

    public static Labyrinthe getMaze() {
        return lab;
    }

    public static void addNbBonus(){
        CandiesNumber += 1;
    }
    
    private static boolean isNPC(int x, int y, Directions d) {
    	int newX = x;
    	int newY = y;
    	switch(d) {
    		case EAST:
    			newX = x + 1;
    			break;
    		case WEST:
    			newX = x - 1;
    			break;
    		case NORTH:
    			newY = y - 1;
    			break;
    		case SOUTH:
    			newY = y + 1;
    			break;
    		default:
    			return false;
    	}
    	for(Player monsters : monsters) {
    		if(monsters.getX() == newX && monsters.getY() == newY)
    			return true;
    	}
    	return false;
    }
    
    public static void tryMoveNPCs() {
    	LinkedList<Player> warehouse = new LinkedList<>();
    	int[] bitmap = new int[monsters.size()];
    	int i = 0;
    	for(Player monsters: monsters) {
    		warehouse.add(monsters);
    		bitmap[i] = 0;
    		i++;
    	}
    	
    	boolean hasMoved = true;
    	while(hasMoved) {
    		hasMoved = false;
	        for(Player monster : warehouse) {
	        	if(bitmap[warehouse.indexOf(monster)] == 1)
	        		continue;
	        	Directions dir = Labyrinthe.getMonsterDirection(monster.getX(), monster.getY());//a definir dans classe monstres extend gameobject
	        	if(dir != null) {
	        		boolean isMonster = isMonster(monster.getX(), monster.getY(), dir);
	        		if(!isMonster) {
	        			hasMoved = tryMoveCharacter(monster, dir);
	        			if(hasMoved)
	        				bitmap[warehouse.indexOf(monster)] = 1;
	        		}
	        	}
	        }
    	}
    }

    public static boolean tryMoveCharacter(Player player, Directions dir){
        int x = player.getX();
        int y = player.getY();
        boolean able = !maze.getWallsAt(x, y).contains(direction) || maze.getDoorsAt(x, y, false).contains(dir);//a adapter a notre code. Pour l'instant : maze = labyrinthe
        if (able) {
        	player.move(dir);
        	if(player.getType() == KindOfGameObject.PLAYER)
        		maze.updateDistFromPlayer(getPlayer().getX(), TheDirector.getPlayer().getY());
            EventManager.manageCollision();

            
        }
        return able;
    }
}