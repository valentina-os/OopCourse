package ru.academits.oskina.range_main;

import ru.academits.oskina.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Range range = new Range(1.1, 3.1);

        System.out.println("Длина диапазона = " + range.getRangeLength(range));

        range.setFrom(3);
        System.out.println("Длина нового диапазона = " + range.getRangeLength(range));
        System.out.println("Начало нового диапазона = " + range.getFrom());

        range.setTo(6.6);
        System.out.println("Длина нового диапазона = " + range.getRangeLength(range));
        System.out.println("Конец нового диапазона = " + range.getTo());

        System.out.print("Введите число: ");
        double number = scanner.nextDouble();

        if (range.isInside(number)) {
            System.out.println("Указанное число входит в диапазон");
        } else {
            System.out.println("Указанное число не входит в диапазон");
        }
    }
}