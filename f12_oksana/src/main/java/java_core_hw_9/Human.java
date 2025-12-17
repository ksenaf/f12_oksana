package java_core_hw_9;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Map;

public class Human {
    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private Map<String, String> schedule;
    private Family family;

    public Human(String name, String surname, String birthDateStr) {
        this.name = name;
        this.surname = surname;
        this.birthDate = parseBirthDate(birthDateStr);
    }

    public Human(String name, String surname, String birthDateStr, int iq, Map<String, String> schedule, Family family) {
        this.name = name;
        this.surname = surname;
        this.iq = iq;
        this.schedule = schedule;
        this.family = family;
        this.birthDate = parseBirthDate(birthDateStr);
    }

    public Human(String name, String surname, String birthDateStr, int iq) {
        this.name = name;
        this.surname = surname;
        this.iq = iq;
        this.birthDate = parseBirthDate(birthDateStr);
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

    public long getBirthDate() { return birthDate; }

    public void setBirthDate(long birthDate) { this.birthDate = birthDate; }

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

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private long parseBirthDate(String birthDateStr) {
        LocalDate date = LocalDate.parse(birthDateStr, FORMATTER);
        return date.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public String describeAge() {
        LocalDate birth = Instant.ofEpochMilli(birthDate)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        Period period = Period.between(birth, LocalDate.now());

        return String.format("%d years, %d months, %d days",
                period.getYears(), period.getMonths(), period.getDays());
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
        LocalDate date = Instant.ofEpochMilli(birthDate)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        StringBuilder sb = new StringBuilder("Human{name='")
                .append(name)
                .append("', surname='").append(surname)
                .append("', birthDate=").append(date.format(FORMATTER));

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
        return birthDate == human.birthDate &&
                iq == human.iq &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, iq);
    }
}

