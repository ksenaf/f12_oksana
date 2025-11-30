package java_core_hw_9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    private static String date(int yearsAgo) {
        return LocalDate.now()
                .minusYears(yearsAgo)
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static void main(String[] args) {

        FamilyDao dao = new CollectionFamilyDao();
        FamilyService service = new FamilyService(dao);
        FamilyController controller = new FamilyController(service);

        // =============================================================
        //                       FAMILY №1
        // =============================================================
        Human mom1 = new Human("Anna", "Koval", "01/01/1990");
        Human dad1 = new Human("Oleh", "Koval", "02/02/1985");
        Family family1 = controller.createNewFamily(mom1, dad1);

        Set<String> dogHabits1 = new HashSet<>(Arrays.asList("eat", "drink", "sleep"));
        Dog dog1 = new Dog("Rock", 5, 45, dogHabits1);
        controller.addPet(0, dog1);

        // =============================================================
        //                        FAMILY №2
        // =============================================================
        Human mom2 = new Human("Iryna", "Petrenko", "11/03/1992");
        Human dad2 = new Human("Taras", "Petrenko", "04/04/1988");
        Family family2 = controller.createNewFamily(mom2, dad2);

        controller.bornChild(family2, "Andrii", "Sofia", "15/02/2010");
        Human adopted2 = new Human("Petro", "Petrenko", date(5));
        controller.adoptChild(family2, adopted2);

        Set<String> catHabits = new HashSet<>(Arrays.asList("sleep", "jump", "scratch"));
        DomesticCat cat = new DomesticCat("Myrka", 2, 25, catHabits);
        controller.addPet(1, cat);

        // =============================================================
        //                       FAMILY №3
        // =============================================================
        Human mom3 = new Human("Olha", "Herasymenko", "12/05/1990");
        Human dad3 = new Human("Roman", "Herasymenko", "03/03/1987");
        Family family3 = controller.createNewFamily(mom3, dad3);

        controller.bornChild(family3, "Maksym", "Oksana", "15/02/2020");
        controller.bornChild(family3, "Illia", "Natalia", "15/02/2014");

        Human adopted3 = new Human("Lida", "Herasymenko", date(7));
        controller.adoptChild(family3, adopted3);

        Set<String> fishHabits = new HashSet<>(Arrays.asList("swim"));
        Fish fish = new Fish("Dory", 1, 10, fishHabits);

        Set<String> roboHabits = new HashSet<>(Arrays.asList("charge", "scan"));
        RoboCat robo = new RoboCat("XR-22", 0, 99, roboHabits);

        controller.addPet(2, fish);
        controller.addPet(2, robo);

        // =============================================================
        //                        FAMILY №4
        // =============================================================
        Human mom4 = new Human("Tetiana", "Shevchuk", "02/01/1993");
        Human dad4 = new Human("Ivan", "Shevchuk", "05/05/1989");
        Family family4 = controller.createNewFamily(mom4, dad4);

        controller.bornChild(family4, "Bohdan", "Mariya", "15/02/2018");

        Set<String> dogHabits4 = new HashSet<>(Arrays.asList("fetch", "guard"));
        Dog dog4 = new Dog("Buddy", 2, 60, dogHabits4);
        controller.addPet(3, dog4);

        // =============================================================
        //                        FAMILY №5
        // =============================================================
        Human mom5 = new Human("Yana", "Stasenko", "11/11/1991");
        Human dad5 = new Human("Denys", "Stasenko", "10/10/1987");
        Family family5 = controller.createNewFamily(mom5, dad5);

        controller.bornChild(family5, "Serhii", "Nadiya", "15/02/2013");
        controller.bornChild(family5, "Taras", "Liliya", "15/02/2012");
        controller.bornChild(family5, "Artem", "Veronika", "15/02/2017");

        Set<String> cat2Habits = new HashSet<>(Arrays.asList("sleep", "eat"));
        DomesticCat cat2 = new DomesticCat("Barsik", 3, 15, cat2Habits);
        controller.addPet(4, cat2);

        System.out.println("\n=== ALL FAMILIES LIST ===");
        List<Family> families = controller.getAllFamilies();

        families.forEach(System.out::println);

        System.out.println("\n=== We remove children over 10 years old ===");
        controller.deleteAllChildrenOlderThen(10);

        System.out.println("\n=== ALL FAMILIES AFTER UPDATE ===");
        controller.displayAllFamilies();

        int memberCount = 3;
        long familiesWithMembers = controller.countFamiliesWithMemberNumber(memberCount);
        System.out.println("\n=== Number of families with " + memberCount + " members ===");
        System.out.println(familiesWithMembers);

        System.out.println("\n=== Families with < 3 members ===");
        System.out.println(controller.getFamiliesLessThan(3));

        System.out.println("\n=== Families with > 3 members ===");
        System.out.println(controller.getFamiliesBiggerThan(3));

        System.out.println("\n=== We derive the family with index 3 ===");
        int index = 3;
        Family family = controller.getFamilyById(index);
        System.out.println(family);

        System.out.println("\n=== List of animals in the family with index 2 ===");
        Set<Pet> petsFamily = controller.getPets(2);
        if (petsFamily != null && !petsFamily.isEmpty()) {
            petsFamily.forEach(System.out::println);
        } else {
            System.out.println("This family has no animals");
        }

        System.out.println("\n=== Delete the family with index 2 ===");
        int indexToDelete = 2;
        boolean resultDelete = controller.deleteFamilyByIndex(indexToDelete);

        System.out.println("\n=== Number of families ===");
        System.out.println(controller.count());
    }
}
