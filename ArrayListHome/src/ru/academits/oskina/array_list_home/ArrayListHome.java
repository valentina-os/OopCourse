package ru.academits.oskina.array_list_home;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListHome {
    public static ArrayList<String> getStringsFromFile(String inputFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        ArrayList<String> lines = new ArrayList<>();

        String line;

        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }

        reader.close();

        return lines;
    }

    public static void removeEvenNumbers(ArrayList<Integer> numbers) {
        for (int i = numbers.size() - 1; i >= 0; --i) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
            }
        }
    }

    public static <T> ArrayList<T> getUniqueElements(ArrayList<T> elements) {
        ArrayList<T> uniqueElements = new ArrayList<>(elements.size());

        for (T element : elements) {
            if (!uniqueElements.contains(element)) {
                uniqueElements.add(element);
            }
        }

        return uniqueElements;
    }

    public static void main(String[] args) {
        try {
            System.out.println("В файле содержатся следующие строки: " + getStringsFromFile("TextDocument.txt"));
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 5, 2, 2, 3, 5));

        removeEvenNumbers(numbers);
        System.out.println("Список, из которого удалили все четные числа: " + numbers);

        System.out.println("Новый список, в котором элементы не повторяются: " + getUniqueElements(numbers));
    }
}