import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.*;

import javax.swing.JLabel;

import Background.*;
import Questions.QuestionPanel;
import WordPanel.WordPanel;

public class Hangman{
    static Background background;
    public static void main(String[] argc) {
        Background background = new Background("Hangman");
        QuestionPanel questionPnl = new QuestionPanel();
        WordPanel wordPanel = new WordPanel();
        background.add(questionPnl, BorderLayout.NORTH);
        background.add(wordPanel, BorderLayout.SOUTH);
        
        for(Component comp: wordPanel.getComponents()) {
            comp.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JLabel label = (JLabel)e.getComponent();
                    String ch = label.getText();
                    System.out.println(ch);
                    if(!questionPnl.checkAnswer(ch)) {
                        System.out.println();
                    }
                }
                public void mouseEntered(MouseEvent e) {;}
                public void mouseExited(MouseEvent e) {;}
                public void mousePressed(MouseEvent e) {;}
                public void mouseReleased(MouseEvent e) {;}
            });
            
        }
    }
}