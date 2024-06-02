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

        // set up ch labels of question in panel
        for(int i=0; i < question.length(); ++i) {
            String charAti = String.valueOf(question.charAt(i));
            JLabel ch = new JLabel();
            if(charAti != " ") {
                ch.setText("_");
            }
            ch.setPreferredSize(
                new Dimension(WORD_WIDTH, WORD_HEIGHT));
            add(ch);
        }
    }

    /* 
    * if the given char in question
    * then show the labels of ch set visible
    * else return false 
    */
    public boolean checkAnswer(String word) {
        boolean exist=false;
        char ch = word.charAt(0);
        for(int i=0; i < question.length(); ++i) {
            if(question.toUpperCase().charAt(i) == ch) {
                exist = true;
                JLabel label = (JLabel)getComponent(i);
                label.setText(word);
            }
        }
        return exist;
    }
}
