package Engine;

import javax.swing.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Game.Scenes.MainMenu;

public class Engine {

    private JFrame frame;
    private CardLayout uiLayout;
    private JPanel masterPanel;

    HashMap<String, Scene> scenes = new HashMap<>();
    String currentScene;

    List<Sound> sounds = new ArrayList<>();

    public Engine(int width, int height) {

        initUI(width, height);

        // Create all the scenes.
        newScene("Main Menu", new MainMenu());

        switchScene("Main Menu");
    }

    private void initUI(int width, int height) {

        frame = new JFrame("Delve");
        uiLayout = new CardLayout();

        masterPanel = new JPanel();
        masterPanel.setLayout(uiLayout);
        masterPanel.setBackground(Color.GREEN);

        uiLayout.show(masterPanel, "1");

        frame.add(masterPanel);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public void update() {

    }

    public void cleanup() {

    }

    public void switchScene(String name) {
        currentScene = name;
        uiLayout.show(masterPanel, name);
    }

    public void newScene(String name, Scene scene) {
        scenes.put(name, scene);
        Scene addedScene = scenes.get(name);
        masterPanel.add(addedScene.getPanel(), name);
    }

    public Sound newSound(String source, boolean stream) {
        sounds.add(new Sound(source, stream));
        return sounds.get(sounds.size() - 1);
    }
}
