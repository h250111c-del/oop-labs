// Shape.java
public abstract class Shape {
    public abstract double area();
    public abstract double perimeter();

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + " [area=" + String.format("%.2f", area())
                + ", perimeter=" + String.format("%.2f", perimeter()) + "]";
    }
}

// Circle.java
class Circle2 extends Shape {
    private final double radius;

    public Circle2(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

// Rectangle.java
class Rectangle2 extends Shape {
    protected final double length;
    protected final double width;

    public Rectangle2(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

// Square.java
 class Square extends Rectangle2 {
    public Square(double side) {
        super(side, side);
    }
}

// Main.java
class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle2(5),
                new Rectangle2(4, 6),
                new Square(3)
        };

        for (Shape s : shapes) {
            System.out.println(s);
        }
    }
}
