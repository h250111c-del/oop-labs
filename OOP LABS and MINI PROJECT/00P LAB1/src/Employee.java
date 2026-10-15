public class Employee {
    //static: //shared by all employees,holds the NEXT id to hand out
    private static int nextId = 1;

    private final int employeeId; //final:assigned once ,never changed
    private String name;
    private double salary;
    private String department;

    //Main constructor:the other constructors end up calling this one
    public Employee(String name, double salary, String department) {
        this.employeeId = nextId++;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    //Overloaded constructor 2: default department
    public Employee(String name, double salary) {
        this(name, salary, "General");//must be the first statement
    }

    //Overloaded constructor 3:name only ,default salary
    public Employee(String name) {
        this(name, 0.0);
    }

    //copy constructor: independent object with the same values.
    //It gets its own new id so ids stay unique.
    public Employee(Employee other) {
        this(other.name, other.salary, other.department);
    }

    @Override
    public String toString() {
        return "Employee{id=" + employeeId + ",name=" + name + ",salary=" + salary + ",dept=" + department + "}";

    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Faith", 5000, "IT");
        Employee e2 = new Employee("Merit", 7000);
        Employee e3 = new Employee("Tapiwa");
        Employee e4 = new Employee(e1); //copy of e1,different id

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4);
        System.out.println("e1 == e4" + (e1 == e4)); //false: seperate objects

    }

}
