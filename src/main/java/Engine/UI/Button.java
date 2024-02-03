package Engine.UI;

import java.awt.Color;
import javax.swing.JButton;

public class Button extends JButton {

    public Button(String text) {

        super(text);

        setForeground(Color.WHITE);
        setBackground(Color.BLACK);
        setFocusPainted(false);
        setFont(UI.getFont("regular"));
    }
    
}
