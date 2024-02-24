package Game.Scenes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JTextField;

import Game.Game;
import Game.Player;
import Engine.Engine;
import Engine.Scene;
import Engine.UI.Button;
import Engine.UI.Label;
import Engine.UI.Panel;
import Engine.UI.UI;

public class OptionsMenu extends Scene {

    private BoxLayout boxLayout;

    private Panel namePanel;
    private Label enterName;
    private JTextField field;
    private Button enter;

    public OptionsMenu() {

        super();

        // Initialize interface.
        boxLayout = new BoxLayout(getPanel(), BoxLayout.PAGE_AXIS);
        getPanel().setLayout(boxLayout);
        getPanel().setBackgroundImage("resources/image/main_menu.png");
        
        namePanel = new Panel();
        namePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        namePanel.setBackground(Color.BLACK);

        enterName = new Label("Enter Player Name: ");
        enterName.setFontSize("regular");

        field = new JTextField(10);
        field.setFont(UI.getFont("regular"));

        enter = new Button("Enter");

        // Enter button action.
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Game.initPlayer(field.getText());
                Game.reset();
                Engine.switchScene("Game Scene");
            }
        }); 

        namePanel.add(enterName);
        namePanel.add(field);
        namePanel.add(enter);

        getPanel().add(Box.createRigidArea(new Dimension(0, 200)));
        getPanel().add(namePanel);

    }
    
}
