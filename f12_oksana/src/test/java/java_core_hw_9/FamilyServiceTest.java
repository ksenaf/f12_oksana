package java_core_hw_9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class FamilyServiceTest {

    private FamilyService service;

    private String date(int yearsAgo) {
        return LocalDate.now()
                .minusYears(yearsAgo)
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @BeforeEach
    void setup() {
        service = new FamilyService(new CollectionFamilyDao());
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

        service.bornChild(f, "Maksym", "Olena");

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

        service.bornChild(f, "Maksym", "Olena");

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
}
