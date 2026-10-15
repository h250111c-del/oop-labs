public class InitOrder {
    //Field initializer: runs as part of instance initialisation in written order
    int value= log("instance field");
    static {
        System.out.println("static block 1");
    }
    {
        System.out.println("instance block 1");
    }
    static {
        System.out.println("static block 2");
    }
    {
        System.out.println("instance block 2");
    }
    public InitOrder(){
        System.out.println("constructor"); //runs After the instance parts
    }
    static int log(String message){
        System.out.println(message);
        return 0;
    }
    public static void main(String[]args){
        System.out.println("---first object---");
        new InitOrder();
        System.out.println("---second object---");
        new InitOrder();
    }
}
