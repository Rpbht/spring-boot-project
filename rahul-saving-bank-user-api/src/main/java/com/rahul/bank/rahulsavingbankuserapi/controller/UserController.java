package com.rahul.bank.rahulsavingbankuserapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rahul.bank.rahulsavingbankuserapi.model.User;
import com.rahul.bank.rahulsavingbankuserapi.service.UserService;
import com.rahul.bank.rahulsavingbankuserapi.utils.ConstantValues;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable Long id) {
		System.out.println(userService.getUserById(id));
		return userService.getUserById(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@RequestMapping(method = RequestMethod.POST)
	public User editUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public String deleteAllUsers() {
		userService.deleteAllUser();
		return ConstantValues.DELETE_ALL;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		return ConstantValues.DELETE_USER;
	}

	@RequestMapping(value = "/{email}/{password}", method = RequestMethod.GET)
	public User findUser(@PathVariable String email, @PathVariable String password) {
		return userService.isVAlid(email, password);
	}
}
