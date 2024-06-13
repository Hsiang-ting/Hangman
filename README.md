# Hangman

Hangman is a classic word guessing game where players attempt to guess a hidden word letter by letter within a limited number of attempts.

## How to Play

1. Run the following commands in your terminal to compile and execute the game:
    ```bash
    javac Hangman.java
    java Hangman
    ```
2. Once the game starts, you will be presented with a row of dashes representing the hidden word.
3. Guess a letter by click it on the panel.
4. If the letter is in the word, it will be revealed in its correct position(s). If not, you'll lose one of your attempts.
5. Continue guessing letters until you either guess the word correctly or run out of attempts.
6. The game ends when you either successfully guess the word or exhaust all your attempts.

## Adding New Questions
To add new questions to the game, follow these steps:
1. Open `Constants\Constants.java` file in your preferred text editor.
2. Locate the `QUESTIONS` string array.
3. Add your new questions to the array. Each question should be a String element in the array.
4. Save the file
5. Recompile and run the game to play with the newly added questions.

## Features
- Randomly selected words for each game session.
- Visual representation of guessed letters and remaining attempts.
- User-friendly interface for smooth gameplay experience.

## Contribution
Feel free to contribute to the development of this game by submitting pull requests or reporting any issues you encounter.
