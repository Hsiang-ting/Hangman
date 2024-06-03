import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.*;

import javax.swing.JButton;

import Background.*;
import Questions.QuestionPanel;
import WordPanel.WordPanel;

public class Hangman{
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
                    if(comp instanceof JButton) {
                        JButton btn = (JButton) comp;
                        btn.setVisible(false);
                        String word = btn.getText();
                        System.out.println(word);
                        if(questionPnl.checkAnswer(word)) {
                            System.out.println("Wrong");
                        }
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