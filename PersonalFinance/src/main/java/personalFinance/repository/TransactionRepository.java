package personalFinance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import personalFinance.domain.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
		

}
