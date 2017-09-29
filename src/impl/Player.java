package impl;

import core.Explodable;
import core.GameObject;
import core.Projectile;

/**
 * Пример создания корабля игрока.
 */
public class Player extends Ship {
    public <E extends GameObject & Explodable, P extends GameObject & Projectile> Player(int x, int y, E explosionByDeath, int hp, P projectile) {
        super(x, y, explosionByDeath, hp, projectile);
    }

    //// ----Добавьте остальную реализацию ниже:
}
