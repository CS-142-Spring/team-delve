package Game.Scenes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Engine.Engine;
import Engine.Scene;
import Engine.UI.Button;
import Engine.UI.Label;
import Engine.UI.UI;

public class OptionsMenu extends Scene {

    private BoxLayout boxLayout;

    private JPanel namePanel;
    private Label enterName;
    private JTextField field;
    private Button enter;

    public OptionsMenu() {

        super();

        boxLayout = new BoxLayout(getPanel(), BoxLayout.PAGE_AXIS);
        getPanel().setLayout(boxLayout);
        
        namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        namePanel.setBackground(Color.BLACK);

        enterName = new Label("Enter Player Name: ");
        enterName.setFontSize("regular");

        field = new JTextField(10);
        field.setFont(UI.getFont("regular"));

        enter = new Button("Enter");
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
