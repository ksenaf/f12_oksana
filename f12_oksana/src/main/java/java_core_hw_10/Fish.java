package java_core_hw_10;

import java.util.Set;

public class Fish extends Pet {
    public Fish(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    @Override
    protected Species defineSpecies() {
        return Species.FISH;
    }

    @Override
    public void respond() {
        System.out.println("I am a fish " + getNickname());
    }
}
