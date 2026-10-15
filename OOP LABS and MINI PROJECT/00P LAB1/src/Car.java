public class Car {
    String brand;
    int year;
    int mileage;

    void display() {
        System.out.println(brand + " - " + year + " - " + mileage + "km" + " Antique: " + isAntique());
    }
    boolean isAntique(){
        int currentYear = 2026;
        return (currentYear-year) > 25;
    }


    public static void main(String[] args) {
        Car c1 = new Car();
        c1.brand = "Toyota";
        c1.year = 1999;
        c1.mileage = 7697000;

        Car c2 = new Car();
        c2.brand = "BMW";
        c2.year = 2020;
        c2.mileage = 30000;

        Car c3 = new Car();
        c3.brand = "Honda";
        c3.year = 2008;
        c3.mileage = 150000;

        c1.display();
        c2.display();
        c3.display();
    }
}


