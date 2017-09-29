package impl;

import core.*;

/**
 * Абстрактный класс корабля.
 */
public abstract class Ship extends GameObject implements Explodable, Healthable, Intersectable, Shooter {

    private Explodable expl;
    private int curHp;
    private Projectile proj;

    public <E extends GameObject & Explodable, P extends GameObject & Projectile> Ship(int x, int y, E explosionByDeath, int hp, P projectile){
        super(x,y);
        this.expl=explosionByDeath;
        this.curHp=hp;
        this.proj=projectile;
    }

    @Override
    public void shoot() {
        GameObject newProj = ((GameObject)proj).clone();
        newProj.setX(this.x);
        newProj.setY(this.y+1);
        getGameScene().add(newProj);
    }

    @Override
    public int getHitpoints() {
        return curHp;
    }

    @Override
    public void setHitpoints(int hitpoints) {
        this.curHp=hitpoints;
    }

    @Override
    public void explode() {
        GameObject newExpl = ((GameObject)expl).clone();
        newExpl.setX(this.x);
        newExpl.setY(this.y);
        getGameScene().add(newExpl);
        ((Explodable)newExpl).explode();
    }

    @Override
    public void onIntersect(Intersectable intersectedWith) {
        if(intersectedWith instanceof Explodable){
            ((Explodable) intersectedWith).explode();
        }
    }
}
