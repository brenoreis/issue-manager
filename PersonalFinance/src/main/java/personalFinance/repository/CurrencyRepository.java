package personalFinance.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import personalFinance.domain.Currency;

public interface CurrencyRepository extends MongoRepository<Currency, String> {

	public List<Currency> findBySymbol(String symbol);

}
