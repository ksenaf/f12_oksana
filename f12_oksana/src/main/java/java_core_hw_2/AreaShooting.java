package java_core_hw_2;

import java.util.*;

public class AreaShooting {
    public static void main(String[] args) {
        // Create a 5x5 board
        char[][] board = new char[5][5];

        // Fill the board with '-' symbol
        for (char[] row : board) Arrays.fill(row, '-');

        // Randomly select target coordinates (from 0 to 4)
        Random rand = new Random();
        int targetRow = rand.nextInt(5);
        int targetCol = rand.nextInt(5);

        Scanner sc = new Scanner(System.in);
        System.out.println("All Set. Get ready to rumble!");

        // Main game loop
        while (true) {
            printBoard(board); // Display the current state of the board

            // Read coordinates from the player (1–5), subtract 1 for 0-based indexing
            int row = getInput(sc, "Row (1-5): ") - 1;
            int col = getInput(sc, "Column (1-5): ") - 1;

            // If already shot at this cell — ask for another input
            if (board[row][col] == '*') {
                System.out.println("Already shot here. Try a different spot.");
                continue;
            }

            // If hit the target
            if (row == targetRow && col == targetCol) {
                board[row][col] = 'x'; // Mark the hit
                printBoard(board);     // Show the final board
                System.out.println("You have won!"); // Display win message
                break; // End the game
            } else {
                board[row][col] = '*'; // Mark a miss with '*'
            }
        }

        sc.close(); // Close the scanner
    }

    // Method for reading coordinates from the user with validation
    static int getInput(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            try {
                int n = Integer.parseInt(sc.nextLine()); // Try to convert input to number
                if (n >= 1 && n <= 5) return n; // Check if within 1–5
            } catch (Exception ignored) {}
            System.out.println("Please enter a number from 1 to 5."); // Prompt again on error
        }
    }

    // Method to print the game board
    static void printBoard(char[][] board) {
        // Print header with column numbers
        System.out.print("  |");
        for (int i = 1; i <= 5; i++) System.out.print(" " + i + " |");
        System.out.println();

        // Print board rows with row numbers
        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + " |");
            for (int j = 0; j < 5; j++) {
                System.out.print(" " + board[i][j] + " |");
            }
            System.out.println();
        }
    }
}
