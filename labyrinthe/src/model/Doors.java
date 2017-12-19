package model;
import com.sun.javafx.geom.Edge;
import model.Arc.Type;

public class Doors extends GameObject {

    private boolean isOpen;
    private Arc edge;

    public Doors() {
        super(KindOfGameObject.DOORS);
        Labyrinthe lab = Labyrinthe.getInstance();
        isOpen = false;
        this.edge = lab.getGraphe().randomEdge();
        this.edge.setType(Type.CLOSED_DOOR);
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
        this.edge.setType(isOpen ? Type.OPENED_DOOR : Type.CLOSED_DOOR);
        setImageGameObject(isOpen ? ImageGameObject.SWITCH_ON : ImageGameObject.SWITCH_OFF);
    }

}