package human;
public abstract class Human {
    private String name;
    private String genderString;

    Human(String name) {
        this.name = name;
    }

    public String toString() {
        String outString = "Jag heter " + getName() + " och är " + getGenderString();
        return outString;
    }

    void setGenderString(String genderStringIn) {
        this.genderString = genderStringIn;
    }

    String getName() {
        return name;
    }

    String getGenderString() {
        return genderString;
    }

	public static Human create(String name, String pnr) {
        int genderInt = Character.getNumericValue(pnr.charAt(9));

        if (genderInt == 0) {
            return new NonBinary(name);
        } else if (genderInt % 2 == 1) {
            return new Man(name);
        } else {
            return new Woman(name);
        }
    }
}