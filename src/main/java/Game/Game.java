package Game;

import Game.Scenes.GameScene;
import Game.*;

public class Game {

    private static GameMap map;
    private static Player player;


    public Game(int mapDepth) { 

        player = new Player("");
    }

    public static void reset() {

        // Create map that is 20 rooms long.
        map = new GameMap(20);
    }

    public static void resetPlayer() {

        Player.setHunger(100);
        Player.setHealth(100);
    }

    public static void initPlayer(String name) {
        
        resetPlayer();
        Player.setName(name);
        GameScene.setPlayerName(Player.getName());
    }

}
