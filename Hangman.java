import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.*;

import javax.swing.JButton;

import Background.*;
import Constants.Constants.Painting;
import Constants.Constants.Status;
import Questions.QuestionPanel;
import WordPanel.WordPanel;
import Canva.Canva;

public class Hangman{
    static int wrong;
    public static void main(String[] argc) {
        Background background = new Background("Hangman");
        QuestionPanel questionPnl = new QuestionPanel();
        WordPanel wordPanel = new WordPanel();
        Canva canva = new Canva();
        wrong=0;

        background.add(questionPnl, BorderLayout.NORTH);
        background.add(canva, BorderLayout.CENTER);
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
                            Painting painting = null;
                            switch (wrong) {
                                case 1: painting = Painting.HEAD; break;
                                case 2: painting = Painting.BODY; break;
                                case 3: painting = Painting.ARMS; break;
                                case 4: 
                                    painting = Painting.LEGS;
                                    status = Status.LOSE;
                                    System.out.println("LOSE");
                                    break;
                                default:
                                    break;
                            }
                            canva.paintComponent(
                                canva.getGraphics(), painting);
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