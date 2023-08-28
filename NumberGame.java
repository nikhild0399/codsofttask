import java.util.Random;
import java.util.Scanner;

class NumberGame {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int minRange = 1;
    int maxRange = 100;
    int maxAttempts = 10;
    int rounds = 0;
    int score = 0;

    System.out.println("Welcome to the Number nGame!");

    do {
      int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
      int attempts = 0;
      boolean hasGuessedCorrectly = false;

      System.out.println("\nRound " + (rounds + 1));
      System.out.println("I've generated a number between " + minRange + " and " + maxRange + ". Try to guess it!");

      while (!hasGuessedCorrectly && attempts < maxAttempts) {
        System.out.print("Enter your guess: ");
        int userGuess = scanner.nextInt();
        attempts++;

        if (userGuess < targetNumber) {
          System.out.println("Too low! Try again.");
        } else if (userGuess > targetNumber) {
          System.out.println("Too high! Try again.");
        } else {
          hasGuessedCorrectly = true;
          System.out
              .println("Congratulations! You've guessed the number " + targetNumber + " in " + attempts + " attempts.");
          score += maxAttempts - attempts + 1;
        }
      }

      if (!hasGuessedCorrectly) {
        System.out.println("Sorry, you've used all your attempts. The correct number was: " + targetNumber);
      }

      rounds++;

      System.out.print("\nDo you want to play another round? (yes/no): ");
      String playAgain = scanner.next();

      if (!playAgain.equalsIgnoreCase("yes")) {
        System.out.println("Thanks for playing! Your total score is: " + score);
        break;
      }
    } while (true);

    scanner.close();
  }
}