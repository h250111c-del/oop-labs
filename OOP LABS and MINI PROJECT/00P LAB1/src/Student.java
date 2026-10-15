public class Student {
    private String name;
    private int marks;
    //the constructor calls the setters ,so validation happens in one place
    public Student(String name, int marks){
        setName(name);
        setMarks(marks);
    }
    public String getName(){
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be empty");

        }
        this.name = name;
    }
    public int getMarks(){
        return marks;
    }
    public char getGrade(){
        if(marks >= 75) return'A';
        if(marks >= 65) return'B';
        if(marks >= 50) return'C';
        return 'F';

    }

    //Rejects any mark outside 0 to 100

    public void setMarks(int marks) {
        if(marks<0 || marks>100){
            throw new IllegalArgumentException("Marks must be between 0 and 100,got"+marks);
        }
        this.marks = marks;
    }
    @Override
    public String toString(){
        return name + ":" + marks + "(" + getGrade() +")";
    }
    public static void main(String[]args){
        Student s = new Student("Merit",75);
        System.out.println(s);

        s.setMarks(68);
        System.out.println(s);

        s.setMarks(55);
        System.out.println(s);

        s.setMarks(30);
        System.out.println(s);


        }
    }

