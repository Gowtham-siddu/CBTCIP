
package CBTCIP;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int userGuess, attempts = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("Try to guess the number between 1 and 100.");

        do {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == numberToGuess) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                break;
            } else if (userGuess < numberToGuess) {
                System.out.println("Try a higher number.");
            } else {
                System.out.println("Try a lower number.");
            }
        } while (true);

        scanner.close();
    }


}
