public class Animal {
    public void sound(){
        System.out.println("Some generic animal sound");
    }
}
//Each subclass overrides sound () with its own behaviour
class Cat extends Animal{
    @Override    //checks that we really are overriding the superclass method
    public void sound() {
        System.out.println("Meow");
    }
}
class Cow extends Animal{
    @Override
    public void sound(){
        System.out.println("Mooo");
    }
}
class Duck extends Animal{
    @Override
    public void sound(){
        System.out.println("Quack");
    }
}
class AnimalDemo{
    public static void main(String[] args){
        //One array of the superclass type can hold any subclass object
        Animal[] animals = {new Cat(), new Cow(), new Duck()};

        for (Animal a : animals){
            a.sound();  //runtime type decides which version runs(polymorphism)
        }
    }
}
