package personalFinance.service;

import java.util.List;

import personalFinance.domain.Transaction;

public interface TransactionService {

	Transaction save(Transaction transaction);
	List<Transaction> getList();

}
