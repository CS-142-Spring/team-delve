package Engine.UI;

import java.util.ArrayList;
import java.util.List;

import static com.raylib.Jaylib.*;

public class UIPanel extends UIElement {

    public UIPanel(int x, int y, int w, int h) {
        super();
        setPosition(x, y);
        setSize(w, h);
    }
}
