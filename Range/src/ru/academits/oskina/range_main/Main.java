package ru.academits.oskina.range_main;

import ru.academits.oskina.range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Range range = new Range(5.5, 9.5);

        System.out.println("Длина диапазона = " + range.getLength());

        range.setFrom(1.5);
        System.out.println("Длина нового диапазона = " + range.getLength());
        System.out.println("Начало нового диапазона = " + range.getFrom());

        range.setTo(3.5);
        System.out.println("Длина нового диапазона = " + range.getLength());
        System.out.println("Конец нового диапазона = " + range.getTo());

        System.out.print("Введите число: ");
        double number = scanner.nextDouble();

        if (range.isInside(number)) {
            System.out.println("Указанное число входит в диапазон");
        } else {
            System.out.println("Указанное число не входит в диапазон");
        }

        Range range2 = new Range(1.5, 3.5);

        if (range.getIntersection(range2) == null) {
            System.out.println("Пересечения нет");
        } else {
            System.out.println("Интервал пересечения: " + range.getIntersection(range2));
        }

        Range[] union = range.getUnion(range2);
        System.out.println("Интервал(ы) объединения двух диапазонов: " + Arrays.toString(union));

        Range[] difference = range.getDifference(range2);
        System.out.print("Интервал(ы) разности двух диапазонов: ");

        if (difference.length == 0) {
            System.out.print("интервалов разности нет");
        } else {
            System.out.print(Arrays.toString(difference));
        }
    }
}