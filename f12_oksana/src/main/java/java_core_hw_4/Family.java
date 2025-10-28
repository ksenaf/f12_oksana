package java_core_hw_4;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    // Constructor
    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
        mother.setFamily(this);
        father.setFamily(this);
    }

    // Getters and setters
    public Human getMother() { return mother; }
    public void setMother(Human mother) { this.mother = mother; }

    public Human getFather() { return father; }
    public void setFather(Human father) { this.father = father; }

    public Human[] getChildren() { return children; }
    public void setChildren(Human[] children) { this.children = children; }

    public Pet getPet() { return pet; }
    public void setPet(Pet pet) { this.pet = pet; }

    // Methods
    public void addChild(Human child) {
        Human[] newChildren = new Human[children.length + 1];
        for (int i = 0; i < children.length; i++) {
            newChildren[i] = children[i];
        }
        newChildren[children.length] = child;
        children = newChildren;
        child.setFamily(this);
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.length) return false;
        Human[] newChildren = new Human[children.length - 1];
        for (int i = 0, j = 0; i < children.length; i++) {
            if (i != index) {
                newChildren[j++] = children[i];
            }
        }
        children = newChildren;
        return true;
    }

    public int countFamily() {
        return 2 + children.length; // mother + father + children
    }

    // toString
    @Override
    public String toString() {
        StringBuilder childrenStr = new StringBuilder("[");
        for (int i = 0; i < children.length; i++) {
            childrenStr.append(children[i].toString());
            if (i < children.length - 1) childrenStr.append(", ");
        }
        childrenStr.append("]");
        return "Family{mother=" + mother + ", father=" + father + ", children=" + childrenStr + ", pet=" + pet + "}";
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family)) return false;
        Family f = (Family) o;
        return mother.equals(f.mother) && father.equals(f.father);
    }

    @Override
    public int hashCode() {
        return mother.hashCode() + father.hashCode();
    }
}
