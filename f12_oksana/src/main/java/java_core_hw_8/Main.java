package java_core_hw_8;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Set<String> dogHabits = new HashSet<>(Arrays.asList("eat", "drink", "sleep"));
        Set<String> catHabits = new HashSet<>(Arrays.asList("play", "sleep", "hunts"));
        Set<String> fishHabits = new HashSet<>(Arrays.asList("swim", "eat"));
        Set<String> roboCatHabits = new HashSet<>(Arrays.asList("charge", "meow"));

        Dog dog = new Dog("Rock", 5, 45, dogHabits);
        DomesticCat cat = new DomesticCat("Max", 3, 60, catHabits);
        Fish fish = new Fish("Nemo", 1, 10, fishHabits);
        RoboCat roboCat = new RoboCat("Robo", 2, 80, roboCatHabits);

        Woman mother = new Woman("Jane", "Karleone", "03/02/1975");
        Man father = new Man("Vito", "Karleone", "20/10/1970");

        Map<String, String> scheduleJessica = Family.createJessicaSchedule();
        Map<String, String> scheduleMichael = Family.createMichaelSchedule();

        Human child1 = new Human("Michael", "Karleone", "25/08/2000", 90, scheduleMichael, null);
        Human child2 = new Human("Jessica", "Karleone", "15/03/2003", 80, scheduleJessica, null);

        Family family = new Family(mother, father);

        family.addPet(dog);
        family.addPet(cat);
        family.addPet(fish);
        family.addPet(roboCat);

        family.addChild(child1);
        family.addChild(child2);

        System.out.println("Family before deletion:");
        System.out.println(family);
        System.out.println("Family members count: " + family.countFamily());

        System.out.println("\nFamily greets and describes their pets:");
        for (Pet pet : family.getPets()) {
            System.out.println("\n--- Pet: " + pet.getNickname() + " ---");

            mother.greetPet(pet);
            mother.describePet(pet);

            father.greetPet(pet);
            father.describePet(pet);

            child1.greetPet(pet);
            child1.describePet(pet);

            child2.greetPet(pet);
            child2.describePet(pet);
        }

        System.out.println("\n--- Unique methods of Humans ---");
        mother.makeup();
        father.repairCar();

        System.out.println("\n--- Children schedules ---");
        for (Human child : family.getChildren()) {
            System.out.println("\n" + child.getName() + "’s schedule:");

            for (Map.Entry<String, String> entry : child.getSchedule().entrySet()) {
                System.out.println(entry.getKey() + " — " + entry.getValue());
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
        fish.respond();
        roboCat.respond();

        dog.foul();
        cat.foul();

        dog.eat();
        cat.eat();
        fish.eat();
        roboCat.eat();
    }
}
