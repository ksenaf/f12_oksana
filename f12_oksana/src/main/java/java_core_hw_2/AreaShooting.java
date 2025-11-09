package java_core_hw_2;

import java.util.*;

public class AreaShooting {
    public static void main(String[] args) {

        char[][] board = new char[5][5];

        for (char[] row : board) Arrays.fill(row, '-');

        Random rand = new Random();
        int targetRow = rand.nextInt(5);
        int targetCol = rand.nextInt(5);

        Scanner scanner = new Scanner(System.in);
        System.out.println("All Set. Get ready to rumble!");

        while (true) {
            printBoard(board);

            int row = getInput(scanner, "Row (1-5): ") - 1;
            int col = getInput(scanner, "Column (1-5): ") - 1;

            if (board[row][col] == '*') {
                System.out.println("Already shot here. Try a different spot.");
                continue;
            }

            if (row == targetRow && col == targetCol) {
                board[row][col] = 'x';
                printBoard(board);
                System.out.println("You have won!");
                break;
            } else {
                board[row][col] = '*';
            }
        }

        scanner.close();
    }

    static int getInput(Scanner scanner, String promptMessage) {
        int minValue = 1;
        int maxValue = 5;
        while (true) {
            System.out.print(promptMessage);
            try {
                int userChoice = Integer.parseInt(scanner.nextLine());
                if (userChoice >= minValue && userChoice <= maxValue) return userChoice;
            } catch (NumberFormatException inputError) {
                System.out.println("This is not a number. Try again.");
            }
            System.out.println("Please enter a number from " + minValue + " to " + maxValue + ".");
        }
    }

    static void printBoard(char[][] board) {
        System.out.print("  |");
        for (int i = 1; i <= 5; i++) System.out.print(" " + i + " |");
        System.out.println();

        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + " |");
            for (int j = 0; j < 5; j++) {
                System.out.print(" " + board[i][j] + " |");
            }
            System.out.println();
        }
    }
}
