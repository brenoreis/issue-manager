package personalFinance.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import personalFinance.entity.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {
	
	public List<Category> findAll();
	public List<Category> findByName(String name);	

}
