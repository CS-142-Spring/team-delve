package Engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Engine.UI.UI;

public class Engine {

    private static UI ui;

    HashMap<String, Scene> scenes = new HashMap<>();
    String currentScene;

    List<Sound> sounds = new ArrayList<>();

    public Engine(int width, int height) {

        ui = new UI(width, height);
    }

    public static void switchScene(String name) {
        ui.setCurrentPanel(name);
    }

    // Due to the way CardLayout works,
    // unless you call switchScene() the current scene will be the last one created.
    public void newScene(Scene scene, String name) {
        ui.addPanel(scene.getPanel(), name);
        scenes.put(name, scene);
    }

    public Sound newSound(String source, boolean stream) {
        sounds.add(new Sound(source, stream));
        return sounds.get(sounds.size() - 1);
    }

}
