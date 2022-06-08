abstract class SuitcaseComponent {
    private String name;
    private int weight;
    private int level;

    SuitcaseComponent(String name, int weight) {
        this.name = name;
        this.weight = weight;
        this.level = 0;
    }

    String getName() {
        return name;
    }

    int getComponentWeight() {
        return weight;
    }

    int getLevel() {
        return level;
    }
    void setLevel(int newLevel) {
        level = newLevel;
    }

    public abstract String toString();
    abstract int getWeight();
    abstract void incrementLevel();
    
}