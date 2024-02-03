package Engine.UI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class UI {

    private JFrame frame;
    private CardLayout layout;
    private JPanel panel;

    private static HashMap<String, Font> fonts = new HashMap<>();

    public UI(int width, int height) {

        frame = new JFrame("Delve");
        layout = new CardLayout();

        // Font
        try {

            File fontFile = new File("resources/font/Alegreya-Regular.ttf");
            Font loadedFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);

            // Create different font sizes.
            fonts.put("small", loadedFont.deriveFont(Font.PLAIN, 24f));
            fonts.put("regular", loadedFont.deriveFont(Font.PLAIN, 48f));
            fonts.put("medium", loadedFont.deriveFont(Font.PLAIN, 72f));
            fonts.put("big", loadedFont.deriveFont(Font.PLAIN, 96f));
            fonts.put("large", loadedFont.deriveFont(Font.PLAIN, 120f));

        } catch (IOException | FontFormatException e) {

            e.printStackTrace();
        }

        panel = new JPanel();
        panel.setLayout(layout);
        panel.setBackground(Color.RED);

        layout.show(panel, "masterPanel");

        frame.add(panel);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Add a panel to the master panel.
    public void addPanel(JPanel panel, String name) {
        this.panel.add(panel, name);
    }

    // Set what panel to currently display.
    public void setCurrentPanel(String name) {
        layout.show(panel, name);
    }

    public static Font getFont(String size) {
        return fonts.get(size);
    }
    
}
