package java_core_hw_4;

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
        Human[] newChildren = Arrays.copyOf(children, children.length + 1);
        newChildren[children.length] = child;
        children = newChildren;
        child.setFamily(this);
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.length) return false;
        Human[] newChildren = new Human[children.length - 1];
        for (int i = 0, j = 0; i < children.length; i++) {
            if (i != index) newChildren[j++] = children[i];
        }
        children = newChildren;
        return true;
    }

    public void addPet(Pet pet) {
        Pet[] newPets = Arrays.copyOf(pets, pets.length + 1);
        newPets[pets.length] = pet;
        pets = newPets;
    }

    public int countFamily() {
        return 2 + children.length; // 2 parents + children
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