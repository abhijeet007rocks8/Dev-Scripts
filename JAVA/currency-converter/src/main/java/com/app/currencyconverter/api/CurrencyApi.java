package com.app.currencyconverter.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpRequest;
import java.util.*;

public class CurrencyApi {

    /*
     *  This function fetches all symbol-country pairs from the API
     *  Returns a map of the data
     */
    public static Map<String, String> getSymbolNames() throws IOException {
        // Create the connection
        URL url = URLBuilder.buildSymbolNamesURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        // Fetch the data
        StringBuilder data = new StringBuilder();
        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNext()){
            data.append(scanner.nextLine());
        }

        // Parse raw strings into JSON
        JSONObject jsonObject = new JSONObject(data.toString());
        JSONObject symbols = jsonObject.getJSONObject("symbols");

        // Convert to map (This would ensure O(1) time complexity and sorted keys)
        Map<String, String> symbolNames = new TreeMap<>();
        symbols.keySet().forEach(symbol -> {
            symbolNames.put(symbol, symbols.getString(symbol));
        });

        return symbolNames;
    }

    public static double getExchangeData(String base, String desired) throws IOException {
        // Create the connection
        URL url = URLBuilder.buildExchangeRatesURL(base);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        // Fetch the data
        StringBuilder data = new StringBuilder();
        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNext()){
            data.append(scanner.nextLine());
        }

        // Parse raw strings into JSON
        JSONObject jsonObject = new JSONObject(data.toString());
        JSONObject rates = jsonObject.getJSONObject("data");

        return rates.getDouble(desired);
    }

}
