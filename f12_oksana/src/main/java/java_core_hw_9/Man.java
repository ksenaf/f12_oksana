package java_core_hw_9;

public final class Man extends Human {
    public Man(String name, String surname, String birthDate) {
        super(name, surname, birthDate);
    }

    @Override
    public void greetPet(Pet pet) {
        System.out.println("Hey, " + pet.getNickname() + "! Nice to see you!");
    }

    public void repairCar() {
        System.out.println(getName() + " repairs a car.");
    }
}
