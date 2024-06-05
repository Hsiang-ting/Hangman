package Popup;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import Background.Background;
public class Popup extends JDialog {
    public Popup(Background background) {
        super(background, true);
        setSize(300, 200);
        setLayout(new BorderLayout());
        setLocationRelativeTo(background);
    }
    
}
