package com.rahul.savingbank.rahulsavingbank.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rahul.savingbank.rahulsavingbank.utils.ConstantValues;

@Controller
@RequestMapping(value = ConstantValues.BANK_BASE_URl)
public class BankController {

	@GetMapping
	public String bankHome() {
		return ConstantValues.BANK_HOME_VIEW;
	}

	@GetMapping(value = ConstantValues.ABOUT)
	public String bankAbout() {
		return ConstantValues.BANK_ABOUT_VIEW;
	}

	@GetMapping(value = ConstantValues.CONTACT)
	public String bankContact() {
		return ConstantValues.BANK_CONTACT_VIEW;
	}
}
