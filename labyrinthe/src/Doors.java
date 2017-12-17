import com.sun.javafx.geom.Edge;

import model.GameObject;
import model.Labyrinthe;

public class Doors extends GameObject {

    private boolean isOpen;
    private Edge edge;

    public Doors() {
        super(KindOfGameObject.DOORS);
        Labyrinthe lab = Labyrinthe.getInstance();
        isOpen = false;
        this.edge = lab.getRandomEdge();
        this.edge.setWallType(WallType.CLOSED_DOOR);
        setImageGameObject(ImageGameObject.SWITCH_OFF);
    }

    public Doors(int x, int y) {
        super(x, y, KindOfGameObject.DOORS);
        isOpen = false;
        setImageGameObject(ImageGameObject.SWITCH_OFF);
    }

    @Override
    public void eventCollision() {
        isOpen = !isOpen;
        this.edge.setWallType(isOpen ? WallType.OPENED_DOOR : WallType.CLOSED_DOOR);
        setSpriteType(isOpen ? ImageGameObject.SWITCH_ON : ImageGameObject.SWITCH_OFF);
    }

}