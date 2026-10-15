import java.util.Arrays;

public class PrintDemo {
    //overloading: same method name,different parameter types
    //called when the arguement is an int
    static void print(int x) {
        System.out.println("int: " + x);
    }

    //called when the arguement is a double
    static void print(double x) {
        System.out.println("double: " + x);
    }

    //called when the arguement is a string
    static void print(String x) {
        System.out.println("String: " + x);
    }
    //called when the arguement is an int array
    static void printt(int[] x){
        System.out.println("int[]:" + Arrays.toString(x));

    }
    public static void main(String[]args){
        print(5);                          //int version chosen
        print(3.14);                       //double version chosen
        print("Hello");                    //string version chosen
        printt(new int[]{1,2,3});          //int[] version chosen
    }
}
