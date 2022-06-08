import java.util.ArrayList;
class CompositeElement extends SuitcaseComponent {

    private ArrayList<SuitcaseComponent> children = new ArrayList<>();

    CompositeElement(String name, int weight) {
        super(name, weight);
        //this.children = ;
    }

    public String toString() {
        String outString = "\n"+getLevel() + " " + getName() + " " + getWeight();
        for (SuitcaseComponent c : children) {
            outString += c.toString();
        }

        return outString;
    }

    int getWeight() {
        int outWeight = getComponentWeight();
        for (SuitcaseComponent c : children) {
            outWeight += c.getWeight();
        }

        return outWeight;
    }
    
    // fungerar endast om allt packas i rätt ordning från början
    void incrementLevel() {
        setLevel(getLevel() + 1);
        for (SuitcaseComponent c : children) {
            c.incrementLevel();
        }
    }

    void add(SuitcaseComponent c) {
        c.incrementLevel();
        children.add(c);
    }

    void remove(int i) {
        children.remove(i);
    }
}