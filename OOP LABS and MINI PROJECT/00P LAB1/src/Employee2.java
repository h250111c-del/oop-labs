import java.awt.*;
 public class Employee2 {
    private String name;
    private double baseSalary;

    public Employee2(String name,double baseSalary){
        this.name =name;
        this.baseSalary= baseSalary;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
    // Subclasses override this to change how pay is worked out
    public double calculatePay(){
        return baseSalary;
    }
}
//Existing subclass: salary plus a bonus
class Manager extends Employee2{
    private double bonus;

    public Manager(String name,double baseSalary,double bonus){
        super(name, baseSalary);
        this.bonus = bonus;
    }
    @Override
    public double calculatePay(){
        return getBaseSalary() + bonus;
    }
}

class Intern extends Employee2{
    private double hourlyRate;
    private int hoursWorked;

    public Intern(String name, double hourlyRate,int hoursWorked){
        super(name, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    @Override
    public double calculatePay(){
        return hourlyRate*hoursWorked;
    }
}
class PayrollDemo{
    public static void main(String[] args){
        Employee2[] staff ={
                new Employee2("Tapiwa",1000),
                new Manager("Viola",2000,500),
                new Intern("Faith",200,30),
        };
        double total=0;
        for(Employee2 e : staff){
            double pay =e.calculatePay();  //the actual object's version runs
            System.out.println(e.getName() + ":" + pay);
            total += pay;
        }
        System.out.println("Total payroll:" + total);
    }
}
