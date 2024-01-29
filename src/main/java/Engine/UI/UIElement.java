package Engine.UI;

import com.raylib.Jaylib;

import static com.raylib.Jaylib.Vector2;
import static com.raylib.Jaylib.Color;
import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.DrawRectangleV;

public class UIElement {

    private Vector2 position;
    private Vector2 size;
    private Color bgColor;

    public UIElement() {
        position = new Vector2(0, 0);
        size = new Vector2(0 ,0);
        bgColor = new Color(256, 256, 256, 256);
    }

    public void draw() {
        DrawRectangleV(getPosition(), getSize(), RAYWHITE);
    };

    public void setPosition(float x, float y) {
        position.x(x);
        position.y(y);
    }

    public void setSize(int w, int h) {
        size.x(w);
        size.y(h);
    }

    public Jaylib.Vector2 getPosition() {
        return position;
    }

    public Jaylib.Vector2 getSize() {
        return size;
    }
}
