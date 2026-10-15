class Person5 {
    String name;
    int age;

    Person5(String name, int age){
        this.name = name;
        this.age = age;
    }
    void display(){
        System.out.println("Name: " + name + ",Age: " + age);
    }
}
class Student5 extends Person5{
    String course;
    Student5(String name, int age, String course){
        super(name, age);
        this.course=course;

    }
}
class Teacher5 extends Person5{
    String subject;
    Teacher5(String name,int age ,String subject){
        super(name, age); //refuses the Person5 constructor
        this.subject = subject;
    }
}
class Person5Demo{
    public static void main (String[] args){
        Teacher5 t = new Teacher5("Merit",30 , "JAVA");
        Student5 s = new Student5("Mellisa",20,"OOP");
        //Both call the SAME display () method which is written once in Person5
        t.display(); // Name:Merit , Age:30
        s.display(); // Name:Mellisa , Age:20
        System.out.println("Course:" + s.course); //Course:OOP
        System.out.println("Subject:" + t.subject); //Subject:JAVA
    }
}
