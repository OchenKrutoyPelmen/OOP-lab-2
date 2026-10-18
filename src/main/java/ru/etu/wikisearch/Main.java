package ru.etu.wikisearch;

import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        WikipediaApiClient apiClient = new WikipediaApiClient();

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



            }


        } finally {
            input.close();
        }
    }
}