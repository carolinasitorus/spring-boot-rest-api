package currencyusemockdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CurrencyController {
    @Autowired
    CurrencyRepository currencyRepository;

    @GetMapping("/currency")
    public List<Currency> index() {
        return currencyRepository.findAll();
    }

    @GetMapping("/currency/{id}")
    public Currency show(@PathVariable String id) {
        int currencyId = Integer.parseInt(id);
        return currencyRepository.findOne(currencyId);
    }

    @PostMapping("/currency/search")
    public List<Currency> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return currencyRepository.findByNameContainingOrDescriptionContaining(searchTerm, searchTerm);
    }

    @PostMapping("/currency")
    public Currency create(@RequestBody Map<String, String> body) {
        String name = body.get("title");
        String description = body.get("description");
        return currencyRepository.save(new Currency(name, description));
    }

    @PutMapping("/currency/{id}")
    public Currency update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int currencyId = Integer.parseInt(id);
        Currency currency = currencyRepository.findOne(currencyId);
        currency.setName(body.get("name"));
        currency.setDescription(body.get("description"));
        return currencyRepository.save(currency);
    }

    @DeleteMapping("/currency/{id}")
    public boolean delete(@PathVariable String id) {
        int currencyId = Integer.parseInt(id);
        currencyRepository.delete(currencyId);
        return true;
    }
}
