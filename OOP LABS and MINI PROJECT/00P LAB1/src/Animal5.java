public class Animal5 {
    String name;
    //Only a constructor with a parameter: Java does NOT create a default one
    Animal5(String name){
        this.name=name;
    }
}
//FAILS TO COMPLETE
//Class Dod5 extends Animal5{
//Dod5() //Java inserts super() automatically,nut Animal5 has no
//}             //no-arguement constructor->compile error
//FIX: Call the Animal5 constructor yourself with super(name)
class Dog5 extends Animal5{
    Dog5(String name){
        super(name); //must be the first statement
    }
}
class Animal5Demo{
    public static void main(String[] args){
        Dog5 d = new Dog5( "Tiger");
        System.out.println("Dog name:" + d.name ); //Dog name:Tiger
    }
}
