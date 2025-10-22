package java_core_hw_1;

import java.util.Random;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        int randomNumber = random.nextInt(101); //Random number from 0 to 100

        //System.out.println(RandomNumber);

        System.out.println("Please enter your name: ");
        String playerName = scanner.nextLine(); //The player enters a name

        System.out.println("Let the game begin!");

        // Infinite loop
        while (true) {
            System.out.print("Enter a number from 0 and 100: ");

            // Checking if an integer is entered
            if (!scanner.hasNextInt()) {
                System.out.println("This is not a whole number! Try again.");
                scanner.next();
                continue;
            }

            int playerNumber = scanner.nextInt(); //The player enters a number

            if (playerNumber < randomNumber) {
                System.out.println("Your number is too small. Please, try again.");
            } else if (playerNumber > randomNumber) {
                System.out.println("Your number is too big. Please, try again.");
            } else {
                System.out.println("Congratulations, " + playerName + "!");
                break; // Number guessed - exit the loop
            }
        }
        scanner.close();
    }
}
