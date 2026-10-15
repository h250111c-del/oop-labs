public class Base {
    String name = "Base field";
    void show(){
        System.out.println("Base method");
    }
}
class Derived extends Base{
    String name ="Derived field"; //hides the field (does not override it)

    @Override
    void show(){
        System.out.println("Derived method");
    }
}
class FieldVsMethod{
    public static void main(String[] args){
        Base b = new Derived();  //superclass reference ,subclass object

        b.show();   //method:Derived method
        System.out.println(b.name);  //field:Base field
        System.out.println(((Derived)b).name); //cast: Derived field
    }
}
