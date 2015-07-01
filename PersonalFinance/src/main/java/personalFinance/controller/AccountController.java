package personalFinance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import personalFinance.domain.Account;
import personalFinance.service.AccountService;
import personalFinance.service.CurrencyService;

@Controller
public class AccountController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CurrencyService currencyService;
	
	@RequestMapping(value= "/accounts", method = RequestMethod.GET)
	public String listAccounts(Model model) {
		LOGGER.debug("Received request to get account list view");
		model.addAttribute("account", new Account());
		model.addAttribute("accounts", accountService.getList());
		model.addAttribute("currencies", currencyService.getList());
		return "accountList";
	}
	
	@RequestMapping(value = "/account/create", method = RequestMethod.POST)
	public String createAccount(@ModelAttribute("account") Account account, Model model) {
		LOGGER.debug("Received request to create {}", account);
		accountService.save(account);
	    return "redirect:/accounts";
	}

}
