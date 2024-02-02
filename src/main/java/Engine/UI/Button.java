package Engine.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Button {

    private JButton button;

    public Button(String text) {
        button = new JButton(text);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Execute when button is pressed
                System.out.println("You clicked the button");
            }
        });
    }
    
}
