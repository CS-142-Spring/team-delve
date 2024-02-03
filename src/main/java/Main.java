import Engine.*;
import Game.Scenes.*;

public class Main {

    public static void main(String args[]) {

        Engine engine = new Engine(1920, 1080);

        engine.newScene(new MainMenu(), "Main Menu");
        engine.newScene(new OptionsMenu(), "Options Menu");
        engine.newScene(new GameScene(), "Game Scene");

    }
}
