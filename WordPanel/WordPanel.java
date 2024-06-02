package WordPanel;

import static Constants.Constants.*;

import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WordPanel extends JPanel{
    public WordPanel() {
        super(new GridLayout(2, 13));
        for(int i=0; i < CHAR_NUM; ++i) {
            JLabel word = new JLabel(String.valueOf(Character.toChars(i+'A')));
            word.setPreferredSize(
                new Dimension(WORD_WIDTH, WORD_HEIGHT));
            word.setHorizontalAlignment(JLabel.CENTER);
            word.setVerticalAlignment(JLabel.CENTER);
            add(word);
        }
    }
}
