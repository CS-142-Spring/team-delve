package Game.Scenes;

import java.awt.BorderLayout;

import Engine.Scene;
import Engine.UI.Label;

public class OptionsMenu extends Scene {

    private Label placeholder;

    public OptionsMenu() {

        super();

        placeholder = new Label("Options Menu");
        placeholder.setFontSize("regular");

        getPanel().add(placeholder, BorderLayout.NORTH);

    }
    
}
