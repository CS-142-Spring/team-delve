package Engine.UI;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Button extends JButton {

    public Button(String text) {

        super(text);

        setForeground(Color.WHITE);
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true));
        setFont(UI.getFont("regular"));

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // setBorder(null);
                setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
            }
        });
    }
    
}
