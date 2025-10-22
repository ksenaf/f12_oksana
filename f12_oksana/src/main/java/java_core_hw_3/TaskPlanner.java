package java_core_hw_3;

import java.util.Scanner;

public class TaskPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] scedule = new String[7][2];
        scedule[0][0] = "Sunday";
        scedule[0][1] = "do home work";
        scedule[1][0] = "Monday";
        scedule[1][1] = "go to courses; watch a film";
        scedule[2][0] = "Tuesday";
        scedule[2][1] = "go to the gym";
        scedule[3][0] = "Wednesday";
        scedule[3][1] = "visit a museum";
        scedule[4][0] = "Thursday";
        scedule[4][1] = "work on project";
        scedule[5][0] = "Friday";
        scedule[5][1] = "read a book";
        scedule[6][0] = "Saturday";
        scedule[6][1] = "relax";

        while (true) {
            System.out.print("Please, input the day of the week: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            switch (input) {
                case "sunday":
                    System.out.println("Your tasks for Sunday: " + scedule[0][1] + ".");
                    break;
                case "monday":
                    System.out.println("Your tasks for Monday: " + scedule[1][1] + ".");
                    break;
                case "tuesday":
                    System.out.println("Your tasks for Tuesday: " + scedule[2][1] + ".");
                    break;
                case "wednesday":
                    System.out.println("Your tasks for Wednesday: " + scedule[3][1] + ".");
                    break;
                case "thursday":
                    System.out.println("Your tasks for Thursday: " + scedule[4][1] + ".");
                    break;
                case "friday":
                    System.out.println("Your tasks for Friday: " + scedule[5][1] + ".");
                    break;
                case "saturday":
                    System.out.println("Your tasks for Saturday: " + scedule[6][1] + ".");
                    break;
                default:
                    System.out.println("Sorry, I don't understand you, please try again.");
                    break;
            }
        }

        scanner.close();
    }

}
