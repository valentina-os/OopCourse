package ru.academits.oskina.shapes_main;

import ru.academits.oskina.shapes.*;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static class AreaComparator implements Comparator<Shapes> {
        @Override
        public int compare(Shapes shape1, Shapes shape2) {
            return (int) Math.round(shape1.getArea() - shape2.getArea());
        }
    }

    public static Shapes getMaxAreaShape(Shapes[] shapes) {
        Arrays.sort(shapes, new AreaComparator());

        return shapes[shapes.length - 1];
    }

    public static class PerimeterComparator implements Comparator<Shapes> {
        @Override
        public int compare(Shapes shape1, Shapes shape2) {
            return (int) Math.round(shape1.getPerimeter() - shape2.getPerimeter());
        }
    }

    public static Shapes getShapeWithSecondLargestPerimeter(Shapes[] shapes) {
        Arrays.sort(shapes, new PerimeterComparator());

        int i = shapes.length - 1;

        while (i > 0) {
            if (shapes[i - 1].getPerimeter() < shapes[i].getPerimeter()) {
                return shapes[i - 1];
            }

            --i;
        }

        return shapes[shapes.length - 1];
    }

    public static void main(String[] args) {
        Shapes[] shapes = {new Square(4.2),
                new Square(3.5),
                new Triangle(20, 3, 13, 20, 4, 6),
                new Rectangle(3, 4),
                new Rectangle(5.4, 1.2),
                new Circle(3.5)};

        System.out.printf("""
                Фигура с максимальной площадью: %s
                
                Фигура со вторым по величине периметром: %s
                """, getMaxAreaShape(shapes), getShapeWithSecondLargestPerimeter(shapes));
    }
}