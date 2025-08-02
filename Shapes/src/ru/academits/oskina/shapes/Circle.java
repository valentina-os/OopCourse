package ru.academits.oskina.shapes;

public class Circle implements Shapes {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getWidth() {
        return radius * 2;
    }

    public double getHeight() {
        return radius * 2;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Окружность" + "\n" +
                "Длина радиуса: " + radius + "\n" +
                "Ширина: " + getWidth() + "\n" +
                "Высота: " + getHeight() + "\n" +
                "Периметр: " + getPerimeter() + "\n" +
                "Площадь: " + getArea();
    }

    @Override
    public int hashCode() {
        final int prime = 5;
        int hash = 1;
        hash = prime * hash + Double.hashCode(radius);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius;
    }
}