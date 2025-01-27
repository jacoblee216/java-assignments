package geometric;
import java.util.Scanner;

public class triangle extends GeometricObject{  
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;
    public triangle() {
    }
    public triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public double getSide1() {
        return side1;
    }
    public double getSide2() {
        return side2;
    }
    public double getSide3() {
        return side3;
    }
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
    public static void main(String[] args) {
        System.out.println("Give me the lengths of 3 sides of a triangle: ");
        Scanner input = new Scanner(System.in);
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();
        triangle myTriangle = new triangle(side1, side2, side3);
        System.out.println("The area of your triangle is: " + myTriangle.getArea());
        System.out.println("The perimeter of your triangle is: " + myTriangle.getPerimeter());
        System.out.println("Give me a color for your triangle: ");
        String color = input.next();
        myTriangle.setColor(color);
        System.out.println("The color of your triangle is: " + myTriangle.getColor());
        System.out.println("Is your triangle filled? ( True / False ): ");
        boolean filled = input.nextBoolean();
        myTriangle.setFilled(filled);
        if (filled == true) {
            System.out.println("Your triangle is filled.");
        } else {
            System.out.println("Your triangle is not filled.");
        }
        input.close();
    }
}
