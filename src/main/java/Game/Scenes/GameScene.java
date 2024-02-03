package Game.Scenes;

import Engine.Scene;
import Engine.UI.Label;

public class GameScene extends Scene {

    private Label placeholder;

    public GameScene() {

        super();

        placeholder = new Label("Game Scene");
        placeholder.setFontSize("regular");

        getPanel().add(placeholder, getLayout().NORTH);

    }
    
}
