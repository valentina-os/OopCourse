package ru.academits.oskina.range_main;

import ru.academits.oskina.range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Range range1 = new Range(1, 4);

        System.out.println("Длина диапазона = " + range1.getLength());

        range1.setFrom(1);
        System.out.println("Длина нового диапазона = " + range1.getLength());
        System.out.println("Начало нового диапазона = " + range1.getFrom());

        range1.setTo(4);
        System.out.println("Длина нового диапазона = " + range1.getLength());
        System.out.println("Конец нового диапазона = " + range1.getTo());

        System.out.print("Введите число: ");
        double number = scanner.nextDouble();

        if (range1.isInside(number)) {
            System.out.println("Указанное число входит в диапазон");
        } else {
            System.out.println("Указанное число не входит в диапазон");
        }

        Range range2 = new Range(4, 8);

        Range intersection = range1.getIntersection(range2);

        if (intersection == null) {
            System.out.println("Пересечения нет");
        } else {
            System.out.println("Интервал пересечения: " + intersection);
        }

        Range[] union = range1.getUnion(range2);
        System.out.println("Интервал(ы) объединения двух диапазонов: " + Arrays.toString(union));

        Range[] difference = range1.getDifference(range2);
        System.out.print("Интервал(ы) разности двух диапазонов: " + Arrays.toString(difference));
    }
}