package com.rahul.savingbank.rahulsavingbank.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.rahul.savingbank.rahulsavingbank.model.Account;
import com.rahul.savingbank.rahulsavingbank.model.User;
import com.rahul.savingbank.rahulsavingbank.utils.ConstantValues;
import com.rahul.savingbank.rahulsavingbank.utils.StaticMethods;

@Controller
@RequestMapping(value = ConstantValues.USER_BASE)
public class UserController {

	protected RestTemplate restTemplate = new RestTemplate();
	private HttpHeaders headers = StaticMethods.createHeaders("rpbht", "rpbht123");

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

	@PostMapping(value = ConstantValues.USER_REGISTERED)
	public <T> String registered(@ModelAttribute("user") User user) {
		@SuppressWarnings("unchecked")
		List<User> respone = restTemplate.exchange("http://localhost:8888/users/", HttpMethod.GET,
				new HttpEntity<T>(headers), List.class, User.class).getBody();

		User userObj = new User(user.getFirstName(), user.getLastName(), user.getGender(), user.getEmail(),
				user.getPassword(), user.getCity(), (long) 1305101 + respone.size(), user.getMobileNumber(),
				"" + System.currentTimeMillis(), "" + System.currentTimeMillis());
		HttpEntity<User> userRequest = new HttpEntity<User>(userObj, headers);
		User userResponse = restTemplate.postForObject("http://localhost:8888/users", userRequest, User.class);
		Account account = new Account(userResponse.getAccountNumber(), "RSB" + userResponse.getId(),
				userResponse.getCity(), (long) 0.0, "" + System.currentTimeMillis());
		HttpEntity<Account> accountRequest = new HttpEntity<Account>(account, headers);
		restTemplate.postForObject("http://localhost:8888/account", accountRequest, Account.class);

		return ConstantValues.USER_LOGIN_VIEW;
	}

	@PostMapping(value = ConstantValues.USER_LOGGED_IN)
	public <T> String loggedin(@ModelAttribute("user") User user, HttpServletRequest httpServletRequest) {
		User respone = restTemplate
				.exchange("http://localhost:8888/users/" + user.getEmail() + "/" + user.getPassword(), HttpMethod.GET,
						new HttpEntity<T>(headers), User.class)
				.getBody();
		if (respone == null) {

			return "redirect:http://localhost:8080/user/login";
		}
		Account accountRespone = restTemplate.exchange("http://localhost:8888/account/" + respone.getAccountNumber(),
				HttpMethod.GET, new HttpEntity<T>(headers), Account.class).getBody();
		httpServletRequest.setAttribute("user", respone);
		httpServletRequest.setAttribute("account", accountRespone);

		return ConstantValues.USER_HOME;
	}
}
