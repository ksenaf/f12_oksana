package java_core_hw_4;

public class Main {
    public static void main(String[] args) {
        // Create pets
        Pet dog = new Pet("dog", "Rex", 5, 75, new String[]{"eat", "drink", "sleep"});
        Pet cat = new Pet("cat", "Max");

        // Create humans
        Human mother = new Human("Jane", "Karleone", 1975);
        Human father = new Human("Vito", "Karleone", 1970);
        Human child = new Human("Michael", "Karleone", 2000, 90, new String[][]{{"Monday","Football"},{"Tuesday","Music"}}, dog, null);

        // Create family
        Family family = new Family(mother, father);
        family.setPet(dog);
        family.addChild(child);

        // Access child methods
        child.greetPet();
        child.describePet();
        dog.eat();
        dog.respond();
        dog.foul();

        // Print humans
        System.out.println(mother);
        System.out.println(father);
        System.out.println(child);

        // Print family
        System.out.println(family);

        // Count family members
        System.out.println("Family members count: " + family.countFamily());
    }
}
