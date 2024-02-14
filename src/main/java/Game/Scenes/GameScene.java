package Game.Scenes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Engine.Scene;
import Engine.UI.Button;
import Engine.UI.Label;
import Engine.UI.UI;
import Game.Map;

public class GameScene extends Scene {

    private Label healthLabel;
    private Label hungerLabel;
    private Label roomLabel;
    private Label invLabel;

    private static JTextArea text;

    private JPanel topPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel bottomPanel;
    private JPanel centerPanel;

    private static Button option1;
    private static Button option2;

    public GameScene() {

        super();

        getPanel().setBackgroundImage("resources/image/main_menu.png");
        Border border = BorderFactory.createLineBorder(Color.WHITE);

        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBorder(border);
        topPanel.setBackground(Color.BLACK);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBorder(border);
        bottomPanel.setBackground(Color.BLACK);

        option1 = new Button("Option 1");
        option2 = new Button("Option 2");

        option1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Map.enterLeft();
            }
        }); 

        leftPanel = new JPanel();
        leftPanel.setBorder(border);
        leftPanel.setBackground(Color.BLACK);

        rightPanel = new JPanel();
        rightPanel.setBorder(border);
        rightPanel.setBackground(Color.BLACK);

        centerPanel = new JPanel();
        centerPanel.setBackground(Color.BLACK);

        healthLabel = new Label("HP: 100");
        hungerLabel = new Label("Hunger: 100");
        roomLabel = new Label("Room");
        invLabel = new Label("Inventory");

        text = new JTextArea();
        text.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        text.setWrapStyleWord(true);
        text.setLineWrap(true);
        text.setOpaque(false);
        text.setEditable(false);
        text.setFocusable(false);
        text.setForeground(Color.WHITE);
        text.setFont(UI.getFont("regular"));

        topPanel.add(healthLabel);
        topPanel.add(Box.createRigidArea(new Dimension(24, 0)));
        topPanel.add(hungerLabel);

        leftPanel.add(roomLabel);
        rightPanel.add(invLabel);

        bottomPanel.add(option1);
        bottomPanel.add(option2);

        getPanel().add(topPanel, BorderLayout.NORTH);
        getPanel().add(leftPanel, BorderLayout.WEST);
        getPanel().add(rightPanel, BorderLayout.EAST);
        getPanel().add(bottomPanel, BorderLayout.SOUTH);
        getPanel().add(text, BorderLayout.CENTER);

    }

    public static void setText(String str) {
        text.setText(str);
    }

    public static void addTextLine(String str) {
        text.setText(text.getText() + "\n" + str);
    }

    public static void setOptions(String opt) {
        
        option1.setVisible(true);
        option2.setVisible(false);

        option1.setText(opt);
    }
    
    public static void setOptions(String opt, String opt2) {
        
        option1.setVisible(true);
        option2.setVisible(true);

        option1.setText(opt);
        option2.setText(opt2);
    }
}
