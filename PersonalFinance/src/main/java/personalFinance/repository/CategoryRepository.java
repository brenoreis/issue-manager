package personalFinance.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import personalFinance.domain.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {
	
	public List<Category> findByName(String name);	

}
