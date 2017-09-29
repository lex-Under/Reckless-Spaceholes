package impl;

import core.Explodable;
import core.GameObject;
import core.Intersectable;
import core.Projectile;

/**
 * Реализация взрываемого снаряда.
 */
public class Rocket extends GameObject implements Projectile, Explodable {
    private int radiusExpl;
    private int damage;

    public Rocket(int radiusExpl, int damage){
        this.radiusExpl = this.radiusExpl;
        this.damage=damage;
    }
    public Rocket(int x, int y, int radius, int damage){
        super(x,y);
        this.radiusExpl =radius;
        this.damage=damage;
    }

    @Override
    public void explode() {
        Explosion rocketExplosion = new Explosion(this.getX(),this.getY(),radiusExpl,damage);
        rocketExplosion.explode();
    }

    @Override
    public void onIntersect(Intersectable intersectedWith) {
        this.explode();
    }
}
