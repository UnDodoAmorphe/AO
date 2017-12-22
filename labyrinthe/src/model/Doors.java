package model;

import model.Arc.Type;
import view.GameObjectDrawer.ImageGameObject;
/**
 * The Doors class defines the GameObjects that can be opened or closed depending on the Edge type
 * 
 * @author DE MECQUENEM N
 * @author DEJONGHE V
 * @author GAUTIER F
 * @author GROSJEAN L
 * 
 */
public class Doors extends GameObject {

    private boolean isOpen;
    private Arc edge;

    public Doors() {
        super(KindOfGameObject.DOORS);
    }

    public Doors(Arc edge) {
        super(edge, KindOfGameObject.DOORS);
        isOpen = false;
        setImageGameObject(ImageGameObject.SWITCH_OFF);
    }

 
    public void eventCollision() {
        isOpen = !isOpen;
        this.edge.setType(isOpen ? Type.OPENED_DOOR : Type.CLOSED_DOOR);
        setImageGameObject(isOpen ? ImageGameObject.SWITCH_ON : ImageGameObject.SWITCH_OFF);
    }

    public void setOpened() {
        isOpen=true;
    }

    public boolean isOpened() {
        return isOpen;
    }

}