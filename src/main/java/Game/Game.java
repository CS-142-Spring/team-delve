package Game;

import Game.Scenes.GameScene;
import Game.*;

public class Game {

    private static Map map;
    private static Player player;

    public Game(int mapDepth) { 

        GameScene.setText("You wake up in a dark, damp room.");
        GameScene.addTextLine("You are not sure how you got here.");
        GameScene.addTextLine("There is a vague memory of something. Something bad.");
        GameScene.addTextLine("You can't quite remember what.");
        GameScene.addTextLine("You have to get out of here.");

    }

    public static void Reset() {

        map = new Map(5);
    }

    public static void InitPlayer(String name) {
        
        player = new Player(name);
    }

}
