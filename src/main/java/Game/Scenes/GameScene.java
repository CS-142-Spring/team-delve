package Game.Scenes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Engine.Scene;
import Engine.UI.Label;
import Engine.UI.UI;

public class GameScene extends Scene {

    private Label healthLabel;
    private Label hungerLabel;
    private Label roomLabel;
    private Label invLabel;

    private JTextArea text;

    private JPanel topPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel bottomPanel;
    private JPanel centerPanel;

    public GameScene() {

        super();

        Border border = BorderFactory.createLineBorder(Color.WHITE);

        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBorder(border);
        topPanel.setBackground(Color.BLACK);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.setBorder(border);
        bottomPanel.setBackground(Color.BLACK);

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
        text.setFont(UI.getFont("small"));

        topPanel.add(healthLabel);
        topPanel.add(Box.createRigidArea(new Dimension(24, 0)));
        topPanel.add(hungerLabel);

        leftPanel.add(roomLabel);
        rightPanel.add(invLabel);

		getPanel().add(topPanel, BorderLayout.NORTH);
        getPanel().add(leftPanel, BorderLayout.WEST);
        getPanel().add(rightPanel, BorderLayout.EAST);
        getPanel().add(bottomPanel, BorderLayout.SOUTH);
        getPanel().add(text, BorderLayout.CENTER);

    }
    
}
