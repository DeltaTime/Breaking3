/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breaking.bones3.estrela;

import breaking.bones3.tools.B2WorldCreator;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import java.util.ArrayList;

/**
 *
 * @author acronuslg_sup
 * 
 */
public class Grid {

    private TiledMap map;
    /*
    private World world;

    public Vector2 gridWorldSize;
    public float nodeRadius;
    public Node[][] grid;
    public ArrayList<Node> path;

    int gridSizeX, gridSizeY;

    public Pathfinding pathfinding;

    public B2WorldCreator b2WorldCreator;
    private Object GameManager;
    public Grid(World _world, TiledMap _map, B2WorldCreator _b2WorldCreator, float _nodeRadius, int largura, int altura) {
        this.world = _world;
        this.gridWorldSize = new Vector2(largura, altura);
        this.nodeRadius = _nodeRadius;
        this.map = _map;
        this.b2WorldCreator = _b2WorldCreator;
        gridSizeX = (int) (gridWorldSize.x / nodeRadius);
        gridSizeY = (int) (gridWorldSize.y / nodeRadius);
        System.out.printf("X: "+gridSizeX+" Y: "+gridSizeY);
        CreateGrid();
        pathfinding = new Pathfinding(this);
    }

    public void CreateGrid() {
        grid = new Node[gridSizeX][gridSizeY];

        for (int x = 0; x < gridSizeX; x++) {
            for (int y = 0; y < gridSizeY; y++) {
                Vector2 worldPoint = new Vector2((x * nodeRadius) / GameManager.getInstance().getPPM(), (y * nodeRadius) / GameManager.getInstance().getPPM());
                grid[x][y] = new Node(foundNodeNotWalkable(x,y), worldPoint, x, y);
            }
        }
        
    }

    public ArrayList<Node> GetNeighbours(Node node) {
        ArrayList<Node> neighbours = new ArrayList<Node>();

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0)
                    continue;

                int checkX = node.gridX + x;
                int checkY = node.gridY + y;

                if (checkX >= 0 && checkX < gridSizeX && checkY >= 0 && checkY < gridSizeY) {
                    neighbours.add(grid[checkX][checkY]);
                }
            }
        }
        return neighbours;
    }

    public Node NodeFromWorldPoint(Vector2 worldPosition) {
        int x = (int) ((worldPosition.x * gridWorldSize.x/2) / gridWorldSize.x);
        int y = (int) ((worldPosition.y * gridWorldSize.y/2) / gridWorldSize.y);
        return getNode(x, y);
    }

    public ArrayList<Node> Find(Vector2 seekPos, Vector2 targetPos) {
        pathfinding.FindPath(seekPos, targetPos);
        return path;
    }

    public Node getNode(int x, int y) {
        return grid[x][y];
    }

    public boolean foundNodeNotWalkable(int x, int y) {
       for (Node_Grid node: this.b2WorldCreator.getObjects()) {
            if(x >= (int)(node.getStartworldPosition().x / nodeRadius)
                    && x <= (int)(node.getEndsworldPosition().x / nodeRadius)
                    && y >= (int)(node.getStartworldPosition().y / nodeRadius)
                    && y <= (int)(node.getEndsworldPosition().y / nodeRadius)){
                return node.isWalkable();
            }
        }
        return true;
    }
*/
}
