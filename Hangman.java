import java.awt.BorderLayout;

import Background.*;
import Questions.QuestionPanel;

public class Hangman {
    static Background background;
    public static void main(String[] argc) {
        Background background = new Background("Hangman");
        QuestionPanel questionPnl = new QuestionPanel();
        background.add(questionPnl, BorderLayout.NORTH);
    }
}