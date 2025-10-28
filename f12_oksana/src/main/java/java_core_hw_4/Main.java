package java_core_hw_4;

public class Main {
    public static void main(String[] args) {
        // Create Pet
        String[] habits = {"eat", "drink", "sleep"};
        Pet dog = new Pet("dog", "Rock", 5, 75, habits);

        // Create parents
        Human mother = new Human("Jane", "Karleone", 1980);
        Human father = new Human("Vito", "Karleone", 1975);

        // Create family
        Family family = new Family(mother, father);
        family.setPet(dog);

        // Create child
        String[][] schedule = {{"Monday", "Gym"}, {"Tuesday", "Music"}};
        Human child = new Human("Michael", "Karleone", 2005, 90, schedule);
        family.addChild(child);

        // Demonstrate methods
        child.greetPet();
        child.describePet();
        dog.eat();
        dog.respond();
        dog.foul();

        // Print info
        System.out.println("\n" + family);
        System.out.println("Family size: " + family.countFamily());
        System.out.println("\nChild info: " + child);
        System.out.println("\nPet info: " + dog);
    }
}
