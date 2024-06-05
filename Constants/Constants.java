package Constants;

public final class Constants {
    public static final int BACK_WIDTH = 300;
    public static final int BACK_HEIGHT = 450;
    public static final int WORD_WIDTH = 50;
    public static final int WORD_HEIGHT = 50;
    public static final String[] QUESTIONS = {
        "Panda", "Pig", "Hangman", "Cat", "Word", "Question", "Bird"};
    public static final int Q_NUM = QUESTIONS.length;
    public static final int CHAR_NUM = 26;

    public static enum Status {
        WIN, WRONG, CORRECT, LOSE
    };
    public static enum Painting {
        HEAD, BODY, ARMS, LEGS, LOSE
    };

    public static final String IMG_DIR = "Images/";
    public static final String NORMAL_IMAGE="normal.png";
    public static final String EAT_IMAGE="eat.png";
    public static final String SLEEP_IMAGE="sleep.png";
    public static final String HOLD_IMAGE="hold.png";
}
