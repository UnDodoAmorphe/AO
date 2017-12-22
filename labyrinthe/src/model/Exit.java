package model;
import view.GameObjectDrawer.ImageGameObject;

/**
 * The Exit class defines the GameObject the exit door that the player need to open and go through to win the game. It is opened when there is no candy left on the board. 
 * 
 * @author DE MECQUENEM N
 * @author DEJONGHE V
 * @author GAUTIER F
 * @author GROSJEAN L
 * 
 */
public class Exit extends GameObject{
    private static Exit exit = null;
    private boolean isOpen = false;

    public Exit(Sommet sommet) {
        super(sommet, KindOfGameObject.EXIT);
        this.setImageGameObject(ImageGameObject.EXIT);
    }

    public Exit() {
        super(KindOfGameObject.EXIT);
        this.setImageGameObject(ImageGameObject.EXIT);
    }

    @Override
    public void eventCollision() {
        System.out.println("Sortie");
    }

    public static Exit getInstance () {
        if (exit == null)
            exit = new Exit();
        else
            System.out.println("Instance de sortie deja creee.\n");
        return exit;
    }

    public void setOpened() {
        isOpen=true;
    }

    public boolean isOpened() {
        return isOpen;
    }
}