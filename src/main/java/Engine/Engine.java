package Engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Engine.UI.UI;
import Game.Scenes.MainMenu;

public class Engine {

    UI ui;

    HashMap<String, Scene> scenes = new HashMap<>();
    String currentScene;

    List<Sound> sounds = new ArrayList<>();

    public Engine(int width, int height) {

        ui = new UI(width, height);

        // Create all the scenes.
        newScene("Main Menu", new MainMenu());

        switchScene("Main Menu");
    }

    public void update() {

    }

    public void cleanup() {

    }

    public void switchScene(String name) {
        currentScene = name;
        ui.setCurrentPanel(name);
    }

    public void newScene(String name, Scene scene) {
        scene.setLabel(name); // Display the scenes name.
        ui.addPanel(scene.getPanel(), name);
        scenes.put(name, scene);
    }

    public Sound newSound(String source, boolean stream) {
        sounds.add(new Sound(source, stream));
        return sounds.get(sounds.size() - 1);
    }

}
