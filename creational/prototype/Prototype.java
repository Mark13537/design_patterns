package creational.prototype;

import java.util.*;

public class Prototype {
    public static void main(String[] args) {
        Application application = new Application();
        application.businessLogic();
    }
}

abstract class Shape {
    int x;
    int y;
    String color;

    Shape() {
        // System.out.println("Regular constructor called");
    }

    Shape(Shape shapeSource) {
        this();
        // System.out.println("Someone called parameterized constructor");
        this.x = shapeSource.x;
        this.y = shapeSource.y;
        this.color = shapeSource.color;
    }

    abstract public Shape clone();
}

class Rectangle extends Shape {

    int height;
    int width;

    Rectangle() {
    }

    Rectangle(Rectangle source) {
        super(source);
        this.width = source.width;
        this.height = source.height;
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }
}

class Circle extends Shape {
    int radius;

    Circle() {
    }

    Circle(Circle source) {
        super(source);
        this.radius = source.radius;
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }
}

// Somewhere in the client code.
class Application {
    List<Shape> shapes = new ArrayList<Shape>();

    Application() {
        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 10;
        circle.radius = 20;
        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        shapes.add(rectangle);

        // for (Shape shape : shapes) {
        // System.out.println(shape.toString());
        // System.out.println("Value of x is " + shape.x);
        // System.out.println("Value of y is " + shape.y);
        // System.out.println("Value of color is " + shape.color);
        // }
    }

    public void businessLogic() {
        List<Shape> shapesCopy = new ArrayList<Shape>();

        for (Shape s : shapes) {
            shapesCopy.add(s.clone());
            System.out.println("Value of x is " + s.x);
            System.out.println("Value of y is " + s.y);
            System.out.println("Value of color is " + s.color);
        }
    }
}
