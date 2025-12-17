package java_core_hw_10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CollectionFamilyDao implements FamilyDao {

    private final List<Family> families = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return Collections.unmodifiableList(families);
    }

    List<Family> internalList() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (index < 0 || index >= families.size()) return null;
        return families.get(index);
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index < 0 || index >= families.size()) return false;
        families.remove(index);
        return true;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return families.remove(family);
    }

    @Override
    public Family saveFamily(Family family) {
        int idx = -1;
        for (int i = 0; i < families.size(); i++) {
            if (Objects.equals(families.get(i), family)) {
                idx = i;
                break;
            }
        }
        if (idx >= 0) families.set(idx, family);
        else families.add(family);

        return family;
    }
}
