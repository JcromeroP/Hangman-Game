import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String secretWord = "world";
        int maximumAttempts = 10;
        int attempts = 0;
        boolean guessedWord = false;

        char[] guessedLetters = new char[secretWord.length()];

        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
            System.out.println(guessedLetters[i]);
        }

        while (!guessedWord && attempts < maximumAttempts) {

            System.out.println("Word to guess: " + String.valueOf(guessedLetters) + " ("
                    + secretWord.length() + " letters)");

            System.out.println("Enter a letter, please: ");

            char letter = Character.toLowerCase(scanner.next().charAt(0));

            boolean correctLetter = false;

            for (int i = 0; i < secretWord.length(); i++) {
       
                if (secretWord.charAt(i) == letter) {
                    guessedLetters[i] = letter;
                    correctLetter = true;
                }
            }

            if (!correctLetter) {
                attempts++;
                System.out.println("Incorrect! you have " + (maximumAttempts - attempts) + " attemps left.");
            }
            if (String.valueOf(guessedLetters).equals(secretWord)) {
                guessedWord = true;
                System.out.println("Congratulations! You guessed the secret word: " + secretWord);
            }

        }
        if (!guessedWord) {
            System.out.println("You've run out of attempts! GAME OVER");
        }
        scanner.close();

    }
}
