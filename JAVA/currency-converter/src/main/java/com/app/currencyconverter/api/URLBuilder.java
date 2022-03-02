package com.app.currencyconverter.api;

import java.net.MalformedURLException;
import java.net.URL;

public class URLBuilder {

    private static final String FIXER_ACCESS_KEY = "58f722e28cdf44dda44ba2605745c49f";
    private static final String FIXER_BASE_URL = "http://data.fixer.io/api/";
    private static final String FCA_BASE_URL = "https://freecurrencyapi.net/api/v2/latest";
    private static final String FCA_ACCESS_KEY = "7ee0abc0-9a22-11ec-9752-3728e0a90139";

    public static URL buildSymbolNamesURL() throws MalformedURLException {
        return new URL(String.format("%s%s?access_key=%s", FIXER_BASE_URL, "symbols", FIXER_ACCESS_KEY));
    }

    public static URL buildExchangeRatesURL(String base) throws MalformedURLException {
        return new URL(String.format("%s?apikey=%s&base_currency=%s", FCA_BASE_URL, FCA_ACCESS_KEY, base));
    }

}
