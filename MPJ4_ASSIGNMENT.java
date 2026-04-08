// Part 1: Shapes (Constructor + Method Overloading)

class Shapes {

    double area;

    // Constructor Overloading
    Shapes(double radius) {
        area = Math.PI * radius * radius;
        System.out.println("Circle area is: " + area);   // changed
    }

    Shapes(double length, double breadth) {
        area = length * breadth;
        System.out.println("Rectangle area is: " + area);  // changed
    }

    Shapes(int side) {
        area = side * side;
        System.out.println("Area of Square: " + area);
    }

    // Method Overloading
    void calculateArea(double radius) {
        System.out.println("Computed Circle Area: " + (Math.PI * radius * radius)); // changed
    }

    void calculateArea(double length, double breadth) {
        System.out.println("Rectangle Area (method): " + (length * breadth));
    }

    void calculateArea(int side) {
        System.out.println("Square Area (method): " + (side * side));
    }
}


// Part 2: Hillstations (Method Overriding)

class Hillstations {

    void famousfood() {
        System.out.println("Popular food in hill stations"); // changed
    }

    void famousfor() {
        System.out.println("Known for natural beauty"); // changed
    }
}

// Subclass 1
class Manali extends Hillstations {

    @Override
    void famousfood() {
        System.out.println("Manali is popular for Siddu"); // changed
    }

    @Override
    void famousfor() {
        System.out.println("Manali is known for snowy mountains"); // changed
    }
}

// Subclass 2
class Mahabaleshwar extends Hillstations {

    @Override
    void famousfood() {
        System.out.println("Mahabaleshwar is famous for strawberries");
    }

    @Override
    void famousfor() {
        System.out.println("Mahabaleshwar is known for scenic viewpoints"); // changed
    }
}

// Subclass 3
class Ooty extends Hillstations {

    @Override
    void famousfood() {
        System.out.println("Ooty is well known for chocolates"); // changed
    }

    @Override
    void famousfor() {
        System.out.println("Ooty is famous for tea gardens");
    }
}


// Main Class

public class MPJ4_ASSIGNMENT {
    public static void main(String[] args) {

        System.out.println("----- SHAPES DEMO (OVERLOADING) -----"); // changed

        // Constructor Overloading
        Shapes s1 = new Shapes(5.0);
        Shapes s2 = new Shapes(4.0, 6.0);
        Shapes s3 = new Shapes(4);

        System.out.println();

        // Method Overloading
        s1.calculateArea(3.0);
        s1.calculateArea(5.0, 2.0);
        s1.calculateArea(6);

        System.out.println("\n----- HILL STATIONS DEMO (OVERRIDING) -----"); // changed

        Hillstations h;

        // Runtime Polymorphism
        h = new Manali();
        h.famousfood();
        h.famousfor();

        System.out.println();

        h = new Mahabaleshwar();
        h.famousfood();
        h.famousfor();

        System.out.println();

        h = new Ooty();
        h.famousfood();
        h.famousfor();
    }
}