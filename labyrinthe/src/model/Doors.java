package model;

import model.Arc.Type;
import view.GameObjectDrawer.ImageGameObject;

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

    @Override
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