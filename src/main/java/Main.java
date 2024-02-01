import Engine.*;
import Game.Map;

public class Main {

    public static void main(String args[]) {

        Engine engine = new Engine(1280, 720);
        // Map map = new Map(5);

        engine.update();
        engine.cleanup();

    }
}
