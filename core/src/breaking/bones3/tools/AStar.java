/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

import java.util.ArrayList;

/**
 *
 * @author alexandre.gcazaroes1
 */
public class AStar {
    
    private Node[][] map;
    private Node startPosition;
    private Node endPosition;
    private ArrayList<Node> openList;
    private ArrayList<Node> closeList;
    

    public AStar() {
        openList = new ArrayList<>();
        closeList = new ArrayList<>();
    }
    
    public Node AStar(Node startPos, Node endPos, Node[][] map){
        this.map = map;
        this.startPosition = startPos;
        this.endPosition = endPos;
        openList.add(startPos);
        
        while (!openList.isEmpty()) {
            
            Integer f = Integer.MAX_VALUE;
            Node current = null;
            for(int i = 0;  i < openList.size(); i++){
                if(openList.get(i).getF() < f){
                    current = openList.get(i);
                    System.out.println(current.getX()+ " " + current.getY());
                    closeList.add(current);
                    openList.remove(current);
                    f = current.getF();
                }
            }
            for(int j = 0; j < map.length; j++){
                for(int i = 0; i < map.length; i++){
                    if(closeList.contains(map[i][j]) == true) {
                        continue;
                    }
                    else{
                        if(openList.contains(map[i][j]) == false){
                            openList.add(map[i][j]);
                            map[i][j].setPai(current);
                            map[i][j].setG(heuristic(map[i][j].getPai(), map[i][j]) + map[i][j].getPai().getG());
                            map[i][j].setH(heuristic(map[i][j], endPosition));
                            map[i][j].update();
                        }
                        else{
                            if(map[i][j].getG() < current.getG()){
                                map[i][j].setPai(current);
                                map[i][j].setG(heuristic(map[i][j].getPai(), map[i][j]) + map[i][j].getPai().getG());
                                map[i][j].setH(heuristic(map[i][j], endPosition));
                                map[i][j].update();
                            }
                        }
                    }
                }
            }
            if(closeList.contains(endPosition) != false){
                System.out.println("Start " + startPosition.getX() + " " + startPosition.getY());
                System.out.println("End " + endPosition.getX() + " " + endPosition.getY());
                break;
            }
        }
        return startPosition;
    }
    
    public int heuristic(Node start, Node end){
        return Math.abs((int) (Math.sqrt(Math.pow((start.getX()-end.getX()), 2)+ Math.pow(start.getY() - end.getY(), 2))))/100;
    }
}
