package Engine;

import java.awt.Color;

import javax.swing.JPanel;

public class Scene {

    private JPanel uiPanel;

    public Scene() {

        uiPanel = new JPanel();

    }

    public void update() {

    }

    public void draw() {

    }

    public void setColors(Color background) {
        uiPanel.setBackground(background);
    }

    public JPanel getPanel() {
        return uiPanel;
    }
    
}
