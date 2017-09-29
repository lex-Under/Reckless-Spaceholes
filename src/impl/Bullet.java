package impl;

import core.*;

/**
 * Реализация объекта-снаряда, характеризуемого некоторым уроном.
 */
public class Bullet extends GameObject implements Projectile {

    private int damage;

    public Bullet(int damage){
        this.damage=damage;
    }
    public Bullet(int x, int y, int damage){
        super(x,y);
        this.damage=damage;
    }

    @Override
    public void onIntersect(Intersectable intersectedWith) {
        if(intersectedWith instanceof Healthable){
            Healthable intersectedH = (Healthable)intersectedWith;
            intersectedH.setHitpoints(intersectedH.getHitpoints()-damage);
        } else if (intersectedWith instanceof Explodable){
            ((Explodable)intersectedWith).explode();
        }
    }
}
