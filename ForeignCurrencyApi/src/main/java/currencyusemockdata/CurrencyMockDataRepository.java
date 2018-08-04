package currencyusemockdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyMockDataRepository extends JpaRepository<CurrencyMockData, Integer> {
    List<CurrencyMockData> findByNameContainingOrDescriptionContaining(String text, String textAgain);
}
