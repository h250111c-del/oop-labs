public class Temperature {
    private final double celsius;  //always stored in Celsius
    //private constructor: outside code cannot call new Temperature(...)
    private Temperature(double celsius){
        if (celsius< -273.15){
            throw new IllegalArgumentException("Below absolute zero:" + celsius);

        }
        this.celsius = celsius;
    }
    //static factory: the name says what the number means
    public static Temperature fromCelsius(double c){
        return new Temperature(c);
    }
    //static factory: converts Fahrenheit to celsius first
    public static Temperature fromFahrenheit(double f){
        return new Temperature((f-32)*5/9);
    }

    public double getCelsius() {
        return celsius ;
    }
    public double getFahrenheit(){
        return celsius * 9 / 5 + 32;
    }
    @Override
    public String toString(){
        return String.format("%.1f C = %.1f F" , getCelsius(),getFahrenheit());
    }
    public static void main(String[]args){
        Temperature t1 = Temperature.fromCelsius(25);
        Temperature t2 = Temperature.fromFahrenheit(212);
        System.out.println(t1);
        System.out.println(t2);
    }


}
