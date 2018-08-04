package currencyusemockdata;

import java.util.ArrayList;
import java.util.List;

public class CurrencyMockedDataQuery {
    private List<CurrencyMockData> currencies;

    private static CurrencyMockedDataQuery instance = null;
    public static CurrencyMockedDataQuery getInstance(){
        if(instance == null){
            instance = new CurrencyMockedDataQuery();
        }
        return instance;
    }

    public CurrencyMockedDataQuery(){
        currencies = new ArrayList<CurrencyMockData>();
        currencies.add(new CurrencyMockData(1, "IDR",
                "Indonesia Rupiah"));
        currencies.add(new CurrencyMockData(2, "USD",
                "US Dollar"));
        currencies.add(new CurrencyMockData(3, "EUR",
                "Euro"));
        currencies.add(new CurrencyMockData(4, "CAD",
                "Canadian Dollar"));
        currencies.add(new CurrencyMockData(5, "GBP",
                "Pound Sterling"));
    }

    public List<CurrencyMockData> fetchCurrencies() {
        return currencies;
    }

    public CurrencyMockData getCurrencyById(int id) {
        for(CurrencyMockData b: currencies) {
            if(b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    // search currencyusemockdata by text
    public List<CurrencyMockData> searchCurrencies(String searchTerm) {
        List<CurrencyMockData> searchedCurrencies = new ArrayList<CurrencyMockData>();
        for(CurrencyMockData c: currencies) {
            if(c.getName().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    c.getDescription().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchedCurrencies.add(c);
            }
        }

        return searchedCurrencies;
    }

    // create currencyusemockdata
    public CurrencyMockData createCurrency(int id, String name, String description) {
        CurrencyMockData newCurrency = new CurrencyMockData(id, name, description);
        currencies.add(newCurrency);
        return newCurrency;
    }

    // update currencyusemockdata
    public CurrencyMockData updateCurrency(int id, String name, String description) {
        for(CurrencyMockData c: currencies) {
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
        for(CurrencyMockData c: currencies) {
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
