package java_core_hw_4;

public class Main {
    public static void main(String[] args) {
        // Створюємо домашнього улюбленця
        String[] habits = {"їсти", "спати", "ловити мишей"};
        Pet cat = new Pet("cat", "Murka", 3, 60, habits);

        // Створюємо батьків
        Human mother = new Human("Anna", "Ivanova", 1985);
        Human father = new Human("Oleh", "Ivanov", 1980);

        // Створюємо сім'ю
        Family ivanovFamily = new Family(mother, father);
        ivanovFamily.setPet(cat);

        // Створюємо дитину
        String[][] schedule = {
                {"Monday", "Swimming"},
                {"Tuesday", "Piano"}
        };
        Human child = new Human("Andrii", "Ivanov", 2010, 90, schedule);
        ivanovFamily.addChild(child);

        // Викликаємо методи дитини
        child.greetPet();
        child.describePet();

        // Виводимо інформацію
        System.out.println("\n" + ivanovFamily);
        System.out.println("Кількість членів сім'ї: " + ivanovFamily.countFamily());
    }
}
