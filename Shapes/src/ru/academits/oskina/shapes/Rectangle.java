package ru.academits.oskina.shapes;

public class Rectangle implements Shapes {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getWidth() {
        return Math.max(length, width);
    }

    public double getHeight() {
        return Math.min(length, width);
    }

    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return (width + length) * 2;
    }

    @Override
    public String toString() {
        return "Прямоугольник" + "\n" +
                "Длина первой стороны: " + length + "\n" +
                "Длина первой стороны: " + width + "\n" +
                "Ширина: " + getWidth() + "\n" +
                "Высота: " + getHeight() + "\n" +
                "Периметр: " + getPerimeter() + "\n" +
                "Площадь: " + getArea();
    }

    @Override
    public int hashCode() {
        final int prime = 5;
        int hash = 1;
        hash = prime * hash + Double.hashCode(length);
        hash = prime * hash + Double.hashCode(width);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return length == rectangle.length && width == rectangle.width;
    }
}