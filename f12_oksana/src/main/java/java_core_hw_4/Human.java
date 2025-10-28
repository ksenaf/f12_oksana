package java_core_hw_4;

import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private String[][] schedule;
    private Family family;

    // Constructors
    public Human() {}

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, int iq, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
    }

    public Human(String name, String surname, int year, int iq, String[][] schedule, Family family) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
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

    public Family getFamily() { return family; }
    public void setFamily(Family family) { this.family = family; }

    // Methods
    public void greetPet() {
        if (family != null && family.getPet() != null)
            System.out.println("Hello, " + family.getPet().getNickname());
    }

    public void describePet() {
        if (family != null && family.getPet() != null) {
            Pet p = family.getPet();
            String cleverness = (p.getTrickLevel() > 50) ? "very sly" : "almost not sly";
            System.out.println("I have a " + p.getSpecies() + ", he is " + p.getAge() + " years old, he is " + cleverness);
        }
    }

    // toString
    @Override
    public String toString() {
        StringBuilder scheduleStr = new StringBuilder("[");
        if (schedule != null) {
            for (int i = 0; i < schedule.length; i++) {
                scheduleStr.append("[")
                        .append(schedule[i][0]).append(", ")
                        .append(schedule[i][1]).append("]");
                if (i < schedule.length - 1) scheduleStr.append(", ");
            }
        }
        scheduleStr.append("]");
        return "Human{name='" + name + "', surname='" + surname + "', year=" + year +
                ", iq=" + iq + ", schedule=" + scheduleStr + "}";
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human h = (Human) o;
        return year == h.year && name.equals(h.name) && surname.equals(h.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year);
    }
}
