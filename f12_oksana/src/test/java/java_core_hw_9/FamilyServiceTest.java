package java_core_hw_9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class FamilyServiceTest {

    private FamilyService service;
    private Family family;

    private String date(int yearsAgo) {
        return LocalDate.now()
                .minusYears(yearsAgo)
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @BeforeEach
    void setup() {
        service = new FamilyService(new CollectionFamilyDao());

        family = new Family(
                new Human("John", "Doe", LocalDate.now().minusYears(43).format(FORMATTER)),  // 43 роки
                new Human("Jane", "Doe", LocalDate.now().minusYears(38).format(FORMATTER))   // 38 років
        );

        LocalDate now = LocalDate.now();

        service.bornChild(family, "Maksym", "Oksana", now.minusYears(13).format(FORMATTER)); // 13 років
        service.bornChild(family, "Andriy", "Olena", now.minusYears(5).format(FORMATTER));   // 5 років
        service.bornChild(family, "Ivan", "Anna", now.minusYears(2).format(FORMATTER));
 // 2 роки
    }

    @Test
    void testCreateNewFamily() {
        Human mom = new Human("Anna", "Koval", "01/01/1990");
        Human dad = new Human("Oleh", "Koval", "02/02/1985");

        Family f = service.createNewFamily(mom, dad);

        assertEquals(1, service.count());
        assertEquals("Anna", f.getMother().getName());
        assertEquals("Oleh", f.getFather().getName());
    }

    @Test
    void testBornChild() {
        Human mom = new Human("Anna", "Koval", "01/01/1990");
        Human dad = new Human("Oleh", "Koval", "02/02/1985");

        Family f = service.createNewFamily(mom, dad);

        service.bornChild(f, "Maksym", "Olena", "15/02/2020");

        assertEquals(3, f.countFamily());
    }

    @Test
    void testAdoptChild() {
        Human mom = new Human("Anna", "Koval", "01/01/1990");
        Human dad = new Human("Oleh", "Koval", "02/02/1985");
        Family f = service.createNewFamily(mom, dad);

        Human child = new Human("Petro", "Shevchenko", date(10));

        service.adoptChild(f, child);

        assertEquals(3, f.countFamily());
    }

    @Test
    void testGetFamiliesBiggerThan() {
        Human mom = new Human("Anna", "Koval", "01/01/1990");
        Human dad = new Human("Oleh", "Koval", "02/02/1985");
        Family f = service.createNewFamily(mom, dad);

        service.bornChild(f, "Maksym", "Olena", "15/02/2015");

        assertEquals(1, service.getFamiliesBiggerThan(2).size());
    }

    @Test
    void testDeleteFamilyByIndex() {
        Human mom = new Human("Anna", "Koval", "01/01/1990");
        Human dad = new Human("Oleh", "Koval", "02/02/1985");

        service.createNewFamily(mom, dad);

        assertEquals(1, service.count());

        assertTrue(service.deleteFamilyByIndex(0));

        assertEquals(0, service.count());
    }

    @Test
    void testAddPet() {
        Human mom = new Human("Anna", "Koval", "01/01/1990");
        Human dad = new Human("Oleh", "Koval", "02/02/1985");
        Set<String> dogHabits = new HashSet<>(Arrays.asList("eat", "drink", "sleep"));
        service.createNewFamily(mom, dad);

        Pet pet = new Pet("dog", 5, 15, dogHabits) {
            @Override
            protected Species defineSpecies() {
                return null;
            }

            @Override
            public void respond() {

            }
        };

        service.addPet(0, pet);

        assertTrue(service.getPets(0).contains(pet));
    }

    @Test
    void testDeleteAllChildrenOlderThen() {
        List<Human> childrenBefore = family.getChildren();
        assertEquals(3, childrenBefore.size(), "There must be 3 children first");

        service.deleteAllChildrenOlderThen(5);

        List<Human> childrenAfter = family.getChildren();

        assertEquals(2, childrenAfter.size(), "After removal, there should be 2 children left");

        boolean maksymExists = childrenAfter.stream()
                .anyMatch(child -> child.getName().equals("Maksym"));
        assertFalse(maksymExists, "Maksym should be deleted");

        boolean andriyExists = childrenAfter.stream()
                .anyMatch(child -> child.getName().equals("Andriy"));
        boolean ivanExists = childrenAfter.stream()
                .anyMatch(child -> child.getName().equals("Ivan"));

        assertTrue(andriyExists, "Andriy should stay");
        assertTrue(ivanExists, "Ivan should stay");
    }
}
