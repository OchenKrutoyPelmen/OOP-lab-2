package ru.etu.wikisearch;

import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();

        try {
            while (true) {
                String query = input.readSearchQuery();
                if (query == null) {
                    System.out.println("До свидания!");
                    break;
                }
            }


        } finally {
            input.close();
        }
    }
}