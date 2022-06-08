public class Student extends Human {
    private int year;

    public Student(int ageIn, String nameIn, int yearIn) {
        super(ageIn, nameIn);
        year = yearIn;
    }

    public Student() {
        this(rnd.nextInt(100), nameArray[rnd.nextInt(nameArray.length)], 0);
        while (this.getAge() < 15) {
            this.setAge(rnd.nextInt(100));
        }
        
        System.out.println(this.getAge());
        this.setYear(2020 - this.getAge() + 15 + rnd.nextInt(this.getAge()-14));

    }

    public String toString() {
        return "namn: "+this.getName()+", ålder: "+this.getAge()+", började på KTH "+year;
    }
    public void setYear(int newYear) {
        year = newYear;
    }
}