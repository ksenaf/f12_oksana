package java_core_hw_5;

import java.util.Arrays;
import java.util.Objects;

public class Pet {
    private Species species; // type of animal
    private String nickname;
    private int age;
    private int trickLevel; // 0 to 100
    private String[] habits;

    public Pet(Species species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Species getSpecies() { return species; }
    public void setSpecies(Species species) { this.species = species; }
    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public int getTrickLevel() { return trickLevel; }
    public void setTrickLevel(int trickLevel) { this.trickLevel = trickLevel; }
    public String[] getHabits() { return habits; }
    public void setHabits(String[] habits) { this.habits = habits; }

    public void eat() {
        System.out.println("I'm eating!");
    }

    public void respond() {
        System.out.println("Hello, owner. I am your " + species.getDisplayName() + ", " + nickname + ". I miss you!");
    }

    public void foul() {
        System.out.println("I need to cover my tracks...");
    }

    @Override
    public String toString() {
        return "Pet{" +
                "species=" + (species != null ? species.getDisplayName() : "Unknown") +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return age == pet.age &&
                trickLevel == pet.trickLevel &&
                Objects.equals(species, pet.species) &&
                Objects.equals(nickname, pet.nickname) &&
                Arrays.equals(habits, pet.habits);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(species, nickname, age, trickLevel);
        result = 31 * result + Arrays.hashCode(habits);
        return result;
    }
}
