package java_core_hw_10;

import java.util.*;

public class FamilyDaoImpl implements FamilyDao {

    private List<Family> families = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (index < 0 || index >= families.size()) {
            return null;
        }
        return families.get(index);
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index < 0 || index >= families.size()) {
            return false;
        }
        families.remove(index);
        return true;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return families.remove(family);
    }

    @Override
    public Family saveFamily(Family family) {
        if (!families.contains(family)) {
            families.add(family);
        }
        return family;
    }

    public void fillTestDataWithPets() {
        // First family
        Human mother1 = new Human("Kate", "Bibo", "03/03/1991", 95);
        Human father1 = new Human("Karl", "Bibo", "10/12/1990", 90);
        Family family1 = new Family(mother1, father1);

        Human child1 = new Human("Jessica", "Bibo", "23/10/2018", 92, Family.createJessicaSchedule(), null);
        Human child2 = new Human("Michael", "Bibo", "23/10/2018", 92, Family.createMichaelSchedule(), null);
        family1.addChild(child1);
        family1.addChild(child2);

        Pet dog = new Dog("Jack", 3, 35, new HashSet<>(Arrays.asList("sleep")));
        Pet cat = new DomesticCat("Oscar", 5, 81, new HashSet<>(Arrays.asList("eat", "play")));

        family1.addPet(dog);
        family1.addPet(cat);

        saveFamily(family1);

        // Second family
        Human mother2 = new Human("Anna", "Kole", "15/06/1985", 88);
        Human father2 = new Human("Tom", "Kole", "22/08/1983", 85);
        Family family2 = new Family(mother2, father2);

        Human child3 = new Human("Anna", "Kole", "05/05/2003", 85, Family.createAnnaSchedule(), null);
        family2.addChild(child3);

        Pet parrot = new Fish("Polly", 2, 10, new HashSet<>(Arrays.asList("swim", "eat")));
        family2.addPet(parrot);

        saveFamily(family2);
    }
}
