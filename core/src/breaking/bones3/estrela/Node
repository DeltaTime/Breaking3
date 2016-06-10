/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breaking.bones3.estrela;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author alexandre.gcazaroes1
 * 
 *  VIDEO AULA https://www.youtube.com/watch?v=-L-WgKMFuhE&list=PLFt_AvWsXl0cq5Umv3pMC9SPnKjfp9eGW
 * 
 */
public class Node {
    public boolean walkable;
    public Vector2 worldPosition;
    public int gridX;
    public int gridY;

    public int gCost;
    public int hCost;
    public Node parent;

    private Texture nodeText;

    public Node(boolean _walkable, Vector2 _worldPos, int _gridX, int _gridY){
        this.walkable = _walkable;
        this.worldPosition = _worldPos;
        this.gridX = _gridX;
        this.gridY = _gridY;
    }

    public int fCost(){
        return gCost + hCost;
    }
}
