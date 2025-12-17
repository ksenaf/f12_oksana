package java_core_hw_6;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet[] pets;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
        this.pets = new Pet[0];
        mother.setFamily(this);
        father.setFamily(this);
    }

    public Human getMother() { return mother; }
    public void setMother(Human mother) { this.mother = mother; }
    public Human getFather() { return father; }
    public void setFather(Human father) { this.father = father; }
    public Human[] getChildren() { return children; }
    public void setChildren(Human[] children) { this.children = children; }
    public Pet[] getPets() { return pets; }
    public void setPets(Pet[] pets) { this.pets = pets; }

    public void addChild(Human child) {
        if (child == null) {
            System.out.println("You have not submitted anything!");
            return;
        }

        Human[] newChildren = new Human[children.length + 1];
        for (int i = 0; i < children.length; i++) {
            newChildren[i] = children[i];
        }
        newChildren[children.length] = child;
        children = newChildren;
        child.setFamily(this);
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.length) return false;
        Human[] newChildren = new Human[children.length - 1];
        int j = 0;
        for (int i = 0; i < children.length; i++) {
            if (i != index) {
                newChildren[j++] = children[i];
            }
        }
        children = newChildren;
        return true;
    }

    public void addPet(Pet pet) {
        if (pet == null) {
            System.out.println("You have not submitted anything!");
            return;
        }

        Pet[] newPets = new Pet[pets.length + 1];
        for (int i = 0; i < pets.length; i++) {
            newPets[i] = pets[i];
        }
        newPets[pets.length] = pet;
        pets = newPets;
    }

    public int countFamily() {
        return 2 + children.length;
    }

    public static String[][] createJessicaSchedule() {
        return new String[][]{
                {DayOfWeek.MONDAY.getDisplayName(), "go to the gym"},
                {DayOfWeek.TUESDAY.getDisplayName(), "watch a movie"},
                {DayOfWeek.WEDNESDAY.getDisplayName(), "visit friends"},
                {DayOfWeek.THURSDAY.getDisplayName(), "read a book"},
                {DayOfWeek.FRIDAY.getDisplayName(), "have a family dinner"},
                {DayOfWeek.SATURDAY.getDisplayName(), "go shopping"},
                {DayOfWeek.SUNDAY.getDisplayName(), "rest"}
        };
    }

    public static String[][] createMichaelSchedule() {
        return new String[][]{
                {DayOfWeek.MONDAY.getDisplayName(), "football practice"},
                {DayOfWeek.TUESDAY.getDisplayName(), "do homework"},
                {DayOfWeek.WEDNESDAY.getDisplayName(), "play video games"},
                {DayOfWeek.THURSDAY.getDisplayName(), "piano lesson"},
                {DayOfWeek.FRIDAY.getDisplayName(), "movie night"},
                {DayOfWeek.SATURDAY.getDisplayName(), "go cycling"},
                {DayOfWeek.SUNDAY.getDisplayName(), "rest"}
        };
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother.getName() + " " + mother.getSurname() + " (" + mother.getYear() + ")" +
                ", father=" + father.getName() + " " + father.getSurname() + " (" + father.getYear() + ")" +
                ", children=" + Arrays.toString(children) +
                ", pets=" + Arrays.toString(pets) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family)) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father) &&
                Arrays.equals(children, family.children) &&
                Arrays.equals(pets, family.pets);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mother, father);
        result = 31 * result + Arrays.hashCode(children);
        result = 31 * result + Arrays.hashCode(pets);
        return result;
    }
}