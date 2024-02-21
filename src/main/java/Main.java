import Engine.*;
import Game.Game;
import Game.Scenes.*;
import main.java.Engine.Json;

public class Main {

    public static void main(String args[]) {

        Engine engine = new Engine(1664, 936);

        engine.newScene(new MainMenu(), "Main Menu");
        engine.newScene(new EndScene(), "Options Menu");
        engine.newScene(new GameScene(), "Game Scene");
        engine.newScene(new EndScene(), "End Scene");

        Game game = new Game(4);
        // Json.loadJson("resources/data/npcs.json");

    }
}
