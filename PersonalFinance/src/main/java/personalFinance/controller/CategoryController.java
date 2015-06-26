package personalFinance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import personalFinance.domain.Category;
import personalFinance.service.CategoryService;

@Controller
public class CategoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value= "/categories", method = RequestMethod.GET)
	public String listCategories(Model model) {
		LOGGER.debug("Received request to get category list view");
		model.addAttribute("category", new Category());
		model.addAttribute("categories", categoryService.getList());
		return "categoryList";
	}
	
    @RequestMapping(value = "/category/create", method = RequestMethod.GET)
    public String createCategory(Model model) {
    	LOGGER.debug("Received request for category create view");
    	model.addAttribute("category", new Category());
        return "category_create";
    }
    
	@RequestMapping(value = "/category/create", method = RequestMethod.POST)
	public String createCategory(@ModelAttribute("category") Category category, Model model) {
		LOGGER.debug("Received request to create {}", category);
    	categoryService.save(category);
	    return "redirect:/categories";
	}

}
