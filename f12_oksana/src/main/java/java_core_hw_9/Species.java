package java_core_hw_9;

public enum Species {
    CAT,
    DOG,
    ROBOCAT,
    FISH,
    UNKNOWN;


    public String getDisplayName() {
        String name = this.name().toLowerCase();
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
