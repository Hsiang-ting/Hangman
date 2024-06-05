package Background;

import java.awt.*;
import javax.swing.*;

import static Constants.Constants.*;

public class Background extends JFrame {
    public Background() {
        this("", BACK_WIDTH, BACK_HEIGHT);
    }
    public Background(String title) {
        this(title, BACK_WIDTH, BACK_HEIGHT);
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
        // make background transparent
        // setUndecorated(true);
        // setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}