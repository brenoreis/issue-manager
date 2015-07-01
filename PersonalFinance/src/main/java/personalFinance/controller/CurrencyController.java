package personalFinance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import personalFinance.domain.Currency;
import personalFinance.service.CurrencyService;

@Controller
public class CurrencyController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyController.class);
	
	@Autowired
	private CurrencyService currencyService;

	@RequestMapping(value= "/currencies", method = RequestMethod.GET)
	public String listCurrencies(Model model) {
		LOGGER.debug("Received request to get currency list view");
		model.addAttribute("currency", new Currency());
		model.addAttribute("currencies", currencyService.getList());
		return "currencyList";
	}
	
	@RequestMapping(value = "/currency/create", method = RequestMethod.POST)
	public String createCurrency(@ModelAttribute("currency") Currency currency, Model model) {
		LOGGER.debug("Received request to create {}", currency);
		currencyService.save(currency);
	    return "redirect:/currencies";
	}

}
