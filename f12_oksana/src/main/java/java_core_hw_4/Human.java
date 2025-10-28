package java_core_hw_4;

import java.util.Arrays;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private String[][] schedule;
    private Pet pet;
    private Family family; // reference to the family

    // Empty constructor
    public Human() {
    }

    // Constructor with name, surname, year
    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    // Constructor with name, surname, year, father and mother
    public Human(String name, String surname, int year, Family family) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.family = family;
    }

    // Constructor with all fields
    public Human(String name, String surname, int year, int iq, String[][] schedule, Pet pet, Family family) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
        this.pet = pet;
        this.family = family;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public int getIq() { return iq; }
    public void setIq(int iq) { this.iq = iq; }
    public String[][] getSchedule() { return schedule; }
    public void setSchedule(String[][] schedule) { this.schedule = schedule; }
    public Pet getPet() { return pet; }
    public void setPet(Pet pet) { this.pet = pet; }
    public Family getFamily() { return family; }
    public void setFamily(Family family) { this.family = family; }

    // Methods
    public void greetPet() {
        if (pet != null) System.out.println("Hello, " + pet.getNickname());
    }

    public void describePet() {
        if (pet != null) {
            String sly = pet.getTrickLevel() > 50 ? "very sly" : "almost not sly";
            System.out.println("I have a " + pet.getSpecies() + ", he is " + pet.getAge() + " years old, he is " + sly);
        }
    }

    @Override
    public String toString() {
        return "Human{name='" + name + "', surname='" + surname + "', year=" + year +
                ", iq=" + iq + ", schedule=" + Arrays.deepToString(schedule) + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return year == human.year &&
                iq == human.iq &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, iq);
    }
}

