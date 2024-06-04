package Questions;

import static Constants.Constants.*;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class QuestionPanel extends JPanel{
    
    private final String question;
    private int remainWords;

    public QuestionPanel() {
        // display all labels in one row
        super(new FlowLayout());

        int randIndex = (int)(Math.random()*Q_NUM);
        question = QUESTIONS[randIndex];
        System.out.println("Answer: "+question);

        remainWords = getQLen();
        // set up ch labels of question in panel
        for(int i=0; i < getQLen(); ++i) {
            String charAti = String.valueOf(question.charAt(i));
            JLabel ch = new JLabel();
            if(charAti != " ") {
                ch.setText("_");
            }
            ch.setPreferredSize(
                new Dimension(WORD_WIDTH, WORD_HEIGHT));
            ch.setHorizontalAlignment(JLabel.CENTER);
            ch.setVerticalAlignment(JLabel.CENTER);
            add(ch);
        }
    }

    /* 
    * if the given char in question
    * then show the labels of ch set visible
    * else return false 
    */
    public Status checkAnswer(String word) {
        Status status=Status.WRONG;
        char ch = word.charAt(0);
        for(int i=0; i < question.length(); ++i) {
            if(question.toUpperCase().charAt(i) == ch) {
                status = Status.CORRECT;
                remainWords--;
                JLabel label = (JLabel)getComponent(i);
                label.setText(word);
            }
        }
        if(remainWords == 0) return Status.WIN;
        return status;
    }

    public int getQLen() {
        return question.length();
    }
}
