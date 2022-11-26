package test;
import test.test2.Shape;
public class test {
    public static class  Point{}



    public static class Circle extends Shape {}
    public static class Rectangle extends Shape{}
    public static class Triangle extends Shape{}

    public static void main(String[] args) {
        Shape shape = new Shape();
        Circle circle = new Circle();
        circle.Arr[0] = 10;
        System.out.println(shape.Arr[0]);
        circle.add();
        System.out.println(shape.getVar1());
    }
}
