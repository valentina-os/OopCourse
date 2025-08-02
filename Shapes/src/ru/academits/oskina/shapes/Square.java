package ru.academits.oskina.shapes;

public class Square implements Shapes {
    private final double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getWidth() {
        return sideLength;
    }

    public double getHeight() {
        return sideLength;
    }

    public double getArea() {
        return sideLength * sideLength;
    }

    public double getPerimeter() {
        return sideLength * 4;
    }

    @Override
    public String toString() {
        return "Квадрат" + "\n" +
                "Длина стороны: " + sideLength + "\n" +
                "Ширина: " + getWidth() + "\n" +
                "Высота: " + getHeight() + "\n" +
                "Периметр: " + getPerimeter() + "\n" +
                "Площадь: " + getArea() + "\n";
    }

    @Override
    public int hashCode() {
        final int prime = 5;
        int hash = 1;
        hash = prime * hash + Double.hashCode(sideLength);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Square square = (Square) o;
        return sideLength == square.sideLength;
    }
}