public class Vehicle4 {
    Vehicle4(){
        System.out.println("1. Vehicle constructor");
    }
}
class Car4 extends Vehicle4{
    Car4(){
        //Java inserts super()here automatically, so Vehicle4 runs first
        System.out.println("3. ElectricCar constructor");
    }
}
class ElectricCar4 extends  Car4{
    ElectricCar4(){
        //Java inserts super () here automatically,so Vehicle4 runs next
        System.out.println("3. ElectricCar constructor");
    }
}
class ConstructorOrder{
    public static void main(String[] args){
        new ElectricCar4();
    }
}