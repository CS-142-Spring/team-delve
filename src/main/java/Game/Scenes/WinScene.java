package Game.Scenes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;

import Engine.Engine;
import Engine.Scene;
import Engine.UI.Button;
import Engine.UI.Label;
import Engine.UI.Panel;

public class WinScene extends Scene {

    private BoxLayout boxLayout;

    private Panel messagePanel;
    private Label victoryMessage;
    private Button quit;

    public WinScene() {

        super();

        // Initialize interface.
        boxLayout = new BoxLayout(getPanel(), BoxLayout.PAGE_AXIS);
        getPanel().setLayout(boxLayout);
        getPanel().setBackgroundImage("resources/image/main_menu.png");
        
        messagePanel = new Panel();
        messagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        messagePanel.setBackground(Color.BLACK);

        victoryMessage = new Label("Congratulations! You have escaped the dungeon.");

        victoryMessage.setFontSize("regular");

        quit = new Button("Quit");

        // Quit button action.
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }); 

        messagePanel.add(victoryMessage);

        getPanel().add(Box.createRigidArea(new Dimension(0, 200)));
        getPanel().add(messagePanel);
        getPanel().add(quit);

    }
    
}
