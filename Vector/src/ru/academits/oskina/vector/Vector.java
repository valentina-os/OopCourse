package ru.academits.oskina.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int dimension) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше 0. Текущая размерность = " + dimension);
        }

        this.components = new double[dimension];
    }

    public Vector(Vector vector) {
        this.components = Arrays.copyOf(vector.components, vector.getSize());
    }

    public Vector(double[] components) {
        if (components.length == 0) {
            throw new IllegalArgumentException("Массив не может быть пуст. Текущий массив не имеет значений");
        }

        this.components = Arrays.copyOf(components, components.length);
    }

    public Vector(int dimension, double[] components) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше 0. Текущая размерность = " + dimension);
        }

        this.components = Arrays.copyOf(components, dimension);
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        return String.format(""" 
                {%s}
                """, Arrays.toString(components).substring(1, Arrays.toString(components).length() - 1));
    }

    public void add(Vector vector) {
        int newSize = Math.max(this.components.length, vector.components.length);
        double[] newComponents = new double[newSize];

        for (int i = 0; i < newSize; ++i) {
            if (i >= vector.components.length) {
                newComponents[i] = this.components[i];
            } else if (i >= this.components.length) {
                newComponents[i] = vector.components[i];
            } else {
                newComponents[i] = this.components[i] + vector.components[i];
            }
        }

        this.components = newComponents;
    }

    public void subtract(Vector vector) {
        int newSize = Math.max(this.components.length, vector.components.length);
        double[] newComponents = new double[newSize];

        for (int i = 0; i < newSize; ++i) {
            if (i >= vector.components.length) {
                newComponents[i] = this.components[i];
            } else if (i >= this.components.length) {
                newComponents[i] = -vector.components[i];
            } else {
                newComponents[i] = this.components[i] - vector.components[i];
            }
        }

        this.components = newComponents;
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < components.length; ++i) {
            components[i] *= scalar;
        }
    }

    public void revers() {
        multiplyByScalar(-1);
    }

    public double getLength() {
        double squaredComponentsSum = 0;

        for (double component : components) {
            squaredComponentsSum += component * component;
        }

        return Math.sqrt(squaredComponentsSum);
    }

    public double getComponent(int index) {
        return components[index];
    }

    public void setComponent(int index, double component) {
        components[index] = component;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Vector vector = (Vector) o;
        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector sum = new Vector(vector1);
        sum.add(vector2);
        return sum;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector difference = new Vector(vector1);
        difference.subtract(vector2);
        return difference;
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;

        for (int i = 0; i < Math.min(vector1.getSize(), vector2.getSize()); ++i) {
            scalarProduct += vector1.components[i] * vector2.components[i];
        }

        return scalarProduct;
    }
}