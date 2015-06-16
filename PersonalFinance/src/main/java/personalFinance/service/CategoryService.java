package personalFinance.service;

import java.util.List;

import personalFinance.domain.Category;

public interface CategoryService {

	Category save(Category category);
	List<Category> getList();

}
