package impl;

import core.Explodable;
import core.GameObject;
import core.Healthable;


/**
 * Реализация взрыва, характеризующегося уроном и радиусом поражения.
 */
public class Explosion extends GameObject implements Explodable{

    private int radius;
    private int damage;

    public Explosion(int radius, int damage){
        this.radius=radius;
        this.damage=damage;
    }
    public Explosion(int x, int y, int radius, int damage){
        super(x,y);
        this.radius=radius;
        this.damage=damage;
    }

    @Override
    public void explode() {
        GameObject[] allGameObjects = this.getGameScene().getAll();
        for(GameObject go : allGameObjects){
            if(go instanceof Healthable){
                double distance = GameObject.distance(this, go);
                if(distance<=radius){
                    Healthable goHealthable = (Healthable)go;
                    goHealthable.setHitpoints(goHealthable.getHitpoints() - damage);
                }
            }
        }
    }
}
