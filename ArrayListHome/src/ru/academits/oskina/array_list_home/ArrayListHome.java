package ru.academits.oskina.array_list_home;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListHome {
    public static ArrayList<String> getFileToList(String inPutFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inPutFile));

        ArrayList<String> lines = new ArrayList<>();

        String line;

        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }

        return lines;
    }

    public static void removeEvenNumbers(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);

                --i;
            }
        }
    }

    public static ArrayList<Integer> getUniqueNumbers(ArrayList<Integer> numbers) {
        ArrayList<Integer> uniqueNumbers = new ArrayList<>(numbers.size());

        for (Integer number : numbers) {
            if (!uniqueNumbers.contains(number)) {
                uniqueNumbers.add(number);
            }
        }

        return uniqueNumbers;
    }

    public static void main(String[] args) {
        try {
            System.out.println("В файле содержатся следующие строки: " + getFileToList("TextDocument.txt"));
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 5, 2, 2, 3, 5));

        removeEvenNumbers(numbers);
        System.out.println("Список, из которого удалили все четные числа: " + numbers);

        System.out.println("Новый список, в котором элементы не повторяются: " + getUniqueNumbers(numbers));
    }
}