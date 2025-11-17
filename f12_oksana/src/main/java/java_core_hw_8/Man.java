package java_core_hw_8;

public final class Man extends Human {
    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    @Override
    public void greetPet(Pet pet) {
        System.out.println("Hey, " + pet.getNickname() + "! Nice to see you!");
    }

    public void repairCar() {
        System.out.println(getName() + " repairs a car.");
    }
}
