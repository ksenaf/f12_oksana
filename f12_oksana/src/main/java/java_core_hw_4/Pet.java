package java_core_hw_4;

public class Pet {
    private String species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    // Constructors
    public Pet() {}

    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    // Getters and setters
    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public int getTrickLevel() { return trickLevel; }
    public void setTrickLevel(int trickLevel) { this.trickLevel = trickLevel; }

    public String[] getHabits() { return habits; }
    public void setHabits(String[] habits) { this.habits = habits; }

    // Methods
    public void eat() {
        System.out.println("I am eating!");
    }

    public void respond() {
        System.out.println("Hello, owner. I am " + nickname + ". I miss you!");
    }

    public void foul() {
        System.out.println("I need to cover it up well...");
    }

    // toString
    @Override
    public String toString() {
        StringBuilder habitsList = new StringBuilder("[");
        if (habits != null) {
            for (int i = 0; i < habits.length; i++) {
                habitsList.append(habits[i]);
                if (i < habits.length - 1) habitsList.append(", ");
            }
        }
        habitsList.append("]");
        return species + "{nickname='" + nickname + "', age=" + age +
                ", trickLevel=" + trickLevel + ", habits=" + habitsList + "}";
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return age == pet.age &&
                trickLevel == pet.trickLevel &&
                species.equals(pet.species) &&
                nickname.equals(pet.nickname);
    }

    @Override
    public int hashCode() {
        int result = species.hashCode();
        result = 31 * result + nickname.hashCode();
        result = 31 * result + age;
        result = 31 * result + trickLevel;
        return result;
    }
}
