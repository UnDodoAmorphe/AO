package model;

public class Exit extends GameObject{
    public Exit(int x, int y) {
        super(x, y, KindOfGameObject.EXIT);
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
}
