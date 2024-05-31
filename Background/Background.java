package Background;

import java.awt.*;
import javax.swing.*;

public class Background extends JFrame {
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 900;
    public Background() {
        this("", DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
    public Background(String title) {
        this(title, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
    public Background(int width, int height) {
        this("", width, height);
    }
    public Background(String title, int width, int height) {
        super(title);
        setLayout(new BorderLayout());
        setSize(width, height);
        // display background to center of a screen 
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}