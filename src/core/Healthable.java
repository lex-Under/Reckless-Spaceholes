package core;

/**
 * Интерфейс для игровыъ объектов, характеризуемых наличием очков здоровья.
 */
public interface Healthable {
    int getHitpoints();
    void setHitpoints(int hitpoints);
}
