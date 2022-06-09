class NumberedItem<T> implements Comparable<NumberedItem<T>>{
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
    @Override
    public int compareTo(NumberedItem<T> i) {
        return getIndex() - i.getIndex();
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof NumberedItem<?>)) {
            return false;
        } else {
            NumberedItem<T> n = (NumberedItem<T>) object;
        
            if ((getIndex() == n.getIndex()) || (getT() == n.getT())) {
                return true;
            } else {
                return false;
            }
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