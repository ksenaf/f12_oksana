package java_core_hw_4;

public class Main {
    public static void main(String[] args) {

        Pet dog = new Pet("dog", "Rock", 5, 75, new String[]{"eat", "drink", "sleep"});
        Pet cat = new Pet("cat", "Max");

        Human mother = new Human("Jane", "Karleone", 1975);
        Human father = new Human("Vito", "Karleone", 1970);
        Human child = new Human("Michael", "Karleone", 2000, 90, new String[][]{{"Monday","Football"},{"Tuesday","Music"}}, dog, null);

        Family family = new Family(mother, father);
        family.setPet(dog);
        family.addChild(child);

        child.greetPet();
        child.describePet();
        dog.eat();
        dog.respond();
        dog.foul();

        System.out.println(mother);
        System.out.println(father);
        System.out.println(child);

        System.out.println(family);

        System.out.println("Family members count: " + family.countFamily());
    }
}
