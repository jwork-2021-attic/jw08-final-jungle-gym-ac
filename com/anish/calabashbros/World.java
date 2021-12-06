package com.anish.calabashbros;
import com.anish.calabashbros.maze.Maze;

public class World {

    public static final int WIDTH = 60;
    public static final int HEIGHT = 30;
    public Maze maze;
    private Tile<Thing>[][] tiles;


    public World() {

        maze=new Maze(WIDTH,HEIGHT);

        if (tiles == null) {
            tiles = new Tile[WIDTH][HEIGHT];
        }

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                tiles[i][j] = new Tile<>(i, j);
                if(maze.isFloor(i, j))
                    tiles[i][j].setThing(new Floor(this));
                else
                    tiles[i][j].setThing(new Wall(this));
            }
        }
        tiles[maze.getEndX()][maze.getEndY()].setThing(new EndPointFloor(this));  //change the Floor of the endPoint

    }

    public Thing get(int x, int y) {
        return this.tiles[x][y].getThing();
    }

    public void put(Thing t, int x, int y) {
        this.tiles[x][y].setThing(t);
    }

}
