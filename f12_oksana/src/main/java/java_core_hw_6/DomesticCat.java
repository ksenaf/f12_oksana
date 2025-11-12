package java_core_hw_6;

public class DomesticCat extends Pet implements Foul {
    public DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
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
