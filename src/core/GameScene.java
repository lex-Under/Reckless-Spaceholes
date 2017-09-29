package core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Игровое поле, содержащее в себе все текущие игровые объекты
 */
public class GameScene {

    private int width;
    private int height;
    private List<GameObject> gameObjects;

    public GameScene(int width,int height){
        this(width,height,new ArrayList<GameObject>());
    }
    public GameScene(int width, int height, List<GameObject> gameObjects){
        this.width = width;
        this.height = height;
        this.gameObjects=gameObjects;
    }
    public void add(GameObject gameObject){
        gameObjects.add(gameObject);
        gameObject.gameScene=this;
    }
    public void remove(GameObject gameObject){
        gameObjects.remove(gameObject);
        gameObject.gameScene=null;
    }
    public GameObject[] getAll(){
        return gameObjects.toArray(new GameObject[0]);
    }
}
