package ru.etu.wikisearch;

import java.util.List;

public class ResultPrinter {

    public void print(List<SearchResult> results) {
        if (results.isEmpty()) {
            System.out.println("По вашему запросу ничего не найдено.");
            return;
        }

        System.out.println("\nРезультаты поиска:");
        for (int i = 0; i < results.size(); i++) {
            SearchResult result = results.get(i);
            System.out.printf("%d. %s%n", i + 1, result.getTitle());
        }
        System.out.println();
    }
}