package personalFinance.controller;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import personalFinance.domain.Category;
import personalFinance.service.CategoryService;
import personalFinance.service.exception.CategoryAlreadyExistsException;
import personalFinance.util.CategoryUtil;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;
    
    @Mock
    private BindingResult result;

    private CategoryController categoryController;
/*
    @Before
    public void setUp() {
    	categoryController = new CategoryController(categoryService);
    }

    @Test
    public void shouldCreateCategory() throws Exception {
        final Category savedCategory = stubServiceToReturnStoredCategory();
        final Category category = new Category();
        Category returnedCategory = categoryController.createCategory(category);
        // verify category was passed to CategoryService
        verify(categoryService, times(1)).save(category);
        assertEquals("Returned category should come from the service", savedCategory, returnedCategory);
    }

    private Category stubServiceToReturnStoredCategory() {
        final Category category = new Category();
        when(categoryService.save(any(Category.class))).thenReturn(category);
        return category;
    }
    

    @Test
    public void shouldGetCategoryListPage() {
        List<Category> categoryList = stubServiceToReturnExistingCategories(5);
        ModelAndView view = categoryController.getListCategoriesView();
        // verify UserService was called once
        verify(categoryService, times(1)).getList();
        assertEquals("View name should be right", "category_list", view.getViewName());
        assertEquals("Model should contain attribute with the list of categories coming from the service",
        		categoryList, view.getModel().get("category"));
    }


    private List<Category> stubServiceToReturnExistingCategories(int howMany) {
        List<Category> categoryList = CategoryUtil.createCategoryList(howMany);
        when(categoryService.getList()).thenReturn(categoryList);
        return categoryList;
    }

    @Test
    public void shouldGetCreateCategoryPage() throws Exception {
        ModelAndView view = categoryController.getCreateCategoryView();
        assertEquals("View name should be right", "category_create", view.getViewName());
        assertTrue("View should contain attribute with form object", view.getModel().containsKey("form"));
        assertTrue("The form object should be of proper type", view.getModel().get("form") instanceof Category);
    }

    @Test
    public void shouldCreateCategory_GivenThereAreNoErrors_ThenTheCategoryShouldBeSavedAndCategoryListViewDisplayed() {
        when(result.hasErrors()).thenReturn(false);
        Category form = new Category();
        form.setName("name");
        form.setDescription("description");
        String view = categoryController.createCategory(form, result);
        assertEquals("There should be proper redirect", "redirect:/category_list.html", view);
        ArgumentCaptor<Category> captor = ArgumentCaptor.forClass(Category.class);
        verify(categoryService, times(1)).save(captor.capture());
        assertEquals(form.getName(), captor.getValue().getName());
        assertEquals(form.getDescription(), captor.getValue().getDescription());
    }
    
    @Test
    public void shouldCreateCategory_GivenThereAreFormErrors_ThenTheFormShouldBeDisplayed() {
        when(result.hasErrors()).thenReturn(true);
        String view = categoryController.createCategory(new Category(), result);
        verify(categoryService, never()).save(any(Category.class));
        assertEquals("View name should be right", "category_create", view);
    }
    
    @Test
    public void shouldCreateCategory_GivenThereAlreadyExistUserWithId_ThenTheFormShouldBeDisplayed() {
        when(result.hasErrors()).thenReturn(false);
        when(categoryService.save(any(Category.class))).thenThrow(CategoryAlreadyExistsException.class);
        String view = categoryController.createCategory(new Category(), result);
        verify(result).reject("category.error.exists");
        assertEquals("View name should be right", "category_create", view);
    }
    */
}
