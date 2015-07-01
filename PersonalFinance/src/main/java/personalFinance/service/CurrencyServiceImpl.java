package personalFinance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import personalFinance.domain.Currency;
import personalFinance.repository.CurrencyRepository;


@Service
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	private CurrencyRepository repository;

	@Override
	@Transactional
	public Currency save(final Currency currency) {
			return repository.save(currency);
	}

	@Override
	public List<Currency> getList() {
		
		return repository.findAll();
	}

}
