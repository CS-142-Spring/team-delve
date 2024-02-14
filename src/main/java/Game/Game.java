package Game;

import Game.Scenes.GameScene;

public class Game {

    private static Map map;

    public Game(int mapDepth) { 

        GameScene.setText("You wake up in a dark, damp room.");
        GameScene.addTextLine("You are not sure how you got here.");
        GameScene.addTextLine("There is a vague memory of something. Something bad.");
        GameScene.addTextLine("You can't quite remember what.");
        GameScene.addTextLine("You have to get out of here.");

        map = new Map(40);
    }

}
