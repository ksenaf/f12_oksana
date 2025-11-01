package java_core_hw_3;

import java.util.Scanner;

public class TaskPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] schedule = createSchedule();

        while (true) {
            System.out.print("Please, input the day of the week: ");
            String dayOfWeek = scanner.nextLine().trim().toLowerCase();

            if (dayOfWeek .equals("exit")) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            switch (dayOfWeek) {
                case "sunday":
                case "monday":
                case "tuesday":
                case "wednesday":
                case "thursday":
                case "friday":
                case "saturday":

                    for (int i = 0; i < schedule.length; i++) {
                        if (schedule[i][0].toLowerCase().equals(dayOfWeek)) {
                            System.out.println("Your tasks for " + schedule[i][0] + ": " + schedule[i][1] + ".");
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Sorry, I don't understand you, please try again.");
            }
        }

        scanner.close();
    }

    private static String[][] createSchedule() {
        String[][] schedule = new String[7][2];
        schedule[0][0] = "Sunday";
        schedule[0][1] = "do home work";
        schedule[1][0] = "Monday";
        schedule[1][1] = "go to courses; watch a film";
        schedule[2][0] = "Tuesday";
        schedule[2][1] = "go to the gym";
        schedule[3][0] = "Wednesday";
        schedule[3][1] = "visit a museum";
        schedule[4][0] = "Thursday";
        schedule[4][1] = "work on project";
        schedule[5][0] = "Friday";
        schedule[5][1] = "read a book";
        schedule[6][0] = "Saturday";
        schedule[6][1] = "relax";
        return schedule;
    }

}
