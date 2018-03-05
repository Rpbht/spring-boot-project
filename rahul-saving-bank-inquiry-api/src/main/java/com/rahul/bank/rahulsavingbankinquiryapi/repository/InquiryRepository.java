package com.rahul.bank.rahulsavingbankinquiryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.bank.rahulsavingbankinquiryapi.model.Inquiry;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long>{

}
