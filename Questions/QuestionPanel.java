package Questions;

import static Constants.Constants.*;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class QuestionPanel extends JPanel{
    
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
                new Dimension(WORD_WIDTH, WORD_HEIGHT));
            add(word);
        }
    }
}
