package Engine.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel extends JPanel {

    private Image backgroundImage;

    public Panel() {

        super();

        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        setOpaque(false);
    }

    public void setBackgroundImage(String path) {
        backgroundImage = new ImageIcon(path).getImage();
    }

    public void applyBorder() {
        // Create an outline.
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }

    // Overide so we can render an image for the background.
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (backgroundImage == null) return;

        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int imageWidth = backgroundImage.getWidth(this);
        int imageHeight = backgroundImage.getHeight(this);

        // Scale image to fit in window.
        double scale = Math.max(
            (double) panelWidth/imageWidth,
            (double) panelHeight/imageHeight
        );

        int finalWidth = (int)(imageWidth * scale);
        int finalHeight = (int)(imageHeight * scale);
        int x = (panelWidth - finalWidth) / 2;
        int y = (panelHeight - finalHeight) / 2;

        g.drawImage(backgroundImage, x, y, finalWidth, finalHeight, this);
    }
    
}
