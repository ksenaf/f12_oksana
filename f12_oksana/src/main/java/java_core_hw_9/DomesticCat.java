package java_core_hw_9;

import java.util.Set;

public class DomesticCat extends Pet implements Foul {
    public DomesticCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    @Override
    protected Species defineSpecies() {
        return Species.CAT;
    }

    @Override
    public void respond() {
        System.out.println("I am a cat " + getNickname());
    }

    @Override
    public void foul() {
        System.out.println(getNickname() + " left a bunch...");
    }
}
