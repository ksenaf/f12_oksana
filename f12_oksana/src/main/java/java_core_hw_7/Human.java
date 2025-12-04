package java_core_hw_7;

import java.util.Objects;
import java.util.Map;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Map<String, String> schedule;
    private Family family;

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, int iq, Map<String, String> schedule, Family family) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public Map<String, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String, String> schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public void greetPet(Pet pet) {
        System.out.println("Hello, " + pet.getNickname() + "!");
    }

    public void describePet(Pet pet) {
        String cleverness = (pet.getTrickLevel() > 50) ? "very tricky" : "not very tricky";
        System.out.println("I have a " + pet.getSpecies() +
                " named " + pet.getNickname() +
                ", age " + pet.getAge() +
                ", " + cleverness);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Human{name='")
                .append(name).append("', surname='").append(surname)
                .append("', year=").append(year);

        if (iq > 0) {
            sb.append(", iq=").append(iq);
        }
        if (schedule != null && !schedule.isEmpty()) {
            sb.append(", schedule=").append(schedule);
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

