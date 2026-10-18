package ru.etu.wikisearch;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchResponseParser {

    public List<SearchResult> parse(String json) throws JsonSyntaxException {
        JsonObject root = JsonParser.parseString(json).getAsJsonObject();
        JsonObject query = root.getAsJsonObject("query");
        if (query == null) {
            return Collections.emptyList();
        }

        JsonArray searchArray = query.getAsJsonArray("search");
        if (searchArray == null) {
            return Collections.emptyList();
        }

        List<SearchResult> results = new ArrayList<>();
        for (JsonElement element : searchArray) {
            JsonObject item = element.getAsJsonObject();
            String title = item.get("title").getAsString();
            long pageId = item.get("pageid").getAsLong();
            String snippet = item.has("snippet") ? item.get("snippet").getAsString() : "";
            results.add(new SearchResult(title, pageId, snippet));
        }
        return results;
    }
}