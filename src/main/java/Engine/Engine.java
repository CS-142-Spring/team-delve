package Engine;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Engine.UI.UI;

public class Engine {

    private static UI ui;

    // Stores all game scenes.
    HashMap<String, Scene> scenes = new HashMap<>();
    String currentScene;

    public Engine(int width, int height) {

        // Initialize UI.
        ui = new UI(width, height);
    }

    public static void switchScene(String name) {
        ui.setCurrentPanel(name);
    }

    // Due to the way CardLayout works,
    // unless you call switchScene() the current scene will be the last one created.
    public void newScene(Scene scene, String name) {
        // Add the scenes JPanel to the master JPanel.
        ui.addPanel(scene.getPanel(), name);
        scenes.put(name, scene);
    }

}
