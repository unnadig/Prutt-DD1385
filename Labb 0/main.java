public class main {
    public static void main(String[] args) {
        /*
        Human person1 = new Human(17, "Jonas");
        Human randPerson1 = new Human();
        System.out.println(person1);  
        System.out.println(randPerson1); 
        Student student = new Student(24, "Jonas", 2014);
        System.out.println(student); 
        
        Human[] humanArray = new Human[15];
        for(int i=0; i<humanArray.length; i++) {
            Human humanArrayIn = new Human();
            humanArray[i] = humanArrayIn;
            System.out.println(humanArray[i]);
        }
        Student[] studentArray = new Student[15];
        for(int i=0; i<studentArray.length; i++) {
            Student studentArrayIn = new Student();
            studentArray[i] = studentArrayIn;
            System.out.println(studentArray[i]);
        }*/
        Human[] mixedArray = new Human[10];
        for (int i=0; i<mixedArray.length/2; i++) {
            Student studentIn = new Student();
            Human humanIn = new Human();
            mixedArray[i] = studentIn;
            mixedArray[5+i] = humanIn;
        }
        for (Human h : mixedArray) {
            System.out.println(h);
        }
    }
}
