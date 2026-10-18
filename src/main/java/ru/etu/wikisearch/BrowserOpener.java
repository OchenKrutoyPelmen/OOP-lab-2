package ru.etu.wikisearch;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class BrowserOpener {

    public boolean openArticle(long pageId) {
        if (!Desktop.isDesktopSupported()) {
            System.err.println("Открытие браузера не поддерживается в текущей среде.");
            return false;
        }

        Desktop desktop = Desktop.getDesktop();
        if (!desktop.isSupported(Desktop.Action.BROWSE)) {
            System.err.println("Система не поддерживает открытие URL в браузере.");
            return false;
        }

        String url = "https://ru.wikipedia.org/w/index.php?curid=" + pageId;
        try {
            desktop.browse(new URI(url));
            return true;
        } catch (IOException | URISyntaxException e) {
            System.err.println("Не удалось открыть браузер: " + e.getMessage());
            return false;
        }
    }
}