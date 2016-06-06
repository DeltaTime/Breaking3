/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

/**
 *
 * @author alexandre.gcazaroes1
 */
public class Node {
    private Node pai;
    private int x;
    private int y;
    private int g;  // g is distance from the source
    private int h;  // h is the heuristic of destination.
    private int f;  // f = g + h 
    
    public Node(int x, int y) {
        pai = null;
        this.x = x;
        this.y = y;
    }
    
    public void update(){
     this.f = g + h;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Node getPai() {
        return pai;
    }

    public void setPai(Node pai) {
        this.pai = pai;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }
}
