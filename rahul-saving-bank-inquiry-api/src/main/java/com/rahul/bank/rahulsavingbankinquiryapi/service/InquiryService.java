package com.rahul.bank.rahulsavingbankinquiryapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.bank.rahulsavingbankinquiryapi.model.Inquiry;
import com.rahul.bank.rahulsavingbankinquiryapi.repository.InquiryRepository;
import com.rahul.bank.rahulsavingbankinquiryapi.utils.ConstantValue;

@Service
public class InquiryService {

	@Autowired
	private InquiryRepository inquiryRepository;

	public Inquiry getInquiry(Long id) {
		return inquiryRepository.getOne(id);
	}

	public List<Inquiry> getAllInquiries() {
		return inquiryRepository.findAll();
	}

	public Inquiry saveInquiry(Inquiry inquiry) {
		return inquiryRepository.save(inquiry);
	}

	public String deleteInquiry(Long id) {
		inquiryRepository.deleteById(id);
		return ConstantValue.INQUIRY_DELETED;
	}

	public String deleteAllInquiry() {
		inquiryRepository.deleteAll();
		return ConstantValue.ALL_INQUIRY_DELETED;
	}

}
