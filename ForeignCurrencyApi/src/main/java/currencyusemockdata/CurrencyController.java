package currencyusemockdata;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CurrencyController {
    CurrencyMockedData currencyMockedData = CurrencyMockedData.getInstance();

    @GetMapping("/currencyusemockdata")
    public List<Currency> index(){
        return currencyMockedData.fetchCurrencies();
    }

    @GetMapping("/currencyusemockdata/{id}")
    public Currency show(@PathVariable String id){
        int currencyId = Integer.parseInt(id);
        return currencyMockedData.getCurrencyById(currencyId);
    }

    @PostMapping("/currencyusemockdata/search")
    public List<Currency> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return currencyMockedData.searchCurrencies(searchTerm);
    }

    @PostMapping("/currencyusemockdata")
    public Currency create(@RequestBody Map<String, String> body){
        int id = Integer.parseInt(body.get("id"));
        String name = body.get("name");
        String description = body.get("description");
        return currencyMockedData.createCurrency(id, name, description);
    }

    @PutMapping("/currencyusemockdata/{id}")
    public Currency update(@PathVariable String id, @RequestBody Map<String, String> body){
        int currencyId = Integer.parseInt(id);
        String name = body.get("name");
        String description = body.get("description");
        return currencyMockedData.updateCurrency(currencyId, name, description);
    }

    @DeleteMapping("currencyusemockdata/{id}")
    public boolean delete(@PathVariable String id){
        int currencyId = Integer.parseInt(id);
        return currencyMockedData.delete(currencyId);
    }
}
