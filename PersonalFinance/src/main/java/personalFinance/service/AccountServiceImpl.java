package personalFinance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import personalFinance.domain.Account;
import personalFinance.repository.AccountRepository;


@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository repository;

	@Override
	@Transactional
	public Account save(final Account account) {
			return repository.save(account);
	}

	@Override
	public List<Account> getList() {
		
		return repository.findAll();
	}

}
