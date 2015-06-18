package personalFinance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import personalFinance.domain.Transaction;
import personalFinance.repository.TransactionRepository;


@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository repository;

	@Override
	@Transactional
	public Transaction save(final Transaction transaction) {
		return repository.save(transaction);
	}

	@Override
	public List<Transaction> getList() {
		
		return repository.findAll();
	}

}
