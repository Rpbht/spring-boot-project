package com.rahul.savingbank.rahulsavingbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rahul.savingbank.rahulsavingbank.model.User;
import com.rahul.savingbank.rahulsavingbank.utils.ConstantValues;

@Controller
@RequestMapping(value = ConstantValues.USER_BASE)
public class UserController {

	@GetMapping(value = ConstantValues.USER_LOGIN)
	public ModelAndView loginPage(Model model) {
		User user = new User();
		return new ModelAndView(ConstantValues.USER_LOGIN_VIEW).addObject(user);

	}

	@GetMapping(value = ConstantValues.USER_REGISTER)
	public ModelAndView registerPage() {
		User user = new User();
		return new ModelAndView(ConstantValues.USER_REGISTER_VIEW).addObject(user);
	}

	@PostMapping(value ="/abc")
	public void re(@ModelAttribute("user") User user) {
		System.out.println("sdsdssdsd:    "+user);
	}
}
