package Engine;

import javax.swing.*;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;

import Game.Scenes.MainMenu;

public class Engine {

    private JFrame frame;
    private CardLayout uiLayout;
    private JPanel masterPanel;

    List<Scene> scenes = new ArrayList<>();
    List<Sound> sounds = new ArrayList<>();

    public Engine(int width, int height) {

        initUI(width, height);

        // Create all the scenes.
        newScene(new MainMenu());
    }

    private void initUI(int width, int height) {

        frame = new JFrame();
        uiLayout = new CardLayout();

        masterPanel = new JPanel();
        masterPanel.setLayout(uiLayout);

        frame.setSize(width, height);
        frame.setLayout(null);
        frame.setTitle("Delve");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        uiLayout.show(masterPanel, "1");
    }

    public void update() {

    }

    public void cleanup() {

    }

    public Scene newScene(Scene scene) {
        scenes.add(scene);
        Scene addedScene = scenes.get(scenes.size() - 1);
        masterPanel.add(addedScene.getPanel(), String.valueOf(scenes.size() + 1));
        return addedScene;
    }

    public Sound newSound(String source, boolean stream) {
        sounds.add(new Sound(source, stream));
        return sounds.get(sounds.size() - 1);
    }
}
