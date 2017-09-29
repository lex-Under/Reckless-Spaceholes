package core;

/**
 * Абстрактный класс для игровых объектов, характеризумых целочисленными координатами положения
 */
public abstract class GameObject implements Cloneable {

    GameScene gameScene;
    public GameScene getGameScene(){
        return gameScene;
    }
    public int x;
    public int y;

    public GameObject(){
        this.x=0;
        this.y=0;
    }
    public GameObject(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int newX){
        this.x=newX;
    }
    public void setY(int newY){
        this.y = y;
    }

    /**
     * Евклидовое расстояние м/у игровми объектами
     * @param gameObj1
     * @param gameObj2
     * @return
     */
    public static double distance(GameObject gameObj1,GameObject gameObj2){
        int delta_x = gameObj2.x - gameObj1.x;
        int delta_y = gameObj2.y - gameObj1.y;
        double distance = Math.sqrt(delta_x*delta_x + delta_y*delta_y);
        return distance;
    }

    @Override public GameObject clone() {
        try {
            GameObject res = (GameObject) super.clone();
            return res;
        } catch (CloneNotSupportedException exc){
            exc.printStackTrace();
            return null;
        }
    }
}
