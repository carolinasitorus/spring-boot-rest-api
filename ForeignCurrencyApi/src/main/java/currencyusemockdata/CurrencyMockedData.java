package currencyusemockdata;

import java.util.ArrayList;
import java.util.List;

public class CurrencyMockedData {
    private List<Currency> currencies;

    private static CurrencyMockedData instance = null;
    public static CurrencyMockedData getInstance(){
        if(instance == null){
            instance = new CurrencyMockedData();
        }
        return instance;
    }

    public CurrencyMockedData(){
        currencies = new ArrayList<Currency>();
        currencies.add(new Currency(1, "IDR",
                "Indonesia Rupiah"));
        currencies.add(new Currency(2, "USD",
                "US Dollar"));
        currencies.add(new Currency(3, "EUR",
                "Euro"));
        currencies.add(new Currency(4, "CAD",
                "Canadian Dollar"));
        currencies.add(new Currency(5, "GBP",
                "Pound Sterling"));
    }

    public List<Currency> fetchCurrencies() {
        return currencies;
    }

    public Currency getCurrencyById(int id) {
        for(Currency b: currencies) {
            if(b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    // search currencyusemockdata by text
    public List<Currency> searchCurrencies(String searchTerm) {
        List<Currency> searchedCurrencies = new ArrayList<Currency>();
        for(Currency c: currencies) {
            if(c.getName().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    c.getDescription().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchedCurrencies.add(c);
            }
        }

        return searchedCurrencies;
    }

    // create currencyusemockdata
    public Currency createCurrency(int id, String name, String description) {
        Currency newCurrency = new Currency(id, name, description);
        currencies.add(newCurrency);
        return newCurrency;
    }

    // update currencyusemockdata
    public Currency updateCurrency(int id, String name, String description) {
        for(Currency c: currencies) {
            if(c.getId() == id) {
                int currencyIndex = currencies.indexOf(c);
                c.setName(name);
                c.setDescription(description);
                return c;
            }
        }
        return null;
    }

    // delete currencyusemockdata by id
    public boolean delete(int id){
        int currencyIndex = -1;
        for(Currency c: currencies) {
            if(c.getId() == id) {
                currencyIndex = currencies.indexOf(c);
                continue;
            }
        }
        if(currencyIndex > -1){
            currencies.remove(currencyIndex);
        }
        return true;
    }

}
