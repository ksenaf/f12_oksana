package java_core_hw_10;

public final class Woman extends Human {
    public Woman(String name, String surname, String birthDate) {
        super(name, surname, birthDate);
    }

    @Override
    public void greetPet(Pet pet) {
        System.out.println("Hello, " + pet.getNickname() + "! I am very happy to see you!");
    }

    public void makeup() {
        System.out.println(getName() + " doing makeup.");
    }
}
