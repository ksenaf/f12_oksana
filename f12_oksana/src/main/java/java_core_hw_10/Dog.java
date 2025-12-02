package java_core_hw_10;

import java.util.Set;

public class Dog extends Pet implements Foul {
    public Dog(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    @Override
    protected Species defineSpecies() {
        return Species.DOG;
    }

    @Override
    public void respond() {
        System.out.println("I am a dog " + getNickname());
    }

    @Override
    public void foul() {
        System.out.println(getNickname() + " did abomination!");
    }
}
