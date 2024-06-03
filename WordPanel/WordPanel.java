package WordPanel;

import static Constants.Constants.*;

import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
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
            word.setMargin(new Insets(5, 5, 5, 5));
            word.setBorder(BorderFactory.createLineBorder(
                Color.BLACK));
            add(word);
        }
    }
}
