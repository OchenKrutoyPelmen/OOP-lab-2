package ru.etu.wikisearch;

import java.util.Scanner;

public class ConsoleInput {
    private final Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in, "UTF-8");
    }

    public String readSearchQuery() {
        while (true) {
            System.out.print("Введите поисковый запрос (или 'exit' для выхода): ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                return null;
            }
            if (!input.isEmpty()) {
                System.out.println(input);
                return input;
            }
            System.out.println("Запрос не может быть пустым. Попробуйте снова.");
        }
    }

    public int readResultChoice(int maxNumber) {
        while (true) {
            System.out.printf("Введите номер статьи для открытия (1-%d) или 0 для выхода: ", maxNumber);
            String line = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(line);
                if (choice == 0) {
                    return -1;
                }
                if (choice >= 1 && choice <= maxNumber) {
                    return choice;
                }
                System.out.printf("Некорректный номер. Введите число от 1 до %d.%n", maxNumber);
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите целое число.");
            }
        }
    }

    public void close() {
        scanner.close();
    }
}