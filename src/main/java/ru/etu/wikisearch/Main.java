package ru.etu.wikisearch;

import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        WikipediaApiClient apiClient = new WikipediaApiClient();
        SearchResponseParser parser = new SearchResponseParser();
        ResultPrinter printer = new ResultPrinter();

        try {
            while (true) {
                String query = input.readSearchQuery();
                if (query == null) {
                    System.out.println("До свидания!");
                    break;
                }

                String json;
                try {
                    json = apiClient.search(query);
                } catch (IOException e) {
                    System.err.println("Ошибка при обращении к серверу Википедии: " + e.getMessage());
                    continue;
                }

                List<SearchResult> results;
                try {
                    results = parser.parse(json);
                } catch (JsonSyntaxException e) {
                    System.err.println("Не удалось разобрать ответ сервера. Попробуйте позже.");
                    continue;
                }

                printer.print(results);
                if (results.isEmpty()) {
                    continue;
                }

            }


        } finally {
            input.close();
        }
    }
}