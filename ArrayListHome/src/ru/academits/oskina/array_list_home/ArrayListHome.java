package ru.academits.oskina.array_list_home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> text = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream("TextDocument.txt"))) {
            while (scanner.hasNextLine()) {
                text.add(scanner.nextLine());
            }

            System.out.println(text);
        }

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5));

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(numbers.get(i));
            }
        }

        System.out.println("Список, из которого удалили все четные числа: " + numbers);

        ArrayList<Integer> uniqueNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            if (!uniqueNumbers.contains(number)) {
                uniqueNumbers.add(number);
            }
        }

        System.out.println("Новый список, в котором элементы не повторяются: " + uniqueNumbers);
    }
}