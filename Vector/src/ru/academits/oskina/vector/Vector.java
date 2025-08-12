package ru.academits.oskina.vector;

import java.util.Arrays;

public class Vector {
    private final double[] components;

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
        return Arrays.toString(components).replace("[", "{").replace("]", "}");
    }

    public Vector getAmount(Vector vector) {
        for (int i = 0; i < Math.min(this.components.length, vector.components.length); ++i) {
            this.components[i] += vector.components[i];
        }

        return this;
    }

    public Vector getDifference(Vector vector) {
        for (int i = 0; i < Math.min(this.components.length, vector.components.length); ++i) {
            this.components[i] -= vector.components[i];
        }

        return this;
    }

    public Vector getProductByScalar(double scalar) {
        for (int i = 0; i < components.length; ++i) {
            components[i] *= scalar;
        }

        return this;
    }

    public Vector getReversal() {
        return getProductByScalar(-1);
    }

    public double getModule() {
        double module = 0;

        for (double component : components) {
            module = module + component * component;
        }

        return Math.sqrt(module);
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

    public static Vector getAddition(Vector vector1, Vector vector2) {
        return new Vector(vector1.getAmount(vector2));
    }

    public static Vector getSubtraction(Vector vector1, Vector vector2) {
        return new Vector(vector1.getDifference(vector2));
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;

        for (int i = 0; i < Math.min(vector1.getSize(), vector2.getSize()); ++i) {
            scalarProduct += vector1.components[i] * vector2.components[i];
        }

        return scalarProduct;
    }
}