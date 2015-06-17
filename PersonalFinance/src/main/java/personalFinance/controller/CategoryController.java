package personalFinance.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import personalFinance.domain.Category;
import personalFinance.service.CategoryService;
import personalFinance.service.exception.CategoryAlreadyExistsException;

@Controller
public class CategoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);
	private final CategoryService categoryService;

	@Autowired
	public CategoryController(final CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
/*
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public Category createCategory(@RequestBody @Valid final Category category) {
		return categoryService.save(category);
	}
*/
	@RequestMapping(value= "/categories", method = RequestMethod.GET)
	public String getListCategoriesView(Model model) {
		LOGGER.debug("Received request to get category list view");
		model.addAttribute("categories", categoryService.getList());
		return "category_list";
	}
	
    @RequestMapping(value = "/category/create", method = RequestMethod.GET)
    public String getCreateCategoryView(Model model) {
    	LOGGER.debug("Received request for category create view");
    	model.addAttribute("category", new Category());
        return "category_create";
    }
    
	@RequestMapping(value = "/category/create", method = RequestMethod.POST)
	public String createCategory(@ModelAttribute("category") Category category) {
		LOGGER.debug("Received request to create {}", category);
    	categoryService.save(category);
	    return "category_list";
	}

}
