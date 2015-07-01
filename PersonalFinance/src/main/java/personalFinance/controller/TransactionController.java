package personalFinance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import personalFinance.domain.Category;
import personalFinance.domain.Transaction;
import personalFinance.service.AccountService;
import personalFinance.service.CategoryService;
import personalFinance.service.TransactionService;

@Controller
public class TransactionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private AccountService accountService;

	@RequestMapping(value= {"/", "/transactions"}, method = RequestMethod.GET)
	public String home(Model model) {
		LOGGER.debug("Received request to get home view");
		model.addAttribute("transactions", transactionService.getList());
		model.addAttribute("categories", categoryService.getList());
		model.addAttribute("accounts", accountService.getList());
    	Transaction transaction = new Transaction();
    	transaction.setCategory(new Category());
    	model.addAttribute("transaction", transaction);

		return "transactionList";
	}
	
	@RequestMapping(value = "/transaction/create", method = RequestMethod.POST)
	public String createTransaction(@ModelAttribute("transaction") Transaction transaction, @ModelAttribute("category") Category category, Model model) {
		LOGGER.debug("Received request to create {}", transaction);
		transaction.setCategory(category);
		transactionService.save(transaction);
	    return "redirect:/transactions";
	}
	
    @RequestMapping(value = "/transaction/delete/{id}", method = RequestMethod.GET)
    public String deleteTransaction(@PathVariable("id") String id, Model model) {
    	LOGGER.debug("Received request for category delete");
    	transactionService.delete(id);
    	return "redirect:/transactions";
    }
    
    @RequestMapping(value = "/transaction/edit/{id}", method = RequestMethod.GET)
    public String editTransaction(@PathVariable("id") String id, Model model) {
    	LOGGER.debug("Received request for category edit");
    	model.addAttribute("transaction", transactionService.findOne(id));
    	model.addAttribute("categories", categoryService.getList());
    	return "transaction_create";
    }

}
