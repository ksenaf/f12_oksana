package java_core_hw_10;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children = new ArrayList<>();
    private Set<Pet> pets = new HashSet<>();

    private static final int MAX_FAMILY_SIZE = 6; // Додаємо обмеження на розмір сім'ї

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        mother.setFamily(this);
        father.setFamily(this);
    }

    public Human getMother() { return mother; }
    public void setMother(Human mother) { this.mother = mother; }
    public Human getFather() { return father; }
    public void setFather(Human father) { this.father = father; }
    public List<Human> getChildren() { return children; }
    public void setChildren(List<Human> children) { this.children = children; }
    public Set<Pet> getPets() { return pets; }
    public void setPets(Set<Pet> pets) { this.pets = pets; }

    public void addChild(Human child) {
        if (child == null) {
            System.out.println("You have not submitted anything!");
            return;
        }

        if (countFamily() >= MAX_FAMILY_SIZE) {
            throw new FamilyOverflowException(
                    "Cannot add child. Family already has " + countFamily() + " members (max " + MAX_FAMILY_SIZE + ")."
            );
        }

        children.add(child);
        child.setFamily(this);
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.size()) {
            System.out.println("Invalid index!");
            return false;
        }

        Human removed = children.remove(index);
        if (removed != null) {
            removed.setFamily(null);
        }

        return true;
    }

    public void addPet(Pet pet) {
        if (pet == null) {
            System.out.println("Cannot add null pet!");
            return;
        }

        pets.add(pet);
    }

    public int countFamily() {
        return 2 + children.size(); // 2 батьки + діти
    }

    public String prettyFormat() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        StringBuilder sb = new StringBuilder();
        sb.append("family:\n");
        sb.append("\tmother: ").append(mother.prettyFormat()).append("\n");
        sb.append("\tfather: ").append(father.prettyFormat()).append("\n");
        sb.append("\tchildren:\n");
        for (Human child : children) {
            sb.append("\t\t").append(child.prettyFormat()).append("\n");
        }
        sb.append("\tpets: [");
        Iterator<Pet> it = pets.iterator();
        while (it.hasNext()) {
            sb.append(it.next().prettyFormat());
            if (it.hasNext()) sb.append(", ");
        }
        sb.append("]\n");

        return sb.toString();
    }

    public static Map<String, String> createJessicaSchedule() {
        Map<String, String> schedule = new LinkedHashMap<>();
        schedule.put(DayOfWeek.MONDAY.getDisplayName(), "go to the gym");
        schedule.put(DayOfWeek.TUESDAY.getDisplayName(), "watch a movie");
        schedule.put(DayOfWeek.WEDNESDAY.getDisplayName(), "visit friends");
        schedule.put(DayOfWeek.THURSDAY.getDisplayName(), "read a book");
        schedule.put(DayOfWeek.FRIDAY.getDisplayName(), "have a family dinner");
        schedule.put(DayOfWeek.SATURDAY.getDisplayName(), "go shopping");
        schedule.put(DayOfWeek.SUNDAY.getDisplayName(), "rest");
        return schedule;
    }

    public static Map<String, String> createMichaelSchedule() {
        Map<String, String> schedule = new LinkedHashMap<>();
        schedule.put(DayOfWeek.MONDAY.getDisplayName(), "football practice");
        schedule.put(DayOfWeek.TUESDAY.getDisplayName(), "do homework");
        schedule.put(DayOfWeek.WEDNESDAY.getDisplayName(), "play video games");
        schedule.put(DayOfWeek.THURSDAY.getDisplayName(), "piano lesson");
        schedule.put(DayOfWeek.FRIDAY.getDisplayName(), "movie night");
        schedule.put(DayOfWeek.SATURDAY.getDisplayName(), "go cycling");
        schedule.put(DayOfWeek.SUNDAY.getDisplayName(), "rest");
        return schedule;
    }

    public static Map<String, String> createAnnaSchedule() {
        Map<String, String> schedule = new LinkedHashMap<>();
        schedule.put(DayOfWeek.MONDAY.getDisplayName(), "go to music school");
        schedule.put(DayOfWeek.TUESDAY.getDisplayName(), "read a book");
        schedule.put(DayOfWeek.WEDNESDAY.getDisplayName(), "do homework");
        schedule.put(DayOfWeek.THURSDAY.getDisplayName(), "cleaning");
        schedule.put(DayOfWeek.FRIDAY.getDisplayName(), "go shopping");
        schedule.put(DayOfWeek.SATURDAY.getDisplayName(), "training");
        schedule.put(DayOfWeek.SUNDAY.getDisplayName(), "rest");
        return schedule;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String motherBirth = Instant.ofEpochMilli(mother.getBirthDate())
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .format(formatter);

        String fatherBirth = Instant.ofEpochMilli(father.getBirthDate())
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .format(formatter);

        return "Family{" +
                "mother=" + mother.getName() + " " + mother.getSurname() + " (" + motherBirth + ")" +
                ", father=" + father.getName() + " " + father.getSurname() + " (" + fatherBirth + ")" +
                ", children=" + children +
                ", pets=" + pets +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family)) return false;

        Family family = (Family) o;

        return Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father) &&
                Objects.equals(children, family.children) &&
                Objects.equals(pets, family.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, children, pets);
    }
}
