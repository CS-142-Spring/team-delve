package Engine;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Game.Scenes.MainMenu;

public class Engine {

    private JFrame frame;
    private CardLayout uiLayout;
    private JPanel masterPanel;
    private static Font uiFont;

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

        // Font
        try {

            File fontFile = new File("resources/font/Alegreya-Regular.ttf");
            Font loadedFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            uiFont = loadedFont.deriveFont(Font.PLAIN, 24f);

        } catch (IOException | FontFormatException e) {

            e.printStackTrace();
        }

        masterPanel = new JPanel();
        masterPanel.setLayout(uiLayout);
        masterPanel.setBackground(Color.GREEN);

        uiLayout.show(masterPanel, "masterPanel");

        frame.add(masterPanel);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.pack();
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
        addedScene.setLabel(name);
        masterPanel.add(addedScene.getPanel(), name);
    }

    public Sound newSound(String source, boolean stream) {
        sounds.add(new Sound(source, stream));
        return sounds.get(sounds.size() - 1);
    }

    public static Font getFont() {
        return uiFont;
    }
}
