package java_core_hw_10;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {

    private final FamilyDao familyDao;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return new ArrayList<>(familyDao.getAllFamilies());
    }

    public void displayAllFamilies() {
        List<Family> families = familyDao.getAllFamilies();
        for (int i = 0; i < families.size(); i++) {
            System.out.println((i + 1) + ". " + families.get(i).prettyFormat()); // використання prettyFormat()
        }
    }

    public List<Family> getFamiliesBiggerThan(int count) {
        return familyDao.getAllFamilies()
                .stream()
                .filter(f -> f.countFamily() > count)
                .collect(Collectors.toList());
    }

    public List<Family> getFamiliesLessThan(int count) {
        return familyDao.getAllFamilies()
                .stream()
                .filter(f -> f.countFamily() < count)
                .collect(Collectors.toList());
    }

    public long countFamiliesWithMemberNumber(int count) {
        return familyDao.getAllFamilies()
                .stream()
                .filter(f -> f.countFamily() == count)
                .count();
    }

    public Family createNewFamily(Human mother, Human father) {
        Family family = new Family(mother, father);
        familyDao.saveFamily(family);
        return family;
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String maleName, String femaleName, String birthDateStr) {
        boolean isBoy = Math.random() < 0.5;
        String name = isBoy ? maleName : femaleName;

        String surname = family.getFather() != null
                ? family.getFather().getSurname()
                : family.getMother().getSurname();

        Human baby = new Human(name, surname, birthDateStr);

        final int MAX_FAMILY_SIZE = 6;
        if (family.countFamily() >= MAX_FAMILY_SIZE) {
            throw new FamilyOverflowException(
                    "Cannot add child. Family already has " + family.countFamily() + " members (max " + MAX_FAMILY_SIZE + ")."
            );
        }

        family.addChild(baby);
        familyDao.saveFamily(family);

        return family;
    }

    public Family adoptChild(Family family, Human child) {
        final int MAX_FAMILY_SIZE = 6;
        if (family.countFamily() >= MAX_FAMILY_SIZE) {
            throw new FamilyOverflowException(
                    "Cannot adopt child. Family already has " + family.countFamily() + " members (max " + MAX_FAMILY_SIZE + ")."
            );
        }

        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    private int calculateAge(Human human) {
        LocalDate birth = Instant.ofEpochMilli(human.getBirthDate())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        return Period.between(birth, LocalDate.now()).getYears();
    }

    public void deleteAllChildrenOlderThen(int age) {
        for (Family f : familyDao.getAllFamilies()) {
            f.getChildren().removeIf(child -> calculateAge(child) > age);
            familyDao.saveFamily(f);
        }
    }

    public int count() {
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyById(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public Set<Pet> getPets(int index) {
        Family family = getFamilyById(index);
        return family != null ? family.getPets() : null;
    }

    public void addPet(int index, Pet pet) {
        Family family = getFamilyById(index);
        if (family != null) {
            family.getPets().add(pet);
            familyDao.saveFamily(family);
        }
    }

    public void displayFamilies(List<Family> families) {
        if (families == null || families.isEmpty()) {
            System.out.println("No families found.");
            return;
        }
        for (int i = 0; i < families.size(); i++) {
            System.out.println((i + 1) + ". " + families.get(i).prettyFormat());
        }
    }
}
