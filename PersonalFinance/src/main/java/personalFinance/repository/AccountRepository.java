package personalFinance.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import personalFinance.domain.Account;

public interface AccountRepository extends MongoRepository<Account, String> {

	public List<Account> findByName(String name);

}
