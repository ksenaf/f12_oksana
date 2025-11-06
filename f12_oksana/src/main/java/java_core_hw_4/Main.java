package java_core_hw_4;

public class Main {
    public static void main(String[] args) {

        Pet dog = new Pet("dog", "Rock", 5, 45, new String[]{"eat", "drink", "sleep"});
        Pet cat = new Pet("cat", "Max", 3, 60, new String[]{"play", "sleep", "hunts"});

        Human mother = new Human("Jane", "Karleone", 1975);
        Human father = new Human("Vito", "Karleone", 1970);

        Human child1 = new Human("Michael", "Karleone", 2000, 90, new String[][]{{"Monday", "Football"},{"Tuesday", "Music"}}, dog, null);
        Human child2 = new Human("Jessica", "Karleone", 2003, 80, new String[][]{{"Wednesday", "Dance"}, {"Thursday", "Theater"}}, cat, null);

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
            mother.setPet(pet);
            father.setPet(pet);
            child1.setPet(pet);
            child2.setPet(pet);

            mother.greetPet();
            mother.describePet();

            father.greetPet();
            father.describePet();

            child1.greetPet();
            child1.describePet();

            child2.greetPet();
            child2.describePet();
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
