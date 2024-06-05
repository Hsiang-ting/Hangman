package WordPanel;

import static Constants.Constants.*;

import java.awt.GridLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class WordPanel extends JPanel{
    public WordPanel() {
        super(new GridLayout(2, 13));
        
        for(int i=0; i < CHAR_NUM; ++i) {
            JButton word = new JButton(String.valueOf(Character.toChars(i+'A')));
            word.setPreferredSize(
                new Dimension(WORD_WIDTH, WORD_HEIGHT));
            word.setHorizontalAlignment(JButton.CENTER);
            word.setVerticalAlignment(JButton.CENTER);
            // remove background of buttons
            word.setBorder(null);
            word.setContentAreaFilled(false);
            add(word);
        }
    }
}
