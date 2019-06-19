package com.rahul.bank.rahulsavingbankaccountapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rahul.bank.rahulsavingbankaccountapi.model.Interest;
import com.rahul.bank.rahulsavingbankaccountapi.service.InterestService;

@RestController
@RequestMapping(value = "/value")
public class InterestController {

	@Autowired
	private InterestService interestService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Interest> getAllInterest() {
		return interestService.getAllInterest();
	}
	
	@RequestMapping(value = "/{acountNumber}", method = RequestMethod.GET)
	public Interest findbyAccountNumber(@PathVariable long acountNumber) {
		return interestService.findByAccountNumber(acountNumber);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Interest saveInterest(@RequestBody Interest interest) {
		return interestService.saveInterest(interest);
	}

	@RequestMapping(value="/edit",method = RequestMethod.PUT)
	public Integer editInterest(@RequestBody Interest interest) {
		System.out.println("Interest Saved: "+interest);
		return interestService.updateInterest(interest);
	}
}
