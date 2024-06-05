package Canva;

import static Constants.Constants.*;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Constants.Constants.Painting;

public class Canva extends JPanel {
    public Canva() {
        super();
    }
    public void paintComponent(Graphics g, Painting painting) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(5));
        if(painting == Painting.HEAD) {
            int radius = this.getHeight()/4;
            int x = (this.getWidth()-radius)/2;
            int y = this.getHeight()/4;
            g2.drawOval(x, y, radius, radius);
        } else {
            int x = this.getWidth()/2;
            int arm_span = this.getWidth()/8;
            if(painting == Painting.BODY) {
                int y1 = this.getHeight()/2;
                int y2 = this.getHeight()*3/4;
                g2.drawLine(x, y1, x, y2);
            } else if(painting == Painting.ARMS) {
                int y1 = this.getHeight()/2;
                int y2 = this.getHeight()*5/8;
                g2.drawLine(x, y1, x+arm_span, y2);
                g2.drawLine(x, y1, x-arm_span, y2);
            } else if(painting == Painting.LEGS) {
                int y1 = this.getHeight()*3/4;
                int y2 = this.getHeight()*7/8;
                g2.drawLine(x, y1, x+arm_span, y2);
                g2.drawLine(x, y1, x-arm_span, y2);
            } else if(painting == Painting.LOSE) {
                repaint();
                BufferedImage img = null;
                JLabel pic = null;
                try {
                    img = ImageIO.read(new File(IMG_DIR+HOLD_IMAGE));
                    pic = new JLabel(new ImageIcon(img));
                } catch (Exception e) {
                    e.getStackTrace();
                }
                add(pic);
            }
        }
    }
}
