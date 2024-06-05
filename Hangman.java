import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Background.Background;
import Constants.Constants.Painting;
import Constants.Constants.Status;
import Questions.QuestionPanel;
import WordPanel.WordPanel;
import Canva.Canva;
import Popup.Popup;

public class Hangman{
    static Background background;
    static QuestionPanel questionPnl;
    static WordPanel wordPanel;
    static Canva canva;
    static int wrong;
    static Popup popup;
    public static void main(String[] argc) {
        background = new Background("Hangman");
        questionPnl = new QuestionPanel();
        wordPanel = new WordPanel();
        canva = new Canva();
        popup = new Popup(background);
        wrong=0;

        background.add(questionPnl, BorderLayout.NORTH);
        background.add(canva, BorderLayout.CENTER);
        background.add(wordPanel, BorderLayout.SOUTH);
        
        JPanel panel = new JPanel(new FlowLayout());
        JLabel label = new JLabel();
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        JButton restart = new JButton("Restart");
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Component comp: wordPanel.getComponents()) { 
                    comp.setVisible(true);
                }
                questionPnl.removeAll();
                questionPnl = new QuestionPanel();
                background.add(questionPnl, BorderLayout.NORTH);
                wrong = 0;
                canva.removeAll();
                canva.repaint();
                background.setVisible(true);
                popup.setVisible(false);
            }
        }); 
        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(restart);
        panel.add(exit);
        popup.add(label, BorderLayout.CENTER);
        popup.add(panel, BorderLayout.SOUTH);
        


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
                            // System.out.println("Wrong:"+wrong);
                            Painting painting = null;
                            switch (wrong) {
                                case 1: painting = Painting.HEAD; break;
                                case 2: painting = Painting.BODY; break;
                                case 3: painting = Painting.ARMS; break;
                                case 4: painting = Painting.LEGS; break;
                                case 5:
                                    painting = Painting.LOSE; 
                                    status = Status.LOSE; 
                                    break;
                            }
                            canva.paintComponent(
                                canva.getGraphics(), painting);
                        } if(status == Status.WIN || status == Status.LOSE) { 
                            String display = status==Status.WIN? "You Win!": "You Lose!";
                            System.out.println(display);
                            label.setText(display);
                            popup.setVisible(true);
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