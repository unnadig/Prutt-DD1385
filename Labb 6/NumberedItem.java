class NumberedItem<T> {
    private int index;
    private T t;

    NumberedItem(int index, T t) {
        if (index < 0) {
            this.index = 0;
        } else {
            this.index = index;
        }
        
        this.t = t;
    }

    public int compareTo(NumberedItem<T> i) {
        return getIndex() - i.getIndex();
    }

    public boolean equals(NumberedItem<T> i) {
        //if (i == null) { return false; }
        try {        
            if (getIndex() == i.getIndex()) {
                return true;
            } else if (getT() == i.getT()) {
                return true;
            } else {
                return false;
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!");
            return false;
        }

    }

    public String toString() {
        return "Index: "+getIndex()+" Value: "+getT();
    }

    public void setIndex(int newIndex) { this.index = newIndex; }
    public int getIndex() { return index; }
    public void setT(T newT) { this.t = newT; }
    public T getT() { return t; }
}