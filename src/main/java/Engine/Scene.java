package Engine;

import java.awt.Color;

import Engine.UI.Panel;

public class Scene {

    private Panel uiPanel;

    public Scene() {

        // Initialize the scenes interface.
        uiPanel = new Panel();
    }

    public void update() {

    }

    public void draw() {

    }

    public void setColors(Color background) {
        uiPanel.setBackground(background);
    }

    public Panel getPanel() {
        return uiPanel;
    }

    // public BorderLayout getLayout() {
    //     return uiLayout;
    // }
    
}
