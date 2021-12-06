package com.anish.calabashbros.maze;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Random;
import java.util.Arrays;
import java.lang.Math;

public class Maze {
    
    private Stack<Node> stack = new Stack<>();
    private Random rand = new Random();
    private int[][] maze;
    private int width,height;
    private int startX=0,startY=0,endX=width-1,endY=height-1;

    public Maze(int width,int height) {
        maze = new int[width][height];
        this.width=width;
        this.height=height;
        generateMaze();
    }

    public void generateMaze() {
        //generate random starting point
        switch(rand.nextInt(4)){
            case 0:
                startX=0;
                startY=rand.nextInt(height);
                break;
            case 1:
                startX=width-1;
                startY=rand.nextInt(height);
                break;
            case 2:
                startY=height-1;
                startX=rand.nextInt(width);
                break;
            case 3:
                startY=0;
                startX=rand.nextInt(width);
                break;
        }
        //perform DFS,set the endPoint as the FURTHEST node away from the start!!
        int maxDis=0;
        stack.push(new Node(startX,startY));
        while (!stack.empty()) {
            Node next = stack.pop();
            if (validNextNode(next)) {
                if(getDistance(startX, startY, next.x, next.y)>maxDis){
                    maxDis=getDistance(startX, startY, next.x, next.y);
                    endX=next.x;
                    endY=next.y;
                }
                maze[next.x][next.y] = 1;
                ArrayList<Node> neighbors = findNeighbors(next);
                randomlyAddNodesToStack(neighbors);
            }
        }
    }
    private int getDistance(int X1,int Y1,int X2,int Y2){
        return Math.abs(X1-X2)+Math.abs(Y1-Y2);
    }
    public int getStartX(){
        return startX;
    }
    public int getStartY(){
        return startY;
    }
    public int getEndX(){
        return endX;
    }
    public int getEndY(){
        return endY;
    }
    public boolean isFloor(int x,int y){
        return maze[x][y]==1;
    }


    private boolean validNextNode(Node node) {
        int numNeighboringOnes = 0;
        for (int y = node.y-1; y < node.y+2; y++) {
            for (int x = node.x-1; x < node.x+2; x++) {
                if (pointOnGrid(x, y) && pointNotNode(node, x, y) && maze[x][y] == 1) {
                    numNeighboringOnes++;
                }
            }
        }
        return (numNeighboringOnes < 3) && maze[node.x][node.y] != 1;
    }

    private void randomlyAddNodesToStack(ArrayList<Node> nodes) {
        int targetIndex;
        while (!nodes.isEmpty()) {
            targetIndex = rand.nextInt(nodes.size());
            stack.push(nodes.remove(targetIndex));
        }
    }

    private ArrayList<Node> findNeighbors(Node node) {
        ArrayList<Node> neighbors = new ArrayList<>();
        for (int y = node.y-1; y < node.y+2; y++) {
            for (int x = node.x-1; x < node.x+2; x++) {
                if (pointOnGrid(x, y) && pointNotCorner(node, x, y)
                    && pointNotNode(node, x, y)) {
                    neighbors.add(new Node(x, y));
                }
            }
        }
        return neighbors;
    }

    private Boolean pointOnGrid(int x, int y) {
        return x >= 0 && y >= 0 && x < width && y < height;
    }

    private Boolean pointNotCorner(Node node, int x, int y) {
        return (x == node.x || y == node.y);
    }
    
    private Boolean pointNotNode(Node node, int x, int y) {
        return !(x == node.x && y == node.y);
    }
        /*public String getRawMaze() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : maze) {
            sb.append(Arrays.toString(row) + "\n");
        }
        return sb.toString();
    }

    public String getSymbolicMaze() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                sb.append(maze[i][j] == 1 ? "*" : " ");
                sb.append("  "); 
            }
            sb.append("\n");
        }
        return sb.toString();
    }*/

}