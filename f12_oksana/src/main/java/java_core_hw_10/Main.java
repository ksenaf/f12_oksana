package java_core_hw_10;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static FamilyService familyService;
    private static FamilyDaoImpl familyDao;

    public static void main(String[] args) {
        familyDao = new FamilyDaoImpl();
        familyService = new FamilyService(familyDao);

        while (true) {
            showMenu();
            String choice = scanner.nextLine();

            try {
                if ("exit".equalsIgnoreCase(choice)) break;

                switch (choice) {
                    case "1":
                        fillTestData();
                        break;
                    case "2":
                        displayAllFamilies();
                        break;
                    case "3":
                        familiesBiggerThan();
                        break;
                    case "4":
                        familiesLessThan();
                        break;
                    case "5":
                        countFamiliesWithMemberNumber();
                        break;
                    case "6":
                        createNewFamily();
                        break;
                    case "7":
                        deleteFamily();
                        break;
                    case "8":
                        editFamily();
                        break;
                    case "9":
                        deleteChildrenOlderThan();
                        break;
                    default:
                        System.out.println("Unknown command!");
                        break;
                }
            } catch (FamilyOverflowException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input! Try again.");
            }
        }
        System.out.println("Program exited.");
    }

    private static void showMenu() {
        System.out.println("\n=== Family Management Menu ===");
        System.out.println("1. Fill test data with pets");
        System.out.println("2. Display all families");
        System.out.println("3. Display families bigger than a number");
        System.out.println("4. Display families less than a number");
        System.out.println("5. Count families with exact member number");
        System.out.println("6. Create a new family");
        System.out.println("7. Delete a family by index");
        System.out.println("8. Edit a family");
        System.out.println("9. Delete all children older than age");
        System.out.println("Type 'exit' to quit");
        System.out.print("Enter your choice: ");
    }

    private static void fillTestData() {
        familyDao.fillTestDataWithPets();
        System.out.println("Test families with pets added successfully!");
    }

    private static void displayAllFamilies() {
        List<Family> families = familyService.getAllFamilies();
        if (families.isEmpty()) {
            System.out.println("No families found.");
            return;
        }
        for (int i = 0; i < families.size(); i++) {
            System.out.println((i + 1) + ". " + families.get(i).prettyFormat());
        }
    }

    private static void familiesBiggerThan() {
        System.out.print("Enter number: ");
        int number = Integer.parseInt(scanner.nextLine());
        List<Family> list = familyService.getFamiliesBiggerThan(number);
        for (Family f : list) {
            System.out.println(f.prettyFormat());
        }
    }

    private static void familiesLessThan() {
        System.out.print("Enter number: ");
        int number = Integer.parseInt(scanner.nextLine());
        List<Family> list = familyService.getFamiliesLessThan(number);
        for (Family f : list) {
            System.out.println(f.prettyFormat());
        }
    }

    private static void countFamiliesWithMemberNumber() {
        System.out.print("Enter number: ");
        int number = Integer.parseInt(scanner.nextLine());
        long count = familyService.countFamiliesWithMemberNumber(number);
        System.out.println("Number of families: " + count);
    }

    private static void createNewFamily() {
        System.out.println("Enter mother's details:");
        System.out.print("First name: ");
        String mName = scanner.nextLine();
        System.out.print("Last name: ");
        String mSurname = scanner.nextLine();
        System.out.print("Birth date (dd/MM/yyyy): ");
        String mBirth = scanner.nextLine();
        System.out.print("IQ: ");
        int mIq = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter father's details:");
        System.out.print("First name: ");
        String fName = scanner.nextLine();
        System.out.print("Last name: ");
        String fSurname = scanner.nextLine();
        System.out.print("Birth date (dd/MM/yyyy): ");
        String fBirth = scanner.nextLine();
        System.out.print("IQ: ");
        int fIq = Integer.parseInt(scanner.nextLine());

        Human mother = new Human(mName, mSurname, mBirth, mIq);
        Human father = new Human(fName, fSurname, fBirth, fIq);

        Family family = familyService.createNewFamily(mother, father);
        System.out.println("New family created:\n" + family.prettyFormat());
    }

    private static void deleteFamily() {
        System.out.print("Enter family index to delete: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (familyService.deleteFamilyByIndex(index)) {
            System.out.println("Family deleted successfully.");
        } else {
            System.out.println("Family not found.");
        }
    }

    private static void editFamily() {
        System.out.print("Enter family index to edit: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        Family family = familyService.getFamilyById(index);
        if (family == null) {
            System.out.println("Family not found.");
            return;
        }

        while (true) {
            System.out.println("\n1. Born child\n2. Adopt child\n3. Return to main menu");
            String choice = scanner.nextLine();
            if ("3".equals(choice)) break;

            switch (choice) {
                case "1":
                    System.out.print("Enter boy's name: ");
                    String maleName = scanner.nextLine();
                    System.out.print("Enter girl's name: ");
                    String femaleName = scanner.nextLine();
                    familyService.bornChild(family, maleName, femaleName, "01/01/2025");
                    System.out.println("Child born successfully.");
                    break;
                case "2":
                    System.out.print("Enter child's first name: ");
                    String cName = scanner.nextLine();
                    System.out.print("Enter child's last name: ");
                    String cSurname = scanner.nextLine();
                    System.out.print("Enter birth date (dd/MM/yyyy): ");
                    String cBirth = scanner.nextLine();
                    System.out.print("Enter IQ: ");
                    int cIq = Integer.parseInt(scanner.nextLine());
                    Human child = new Human(cName, cSurname, cBirth, cIq);
                    familyService.adoptChild(family, child);
                    System.out.println("Child adopted successfully.");
                    break;
                default:
                    System.out.println("Unknown command!");
                    break;
            }
        }
    }

    private static void deleteChildrenOlderThan() {
        System.out.print("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());
        familyService.deleteAllChildrenOlderThen(age);
        System.out.println("All children older than " + age + " removed.");
    }
}
