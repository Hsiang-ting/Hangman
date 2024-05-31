package Questions;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import static Questions.Constants.*;

public class QuestionPanel extends JPanel{
    private static final int PREF_WIDTH = 50;
    private static final int PREF_HEIGHT = 50;
    private final String question;
    public QuestionPanel() {
        // display all labels in one row
        super(new FlowLayout());

        int randIndex = (int)(Math.random()*Q_NUM);
        question = QUESTIONS[randIndex];
        System.out.println("Answer: "+question);

        // set up word labels of question in panel
        for(int i=0; i < question.length(); ++i) {
            String charAti = String.valueOf(question.charAt(i));
            JLabel word = new JLabel();
            if(charAti != " ") {
                word.setText("_");
            }
            word.setPreferredSize(
                new Dimension(PREF_WIDTH, PREF_HEIGHT));
            add(word);
        }
    }
}
