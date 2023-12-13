package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        int totalRounds = 3;
        int score = 0;

        for (int round = 1; round <= totalRounds; round++) {
            System.out.println("Round " + round);
            if (play(random, input, score)) {
                score++;
            }
        }

        System.out.println("Game over. Thank you for playing!");
        System.out.println("Your score: " + score + " out of " + totalRounds);
    }

    private static boolean play(Random random, Scanner input, int score) {
        int guesses = 5;
        int randomNumber = random.nextInt(101);
        System.out.println(randomNumber);

        while (guesses > 0) {
            try {
                System.out.println("Your score: " + score);
                System.out.println("Enter your guess (or enter 'quit' to exit the game):");
                String userInput = input.next();

                if (userInput.equalsIgnoreCase("quit")) {
                    System.out.println("Thanks for playing! See you next time.");
                    return false;
                }

                int answer = Integer.parseInt(userInput);

                if (answer == randomNumber) {
                    System.out.println("Congratulations you have guessed the correct number.");
                    return true;
                } else if (answer < randomNumber) {
                    System.out.println("The number you have guessed is lower than the correct number.");
                } else {
                    System.out.println("The number you have guessed is higher than the correct number.");
                }

                guesses--;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer or 'quit' to exit the game.");
            }
        }

        System.out.println("Sorry, you've run out of guesses. The correct number was: " + randomNumber);
        return false;
    }
}
