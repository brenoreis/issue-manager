package personalFinance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import personalFinance.domain.Category;
import personalFinance.repository.CategoryRepository;
import personalFinance.service.exception.CategoryAlreadyExistsException;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository repository;

	@Override
	@Transactional
	public Category save(final Category category) {
		if (!repository.findByName(category.getName()).isEmpty()) {
			throw new CategoryAlreadyExistsException("Category already exists");
		} else {
			return repository.save(category);
		}
	}

	@Override
	public List<Category> getList() {
		
		return repository.findAll();
	}

}
