package java_core_hw_7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        mother = new Human("Anna", "Smith", 1985);
        father = new Human("John", "Smith", 1980);
        child1 = new Human("Lily", "Smith", 2010);
        child2 = new Human("Mike", "Smith", 2012);

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
    void countFamily() {
        family.addChild(child1);
        family.addChild(child2);
        family.addPet(cat);
        assertEquals(4, family.countFamily());
    }

    @Test
    void testToString() {
        family.addChild(child1);
        family.addPet(cat);
        String str = family.toString();
        assertTrue(str.contains("mother=Anna Smith (1985)"));
        assertTrue(str.contains("father=John Smith (1980)"));
        assertTrue(str.contains("children="));
        assertTrue(str.contains("pets="));
    }

    @Test
    void testEquals() {
        Family sameFamily = new Family(
                new Human("Anna", "Smith", 1985),
                new Human("John", "Smith", 1980)
        );
        assertEquals(family, sameFamily);
        Family differentFamily = new Family(
                new Human("Kate", "Brown", 1987),
                new Human("Paul", "Brown", 1982)
        );
        assertNotEquals(family, differentFamily);
    }
}


