package currencyusemockdata;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CurrencyMockDataController {
    CurrencyMockedDataQuery currencyMockedDataQuery = CurrencyMockedDataQuery.getInstance();

    @GetMapping("/currencyusemockdata")
    public List<CurrencyMockData> index(){
        return currencyMockedDataQuery.fetchCurrencies();
    }

    @GetMapping("/currencyusemockdata/{id}")
    public CurrencyMockData show(@PathVariable String id){
        int currencyId = Integer.parseInt(id);
        return currencyMockedDataQuery.getCurrencyById(currencyId);
    }

    @PostMapping("/currencyusemockdata/search")
    public List<CurrencyMockData> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return currencyMockedDataQuery.searchCurrencies(searchTerm);
    }

    @PostMapping("/currencyusemockdata")
    public CurrencyMockData create(@RequestBody Map<String, String> body){
        int id = Integer.parseInt(body.get("id"));
        String name = body.get("name");
        String description = body.get("description");
        return currencyMockedDataQuery.createCurrency(id, name, description);
    }

    @PutMapping("/currencyusemockdata/{id}")
    public CurrencyMockData update(@PathVariable String id, @RequestBody Map<String, String> body){
        int currencyId = Integer.parseInt(id);
        String name = body.get("name");
        String description = body.get("description");
        return currencyMockedDataQuery.updateCurrency(currencyId, name, description);
    }

    @DeleteMapping("currencyusemockdata/{id}")
    public boolean delete(@PathVariable String id){
        int currencyId = Integer.parseInt(id);
        return currencyMockedDataQuery.delete(currencyId);
    }
}
