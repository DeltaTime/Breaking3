/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breaking.bones3.estrela;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import java.util.ArrayList;
import static java.util.Collections.reverse;
import java.util.HashSet;

/**
 *
 * @author acronuslg_sup
 */
public class Pathfinding {
    private Grid grid;
    /*
    public Pathfinding(Grid _grid){

        this.grid = _grid;
    }
    public void FindPath(Vector2 startPos, Vector2 targetPos){
        Node startNode = grid.NodeFromWorldPoint(startPos);
        Node targetNode = grid.NodeFromWorldPoint(targetPos);

        ArrayList<Node> openSet = new ArrayList<Node>();
        HashSet<Node> closedSet = new HashSet<Node>();

        openSet.add(startNode);

        while (!openSet.isEmpty()){
            Node currentNode = openSet.get(0);

            for (int i = 1; i < openSet.size(); i++){
                if(openSet.get(i).fCost() < currentNode.fCost() || openSet.get(i).fCost() == currentNode.fCost() && openSet.get(i).hCost < currentNode.hCost){
                    currentNode = openSet.get(i);
                }
            }

            openSet.remove(currentNode);
            closedSet.add(currentNode);

            if(currentNode == targetNode){
                RetracePath(startNode, targetNode);
                return;
            }

            for (Node neighbour : grid.GetNeighbours(currentNode)) {
                if(!neighbour.walkable || closedSet.contains(neighbour)) {
                    continue;
                }

                int newMovementCostToNeighbour = currentNode.gCost + GetDistance(currentNode, neighbour);

                if (newMovementCostToNeighbour < neighbour.gCost || !openSet.contains(neighbour)){
                    neighbour.gCost = newMovementCostToNeighbour;
                    neighbour.hCost = GetDistance(neighbour, targetNode);
                    neighbour.parent = currentNode;

                    if (!openSet.contains(neighbour))
                        openSet.add(neighbour);
                }
            }
        }
    }

    public void RetracePath(Node startNode, Node endNode){
        ArrayList<Node> path = new ArrayList<Node>();
        Node currentNode = endNode;

        while (currentNode != startNode){
            path.add(currentNode);
            currentNode = currentNode.parent;
        }
        path = reverse(path);
        grid.path = path;
    }

    public ArrayList<Node> reverse(ArrayList<Node> list) {
        for(int i = 0, j = list.size() - 1; i < j; i++) {
            list.add(i, list.remove(j));
        }
        return list;
    }

    public int GetDistance(Node nodeA, Node nodeB){
        int dstX = Math.abs(nodeA.gridX - nodeB.gridX);
        int dstY = Math.abs(nodeA.gridY - nodeB.gridY);

        if (dstX > dstY)
            return 14 * dstY + 10 * (dstX - dstY);
        return 14 * dstX + 10 * (dstY - dstX);
    }
*/
}

