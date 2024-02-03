package Game.Scenes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;

import Engine.Engine;
import Engine.Scene;
import Engine.UI.Button;
import Engine.UI.Label;

public class MainMenu extends Scene {

    private BoxLayout boxLayout;

    private Button playButton;
    private Button loadButton;
    private Button quitButton;
    private Label title;
    private Label subtitle;

    public MainMenu() {

        super();

        boxLayout = new BoxLayout(getPanel(), BoxLayout.PAGE_AXIS);
        getPanel().setLayout(boxLayout);

        title = new Label("Delve");
        title.setFontSize("large");

        subtitle = new Label("A game based on the movie, based on the book, based on a true (allegedly) story.");
        subtitle.setFontSize("small");
        subtitle.setColor(Color.GRAY);

        playButton = new Button("Play");
        loadButton = new Button("Load");
        quitButton = new Button("Quit");

        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Engine.switchScene("Options Menu");
            }
        });

        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Engine.switchScene("Game Scene");
            }
        });

        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        getPanel().add(Box.createRigidArea(new Dimension(0, 180)));
        getPanel().add(Box.createRigidArea(new Dimension(60, 0)));

        getPanel().add(title);
        getPanel().add(subtitle);
        getPanel().add(Box.createRigidArea(new Dimension(0, 100)));

        getPanel().add(playButton);
        getPanel().add(loadButton);
        getPanel().add(quitButton);

        getPanel().add(Box.createVerticalGlue());

    }
    
}
