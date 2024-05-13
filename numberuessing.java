import java.util.Scanner;

public class numberuessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game!");

        int rounds = 1;
        int totalAttempts = 0;
        int totalRoundsWon = 0;

        while (rounds > 0) {
            int randomNumber = generateRandomNumber(1, 100);
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + (totalRoundsWon + 1) + ":");
            System.out.println("I have selected a number between 1 and 100. Guess it!");

            while (!guessedCorrectly && attempts < 5) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalRoundsWon++;
                    guessedCorrectly = true;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + randomNumber);
            }

            totalAttempts += attempts;
            rounds--;

            if (rounds > 0) {
                System.out.print("Do you want to play another round? (yes/no): ");
                String playAgain = scanner.next();
                if (!playAgain.equalsIgnoreCase("yes")) {
                    break;
                }
            }
        }

        System.out.println("\nGame over!");
        System.out.println("Total rounds played: " + totalRoundsWon);
        System.out.println("Total attempts: " + totalAttempts);
    }

    public static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
