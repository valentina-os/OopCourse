package ru.academits.oskina.range_main;

import ru.academits.oskina.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Range range = new Range(1.5, 4.5);

        System.out.println("Длина диапазона = " + range.getLength());

        range.setFrom(3);
        System.out.println("Длина нового диапазона = " + range.getLength());
        System.out.println("Начало нового диапазона = " + range.getFrom());

        range.setTo(6.6);
        System.out.println("Длина нового диапазона = " + range.getLength());
        System.out.println("Конец нового диапазона = " + range.getTo());

        System.out.print("Введите число: ");
        double number = scanner.nextDouble();

        if (range.isInside(number)) {
            System.out.println("Указанное число входит в диапазон");
        } else {
            System.out.println("Указанное число не входит в диапазон");
        }

        Range range2 = new Range(2.5, 3.5);

        if (range.getIntersection(range2) == null) {
            System.out.println("Пересечения нет");
        } else {
            System.out.print("Интервал пересечения: ");
            range.getIntersection(range2).printRange();
        }

        Range[] union = range.getUnion(range2);
        System.out.println("Интервал(ы) объединения двух диапазонов: ");
        union[0].printRange();

        if (union[1] != null) {
            union[1].printRange();
        }

        Range[] subtraction = range.getSubtraction(range2);
        System.out.println("Интервал(ы) разности двух диапазонов: ");

        if (subtraction[0] == null && subtraction[1] == null) {
            System.out.println("Интервалов разности нет");
        } else {
            if (subtraction[0] != null) {
                subtraction[0].printRange();
            }

            if (subtraction[1] != null) {
                subtraction[1].printRange();
            }
        }
    }
}