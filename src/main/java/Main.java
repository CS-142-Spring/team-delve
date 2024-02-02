import Engine.*;

public class Main {

    public static void main(String args[]) {

        Engine engine = new Engine(1280, 720);

        engine.update();
        engine.cleanup();

    }
}
