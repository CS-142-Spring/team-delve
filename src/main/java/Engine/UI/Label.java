
package Engine.UI;

import java.awt.Color;

import javax.swing.JLabel;

public class Label extends JLabel {

    public Label(String text) {

        super(text);

        setForeground(Color.WHITE);
    }

    public void setColor(Color color) {
        setForeground(color);
    }

    public void setFontSize(String size) {
        setFont(UI.getFont(size));
    }
    
}
