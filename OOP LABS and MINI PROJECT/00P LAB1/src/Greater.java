// English.java
 interface English {
    default void hello() {
        System.out.println("Hello from English!");
    }
}

// Shona.java
interface Shona {
    default void hello() {
        System.out.println("Mhoro from Shona!");
    }
}

// Greeter.java
class Greeter implements English, Shona {

    // Required: without this override, the class will not compile
    @Override
    public void hello() {
        English.super.hello();   // call English's version
        Shona.super.hello();     // call Shona's version
        System.out.println("Hello from Greeter itself!");
    }
}

// Main.java
class GreaterDemo {
    public static void main(String[] args) {
        Greeter g = new Greeter();
        g.hello();
    }
}
