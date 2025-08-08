package ru.academits.oskina.shapes_main;

import ru.academits.oskina.shapes_comparators.*;
import ru.academits.oskina.shapes.*;

import java.util.Arrays;

public class Main {
    public static Shape getMaxAreaShape(Shape[] shapes) {
        Arrays.sort(shapes, new ShapeAreaComparator());

        return shapes[shapes.length - 1];
    }

    public static Shape getSecondMaxPerimeter(Shape[] shapes) {
        Arrays.sort(shapes, new ShapePerimeterComparator());

        return shapes[shapes.length - 2];
    }

    public static void main(String[] args) {
        Shape[] shapes = {
                new Square(4.2),
                new Square(3.5),
                new Triangle(20, 3, 13, 20, 4, 6),
                new Rectangle(3, 4),
                new Rectangle(5.4, 1.2),
                new Circle(3.5)
        };

        System.out.printf("""
                Фигура с максимальной площадью: %s
                
                Фигура со вторым по величине периметром: %s
                """, getMaxAreaShape(shapes), getSecondMaxPerimeter(shapes));
    }
}