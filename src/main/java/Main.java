import Engine.*;
import Game.Game;
import Game.Scenes.*;

public class Main {

    public static void main(String args[]) {

        Engine engine = new Engine(1664, 936);

        engine.newScene(new MainMenu(), "Main Menu");
        engine.newScene(new OptionsMenu(), "Options Menu");
        engine.newScene(new GameScene(), "Game Scene");

        Game game = new Game(4);

    }
}
