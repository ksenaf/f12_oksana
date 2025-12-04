package java_core_hw_5;

import java.util.Arrays;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private String[][] schedule;
    private Pet pet;
    private Family family;

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, int iq, String[][] schedule, Pet pet, Family family) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
        this.pet = pet;
        this.family = family;
    }

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
        StringBuilder sb = new StringBuilder("Human{name='")
                .append(name).append("', surname='").append(surname)
                .append("', year=").append(year);

        if (iq > 0) {
            sb.append(", iq=").append(iq);
        }
        if (schedule != null) {
            sb.append(", schedule=").append(Arrays.deepToString(schedule));
        }

        sb.append("}");
        return sb.toString();
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

