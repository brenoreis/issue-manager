package personalFinance.service;

import java.util.List;

import personalFinance.domain.Account;

public interface AccountService {

	Account save(Account account);
	List<Account> getList();
	
}
