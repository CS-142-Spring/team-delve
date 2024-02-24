import Engine.*;
import Game.Game;
import Game.Scenes.*;

public class Main {

    public static void main(String args[]) {

        // Initialize engine and set window size.
        Engine engine = new Engine(1664, 936);

        // Initialize scenes.
        engine.newScene(new MainMenu(), "Main Menu");
        engine.newScene(new OptionsMenu(), "Options Menu");
        engine.newScene(new GameScene(), "Game Scene");
        engine.newScene(new WinScene(), "Win Scene");
        engine.newScene(new LoseScene(), "Lose Scene");

        // Initialize game.
        Game game = new Game(4);

    }
}
