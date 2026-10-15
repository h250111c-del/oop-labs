public class Person {
    String name;
    Adress adress;
    //Person Has An Adress

    public static void main(String[] args){
        Person p1 = new Person();
        p1.name = "Tendai";
        p1.adress = new Adress();
        p1.adress.city = "Harare";
        //chained dot expression
        System.out.println(p1.adress.city);//works:prints Harare

        Person p2 = new Person();
        p2.name = "Rudo";
        p2.adress = null;
        //no adress set
        //This will CRASH
        //system.out.println(p2.adress .city);
    //->Null pointerException:cannot read field"city" because"p2.adress"is null
    }
}