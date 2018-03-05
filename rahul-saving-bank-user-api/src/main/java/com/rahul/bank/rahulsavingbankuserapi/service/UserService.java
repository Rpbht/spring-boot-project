package com.rahul.bank.rahulsavingbankuserapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.bank.rahulsavingbankuserapi.model.User;
import com.rahul.bank.rahulsavingbankuserapi.repository.UserRepository;
import com.rahul.bank.rahulsavingbankuserapi.utils.ConstantValues;

@Service
public class UserService {

	@Autowired
	protected UserRepository repository;

	public User getUserById(Long id) {
		return repository.getOne(id);
	}

	public List<User> getUsers() {
		return repository.findAll();
	}

	public User saveUser(User user) {
		return repository.save(user);
	}

	public String deleteUserById(Long id) {
		repository.deleteById(id);
		return ConstantValues.DELETE_USER;
	}

	public String deleteAllUser() {
		repository.deleteAll();
		return ConstantValues.DELETE_ALL;
	}

	public User isVAlid(String email, String password) {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		System.out.println("isVAlid");
		return repository.isValid(user);
	}

}
