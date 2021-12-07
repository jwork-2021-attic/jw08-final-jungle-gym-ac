package game;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import asciiPanel.AsciiPanel;

import java.awt.Color;
import map.MyMap;

public class World {

    public static final int WIDTH = 26;
    public static final int HEIGHT = 24;
    public MyMap map;
    private Tile<Thing>[][] tiles;
    public Player player;
    
    //private Random rand = new Random();
    //private Color wallColor,floorColor;

    public World() {

        map=new MyMap(WIDTH,HEIGHT,0);

        if (tiles == null) {
            tiles = new Tile[WIDTH][HEIGHT];
        }

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                tiles[i][j] = new Tile<>(i, j);
                if(map.getType(i,j)==MyMap.tile)
                    tiles[i][j].setThing(new Nothing(this));
                else
                    tiles[i][j].setThing(new Wall(this));
            }
        }
    //player
        player=new Player(AsciiPanel.black,this);
        put(player,map.getStartX(),map.getStartY());
        Thread playerThread=new Thread(player);
        playerThread.start();
        player.run();
    //monsters
        Monster monster;
        ExecutorService exec = Executors.newFixedThreadPool(map.monsterPositions.size());
        for (Map.Entry<Integer,Integer> entry: map.monsterPositions.entrySet()){
            monster=new Monster(AsciiPanel.black, this);
            put(monster,entry.getKey(),entry.getValue());
            exec.execute(monster);
        }
        exec.shutdown();
    }

    public Thing get(int x, int y) {
        return this.tiles[x][y].getThing();
    }

    public boolean put(Thing t, int x, int y) {
        return this.tiles[x][y].setThing(t);
    }

    public void empty(int x,int y){
        this.tiles[x][y].setThing(new Nothing(this));
    }
}
