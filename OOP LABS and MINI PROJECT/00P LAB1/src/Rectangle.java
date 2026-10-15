public class Rectangle {
    double width;
    double height;


    double area() {
        return width * height;
    }

    double perimeter() {
        return 2 * (width + height);
    }


    public static void main(String[] args) {
        Rectangle[] rects = new Rectangle[5];
        //create 5 rectangles
        for (int i = 0; i < 5; i++) {
            rects[i] = new Rectangle();
            rects[i].width = i + 2;
            rects[i].height = i + 3;
        }
        Rectangle largest = rects[0];
        for (Rectangle r : rects) {
            if (r.area() > largest.area()) {
                largest = r;
            }
        }
        System.out.println("Largest area:" + largest.area());
        Rectangle r1 = new Rectangle();
        r1.width = 10;
        r1.height = 5;

        Rectangle r2 = r1; //Not a copy!
        r2.width = 99;
        System.out.println(r1.width); //what prints ?
    }
}