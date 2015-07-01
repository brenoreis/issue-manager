package personalFinance.service;

import java.util.List;

import personalFinance.domain.Currency;

public interface CurrencyService {

	Currency save(Currency currency);
	List<Currency> getList();
	
}
