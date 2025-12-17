package java_core_hw_6;

public class RoboCat extends Pet {
    public RoboCat(String nickname, int age, int trickLevel, String[] habits) {
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
