import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.*;

import javax.swing.JButton;

import Background.*;
import Constants.Constants.Status;
import Questions.QuestionPanel;
import WordPanel.WordPanel;

public class Hangman{
    static int wrong;
    public static void main(String[] argc) {
        Background background = new Background("Hangman");
        QuestionPanel questionPnl = new QuestionPanel();
        WordPanel wordPanel = new WordPanel();
        wrong=0;

        background.add(questionPnl, BorderLayout.NORTH);
        background.add(wordPanel, BorderLayout.SOUTH);
        
        for(Component comp: wordPanel.getComponents()) {
            comp.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(comp instanceof JButton) {
                        JButton btn = (JButton) comp;
                        btn.setVisible(false);
                        String word = btn.getText();
                        System.out.println(word);
                        Status status = questionPnl.checkAnswer(word);
                        if(status == Status.WRONG) {
                            wrong++;
                            System.out.println("Wrong:"+wrong);
                            if(wrong == questionPnl.getQLen()) {
                                status = Status.LOSE;
                                System.out.println("LOSE");
                            }
                        } else if(status == Status.WIN) {
                            System.out.println("Win");
                        }

                    }
                }
                public void mouseEntered(MouseEvent e) {;}
                public void mouseExited(MouseEvent e) {;}
                public void mousePressed(MouseEvent e) {;}
                public void mouseReleased(MouseEvent e) {;}
            });
            
        }
        background.setVisible(true);
    }
}