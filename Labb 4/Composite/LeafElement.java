class LeafElement extends SuitcaseComponent {
    
    LeafElement(String name, int weight) {
        super(name, weight);
    }

    public String toString() {
        return "\n"+getLevel() + " " + getName() + " " + getWeight();
    }

    int getWeight() {
        return getComponentWeight();
    }

    void incrementLevel() {
        setLevel(getLevel() + 1);
    }
}