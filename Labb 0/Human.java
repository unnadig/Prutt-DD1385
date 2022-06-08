import java.util.Random;

public class Human {

    private String name;
    private int age;
    public static final String[] nameArray = {"Patrik","Frida","Anton","Isak","Joel","Gudrun","Fredrik","Mona","Lisa","Eva","Agnes","Lars","Åke","Otto"};
    public static final Random rnd = new Random();

    public Human(int ageIn, String nameIn){
        age = ageIn;
        name = nameIn;
    }

    public Human(){
        this(rnd.nextInt(100), nameArray[rnd.nextInt(nameArray.length)]);
        while (this.getAge() < 15) {
            this.setAge(15);
        }
    }
/*
    public int compareTo(Human o){
        int diff = this.age-o.getAge();
        if(diff==0){
            if(o instanceof Fysiker){
                diff=((Fysiker) o).compareStartYear(this);
            }
        }
        return diff;
    }
*/

    public String toString(){ return "namn: "+name+", ålder: "+age; }

    public int getAge(){ return age; }

    public String getName(){return name;}

    public void setName(String nameIn){name = nameIn;}

    public void setAge(int ageIn){age = ageIn;}
}
