package java_core_hw_9;

import java.util.Set;

public class RoboCat extends Pet {
    public RoboCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    @Override
    protected Species defineSpecies() {
        return Species.ROBOCAT;
    }

    @Override
    public void respond() {
        System.out.println("I am a robot cat " + getNickname());
    }
}
