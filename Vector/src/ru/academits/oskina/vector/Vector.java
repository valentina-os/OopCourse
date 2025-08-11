package ru.academits.oskina.vector;

import java.util.Arrays;

public class Vector {
    private int n;
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException(
                    "Размерность вектора должна быть больше 0. Текущая размерность = " + n);
        }

        this.n = n;
        this.components = new double[n];

        for (int i = 0; i < n; ++i) {
            this.components[i] = 0;
        }
    }

    public Vector(Vector vector) {
        this.n = vector.n;
        this.components = vector.components;
    }

    public Vector(double[] components) {
        if (components.length == 0) {
            throw new IllegalArgumentException(
                    "Массив не может быть пуст. Текущий массив не имеет значений");
        }

        this.n = components.length;
        this.components = components;
    }

    public Vector(int n, double[] components) {
        if (n <= 0) {
            throw new IllegalArgumentException(
                    "Размерность вектора должна быть больше 0. Текущая размерность = " + n);
        }

        this.n = n;

        if (components.length < n) {
            this.components = new double[n];

            for (int i = 0; i < n; ++i) {
                if (i < components.length) {
                    this.components[i] = components[i];
                } else {
                    this.components[i] = 0;
                }
            }
        } else {
            this.components = new double[n];
            System.arraycopy(components, 0, this.components, 0, n);
        }
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException(
                    "Размерность вектора должна быть больше 0. Текущая размерность = " + n);
        }

        this.n = n;
        double[] newComponents = new double[n];

        if (components.length < n) {
            for (int i = 0; i < n; ++i) {
                if (i < components.length) {
                    newComponents[i] = components[i];
                } else {
                    newComponents[i] = 0;
                }
            }
        } else {
            System.arraycopy(this.components, 0, newComponents, 0, n);
        }

        this.components = newComponents;
    }

    public double[] getComponents() {
        return components;
    }

    public void setComponents(double[] components) {
        if (components.length == 0) {
            throw new IllegalArgumentException(
                    "Массив не может быть пуст. Текущий массив не имеет значений");
        }

        this.components = components;
        this.n = components.length;
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.components);
    }

    public Vector getAddition(Vector vector) {
        for (int i = 0; i < this.n; ++i) {
            if (i > vector.n - 1) {
                return new Vector(this.n, this.components);
            }

            this.components[i] = this.components[i] + vector.components[i];
        }

        return new Vector(this.n, this.components);
    }

    public Vector getSubtraction(Vector vector) {
        for (int i = 0; i < this.n; ++i) {
            if (i > vector.n - 1) {
                return new Vector(this.n, this.components);
            }

            this.components[i] = this.components[i] - vector.components[i];
        }

        return new Vector(this.n, this.components);
    }

    public Vector getMultiplicationByScalar(double scalar) {
        for (int i = 0; i < this.n; ++i) {
            this.components[i] = this.components[i] * scalar;
        }

        return new Vector(this.n, this.components);
    }

    public Vector getReversal() {
        for (int i = 0; i < this.n; ++i) {
            this.components[i] = this.components[i] * -1;
        }

        return new Vector(this.n, this.components);
    }

    public double getLength() {
        double length = 0;

        for (int i = 0; i < this.n; ++i) {
            length = length + this.components[i] * this.components[i];
        }

        return Math.pow(length, 2);
    }

    public double getComponent(int index) {
        return components[index];
    }

    public void setComponent(int index, double component) {
        this.components[index] = component;
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
        return n == vector.n && Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + n;

        for (int i = 0; i <= n; ++i) {
            hash = prime * hash + Double.hashCode(components[i]);
        }

        return hash;
    }

    public static Vector getAddition(Vector vector1, Vector vector2) {
        int additionN = Math.max(vector1.n, vector2.n);
        double[] additionComponents = new double[additionN];

        for (int i = 0; i < additionN; ++i) {
            if (i >= vector2.n) {
                additionComponents[i] = vector1.components[i];
            } else if (i >= vector1.n) {
                additionComponents[i] = vector2.components[i];
            } else {
                additionComponents[i] = vector1.components[i] + vector2.components[i];
            }
        }

        return new Vector(additionN, additionComponents);
    }

    public static Vector getSubtraction(Vector vector1, Vector vector2) {
        int subtractionN = Math.max(vector1.n, vector2.n);
        double[] subtractionComponents = new double[subtractionN];

        for (int i = 0; i < subtractionN; ++i) {
            if (i >= vector2.n) {
                subtractionComponents[i] = vector1.components[i];
            } else if (i >= vector1.n) {
                subtractionComponents[i] = vector2.components[i] * -1;
            } else {
                subtractionComponents[i] = vector1.components[i] - vector2.components[i];
            }
        }

        return new Vector(subtractionN, subtractionComponents);
    }

    public static Vector getScalarProduct(Vector vector1, Vector vector2) {
        int scalarProductN = Math.max(vector1.n, vector2.n);
        double[] scalarProductComponents = new double[scalarProductN];

        for (int i = 0; i < scalarProductN; ++i) {
            if (i >= vector2.n || i >= vector1.n) {
                scalarProductComponents[i] = 0;
            } else {
                scalarProductComponents[i] = vector1.components[i] * vector2.components[i];
            }
        }

        return new Vector(scalarProductN, scalarProductComponents);
    }
}