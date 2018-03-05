package com.rahul.bank.rahulsavingbankinquiryapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.bank.rahulsavingbankinquiryapi.model.Inquiry;
import com.rahul.bank.rahulsavingbankinquiryapi.service.InquiryService;
import com.rahul.bank.rahulsavingbankinquiryapi.utils.ConstantValue;

@RestController
public class InquiryController {

	@Autowired
	private InquiryService inquiryService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Inquiry getInquiry(@PathVariable Long id){
		return inquiryService.getInquiry(id);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Inquiry> getAllInquiry(){
		return inquiryService.getAllInquiries();
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Inquiry saveInquiry(@PathVariable Inquiry inquiry){
		return inquiryService.saveInquiry(inquiry);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Inquiry editInquiry(@PathVariable Inquiry inquiry){
		return inquiryService.saveInquiry(inquiry);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public String deleteAllInquiries(){
		inquiryService.deleteAllInquiry();
		return ConstantValue.INQUIRY_DELETED;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String deleteInquiry(@PathVariable Long id){
		inquiryService.deleteInquiry(id);
		return ConstantValue.ALL_INQUIRY_DELETED;
	}
}
