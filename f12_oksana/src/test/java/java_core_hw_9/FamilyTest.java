package java_core_hw_9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {

    private Human mother;
    private Human father;
    private Human child1;
    private Human child2;
    private Family family;
    private Pet cat;

    @BeforeEach
    void setUp() {
        mother = new Human("Anna", "Smith", "12/10/1985");
        father = new Human("John", "Smith", "25/03/1980");
        child1 = new Human("Lily", "Smith", "08/11/2010");
        child2 = new Human("Mike", "Smith", "18/08/2012");

        Set<String> catHabits = new HashSet<>(Arrays.asList("play", "sleep", "hunts"));
        cat = new DomesticCat("Murka", 3, 60, catHabits);
        family = new Family(mother, father);
    }

    @Test
    void addChild() {
        family.addChild(child1);
        assertEquals(1, family.getChildren().size());
        assertEquals(child1, family.getChildren().get(0));
        family.addChild(null);
        assertEquals(1, family.getChildren().size());
    }

    @Test
    void deleteChild() {
        family.addChild(child1);
        family.addChild(child2);
        assertTrue(family.deleteChild(0));
        assertEquals(1, family.getChildren().size());
        assertEquals(child2, family.getChildren().get(0));

        assertFalse(family.deleteChild(5));
        assertEquals(1, family.getChildren().size());
    }

    @Test
    void addPet() {
        family.addPet(cat);
        assertEquals(1, family.getPets().size());
        assertTrue(family.getPets().contains(cat));
        family.addPet(null);
        assertEquals(1, family.getPets().size());
    }

    @Test
    void describeAge() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String birthDate = "01/01/2000";
        Human human = new Human("John", "Smith", birthDate);

        LocalDate birth = LocalDate.parse(birthDate, formatter);
        LocalDate today = LocalDate.now();

        Period age = Period.between(birth, today);

        String expectedAge = age.getYears() + " years, " + age.getMonths() + " months, " + age.getDays() + " days";

        assertEquals(expectedAge, human.describeAge());
    }

    @Test
    void countFamily() {
        family.addChild(child1);
        family.addChild(child2);
        family.addPet(cat);
        assertEquals(4, family.countFamily());
    }

    @Test
    void testFamilyToString() {
        Human mother = new Human("Jessica", "Smith", "15/05/1980", 120, Family.createJessicaSchedule(), null);
        Human father = new Human("Michael", "Smith", "20/03/1978", 130, Family.createMichaelSchedule(), null);

        Family family = new Family(mother, father);

        Human child1 = new Human("Alice", "Smith", "10/02/2010", 110);
        Human child2 = new Human("Bob", "Smith", "05/06/2012", 100);
        family.addChild(child1);
        family.addChild(child2);

        Dog dog = new Dog("Pit", 3, 70, new HashSet<>());
        family.addPet(dog);

        String familyString = family.toString();

        assertTrue(familyString.contains("Jessica Smith"));
        assertTrue(familyString.contains("Michael Smith"));

        assertTrue(familyString.contains("Alice"));
        assertTrue(familyString.contains("Bob"));

        assertTrue(familyString.contains("Pit"));
    }

    @Test
    void testEquals() {
        Family sameFamily = new Family(
                new Human("Anna", "Smith", "12/10/1985"),
                new Human("John", "Smith", "25/03/1980")
        );
        assertEquals(family, sameFamily);
        Family differentFamily = new Family(
                new Human("Kate", "Brown", "12/10/1987"),
                new Human("Paul", "Brown", "25/03/1982")
        );
        assertNotEquals(family, differentFamily);
    }
}


