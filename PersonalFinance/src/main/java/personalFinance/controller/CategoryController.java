package personalFinance.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	private final CategoryService categoryService;

	@Autowired
	public CategoryController(final CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public Category createCategory(@RequestBody @Valid final Category category) {
		return categoryService.save(category);
	}

	@RequestMapping("/category_list.html")
	public ModelAndView getListCategoriesView() {
		ModelMap model = new ModelMap();
		model.addAttribute("categories", categoryService.getList());
		return new ModelAndView("category_list", model);
	}
	
    @RequestMapping(value = "/category_create.html", method = RequestMethod.GET)
    public ModelAndView getCreateCategoryView() {
        return new ModelAndView("category_create", "form", new Category());
    }
    
	@RequestMapping(value = "/category_create.html", method = RequestMethod.POST)
	public String createCategory(@ModelAttribute("form") @Valid Category form, BindingResult result) {
	    if (result.hasErrors()) {
	        return "category_create";
	    }
	    try {
	    	categoryService.save(new Category(form.getName(), form.getDescription()));
	    } catch (CategoryAlreadyExistsException e) {
	        result.reject("category.error.exists");
	        return "category_create";
	    }
	    return "redirect:/category_list.html";
	}

}
