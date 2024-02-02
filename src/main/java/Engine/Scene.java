package Engine;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Engine.UI.UI;

import java.awt.Color;
import java.awt.BorderLayout;

public class Scene {

    private JPanel uiPanel;
    private BorderLayout uiLayout;
    private JLabel uiLabel; // Just for testing purposes.

    public Scene() {

        // Initialize the scenes interface.
        uiLayout = new BorderLayout();
        uiPanel = new JPanel();
        uiPanel.setLayout(uiLayout);

        uiLabel = new JLabel();
        uiLabel.setForeground(Color.WHITE);
        uiLabel.setFont(UI.getFont());
        uiPanel.add(uiLabel, BorderLayout.NORTH); // Just for testing purposes.

        uiPanel.setBackground(Color.BLACK);
    }

    public void update() {

    }

    public void draw() {

    }

    public void setLabel(String text) {
        uiLabel.setText(text);
    }

    public void setColors(Color background) {
        uiPanel.setBackground(background);
    }

    public JPanel getPanel() {
        return uiPanel;
    }
    
}
