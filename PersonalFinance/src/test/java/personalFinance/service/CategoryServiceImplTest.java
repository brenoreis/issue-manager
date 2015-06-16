package personalFinance.service; 	

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import personalFinance.domain.Category;
import personalFinance.repository.CategoryRepository;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceImplTest  {

    @Mock
    private CategoryRepository categoryRepository;

    private CategoryService categoryService;

    @Before
    public void setUp() {
    	categoryService = new CategoryServiceImpl(categoryRepository);
    }

    @Test
    public void shouldSaveNewUser() {
        final Category savedCategory = stubRepositoryToReturnCategoryOnSave();
        final Category category = new Category();
        final Category returnedCategory = categoryService.save(category);
        // verify repository was called with user
        verify(categoryRepository, times(1)).save(category);
        assertEquals("Returned category should come from the repository", savedCategory, returnedCategory);
    }

    private Category stubRepositoryToReturnCategoryOnSave() {
    	Category category = new Category();
        when(categoryRepository.save(any(Category.class))).thenReturn(category);
        return category;
    }

}
