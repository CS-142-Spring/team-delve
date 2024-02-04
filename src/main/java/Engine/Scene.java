package Engine;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class Scene {

    private JPanel uiPanel;
    private BorderLayout uiLayout;

    public Scene() {

        // Initialize the scenes interface.
        uiLayout = new BorderLayout();

        uiPanel = new JPanel();
        uiPanel.setLayout(uiLayout);
        uiPanel.setBackground(Color.BLACK);
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

    // public BorderLayout getLayout() {
    //     return uiLayout;
    // }
    
}
