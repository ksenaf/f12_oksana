package java_core_hw_5;

public class Main {
    public static void main(String[] args) {

        Pet dog = new Pet(Species.DOG, "Rock", 5, 45, new String[]{"eat", "drink", "sleep"});
        Pet cat = new Pet(Species.CAT, "Max", 3, 60, new String[]{"play", "sleep", "hunts"});

        Human mother = new Human("Jane", "Karleone", 1975);
        Human father = new Human("Vito", "Karleone", 1970);

        String[][] scheduleJessica = Family.createJessicaSchedule();
        String[][] scheduleMichael = Family.createMichaelSchedule();

        Human child1 = new Human("Michael", "Karleone", 2000, 90, scheduleMichael, dog, null);
        Human child2 = new Human("Jessica", "Karleone", 2003, 80, scheduleJessica, cat, null);

        Family family = new Family(mother, father);

        family.addPet(dog);
        family.addPet(cat);

        family.addChild(child1);
        family.addChild(child2);

        System.out.println("Family before deletion:");
        System.out.println(family);
        System.out.println("Family members count: " + family.countFamily());

        System.out.println("\nFamily greets and describes their pets:");
        for (Pet pet : family.getPets()) {
            System.out.println("\n--- Pet: " + pet.getNickname() + " ---");

            mother.greetPet();
            mother.describePet();

            father.greetPet();
            father.describePet();

            child1.greetPet();
            child1.describePet();

            child2.greetPet();
            child2.describePet();
        }

        System.out.println("\n--- Children schedules ---");
        for (Human child : family.getChildren()) {
            System.out.println("\n" + child.getName() + "’s schedule:");
            for (String[] day : child.getSchedule()) {
                System.out.println(day[0] + " — " + day[1]);
            }
            System.out.println();
        }

        boolean deleted = family.deleteChild(0);
        if (deleted) {
            System.out.println("\nChild deleted successfully!");
        } else {
            System.out.println("\nFailed to delete child!");
        }

        System.out.println("\nFamily after deletion:");
        System.out.println(family);
        System.out.println("Family members count: " + family.countFamily());

        System.out.println("\nPets interaction:");
        dog.respond();
        cat.respond();
        dog.foul();
        cat.eat();
    }
}
