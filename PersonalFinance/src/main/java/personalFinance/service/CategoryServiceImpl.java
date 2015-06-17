package personalFinance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import personalFinance.domain.Category;
import personalFinance.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository repository;

	@Autowired
	public CategoryServiceImpl(final CategoryRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public Category save(final Category category) {
		return repository.save(category);
	}

	@Override
	public List<Category> getList() {
		
		return repository.findAll();
	}

}
