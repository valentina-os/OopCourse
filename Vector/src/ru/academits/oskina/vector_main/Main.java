package ru.academits.oskina.vector_main;

import ru.academits.oskina.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[] vector1Components = {1, 2, 3};
        double[] vector2Components = {1, 2, 3, 7};

        Vector vector1 = new Vector(5, vector1Components);
        Vector vector2 = new Vector(vector2Components);

        System.out.println("Компоненты первого вектора: " + vector1);
        System.out.println("Компоненты второго вектора: " + vector2);
        System.out.println("Размер второго вектора: " + vector2.getSize());
        System.out.println("Проверка на равенство первого вектора второму: " + vector1.equals(vector2));

        vector1.setComponent(3, 7);
        vector1.setN(4);

        System.out.println();
        System.out.println("Повторная проверка на равенство первого вектора второму после внесенных изменений: " + vector1.equals(vector2));

        vector2.setComponent(2, 6);
        vector2.setN(3);

        System.out.println();
        System.out.println("Прибавление к первому вектору второго вектора: " + vector1.getAddition(vector2));
        System.out.println("Вычитание из первого вектора второго вектора: " + vector1.getSubtraction(vector2));

        double scalar = 2;
        System.out.println("Умножение вектора на скаляр = 2: " + vector1.getMultiplicationByScalar(scalar));

        System.out.println("Разворот вектора: " + vector1.getReversal());
        System.out.println("Длина первого вектора: " + vector1.getLength());
        System.out.println();

        Vector vector3 = new Vector(vector1);
        Vector vector4 = new Vector(4);

        double[] vector4Components = {1, 2, 3};
        vector4.setComponents(vector4Components);

        System.out.println("Размерность четвертого вектора: " + vector4.getN());
        System.out.println("При сложении двух векторов, получается вектор с компонентами: " + Vector.getAddition(vector3, vector4));
        System.out.println("При вычитании одного векторов из другого, получается вектор с компонентами: " + Vector.getSubtraction(vector3, vector4));
        System.out.println("При скалярном произведении двух векторов, получается вектор с компонентами: " + Vector.getScalarProduct(vector3, vector4));
    }
}