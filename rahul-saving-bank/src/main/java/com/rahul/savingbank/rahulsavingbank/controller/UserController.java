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
import com.rahul.savingbank.rahulsavingbank.model.Inquiry;
import com.rahul.savingbank.rahulsavingbank.model.Transaction;
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
	public <T> String registered(@ModelAttribute("user") User user, HttpServletRequest httpServletRequest) {
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
		httpServletRequest.getSession().setAttribute("msg", "Registered successfully!");
		return ConstantValues.USER_LOGIN_VIEW;
	}

	@PostMapping(value = ConstantValues.USER_LOGGED_IN)
	public <T> String loggedin(@ModelAttribute("user") User user, HttpServletRequest httpServletRequest) {
		User respone = restTemplate
				.exchange("http://localhost:8888/users/" + user.getEmail() + "/" + user.getPassword(), HttpMethod.GET,
						new HttpEntity<T>(headers), User.class)
				.getBody();
		if (respone == null) {

			httpServletRequest.getSession().setAttribute("msg", "incorrect username/password");
			return "redirect:http://localhost:8080/user/login";
		}
		Account accountRespone = restTemplate.exchange("http://localhost:8888/account/" + respone.getAccountNumber(),
				HttpMethod.GET, new HttpEntity<T>(headers), Account.class).getBody();

		System.out.println("User:  " + respone + "  Account:   " + accountRespone);
		httpServletRequest.getSession().setAttribute("user", respone);
		httpServletRequest.getSession().setAttribute("account", accountRespone);

		return ConstantValues.USER_HOME;
	}

	@GetMapping(value = ConstantValues.USER_LOGOUT)
	public ModelAndView logOut(HttpServletRequest httpServletRequest) {
		httpServletRequest.getSession().invalidate();
		User user = new User();
		return new ModelAndView(ConstantValues.USER_LOGIN_VIEW).addObject(user);
	}

	@GetMapping(value = ConstantValues.USER_CONTACT)
	public ModelAndView contact(Model model) {
		Inquiry inquiry = new Inquiry();
		model.addAttribute("inquiry", inquiry);
		return new ModelAndView(ConstantValues.USER_CONTACT_VIEW).addObject(inquiry);
	}

	@PostMapping(value = ConstantValues.USER_INQUIRED)
	public <T> String inquired(@ModelAttribute("inquiry") Inquiry inquiry) {
		HttpEntity<Inquiry> userRequest = new HttpEntity<Inquiry>(inquiry, headers);
		restTemplate.postForObject("http://localhost:8888/inquiry", userRequest, Inquiry.class);

		return ConstantValues.USER_HOME;
	}

	@GetMapping(value = ConstantValues.USER_TRANSACTION)
	public ModelAndView transaction(Model model) {
		Transaction transaction = new Transaction();
		model.addAttribute("transaction", transaction);
		return new ModelAndView(ConstantValues.USER_TRANSACTION_VIEW).addObject(transaction);
	}

	@PostMapping(value = ConstantValues.USER_TRANSFERED)
	public <T> String transfered(@ModelAttribute("transaction") Transaction transaction,
			HttpServletRequest httpServletRequest) {

		Account accountRespone = restTemplate
				.exchange("http://localhost:8888/account/" + transaction.getAccountNumber(), HttpMethod.GET,
						new HttpEntity<T>(headers), Account.class)
				.getBody();

		if (accountRespone == null) {
			httpServletRequest.getSession().setAttribute("bmsg", "please enter valid account number");
			return ConstantValues.USER_TRANSACTION_VIEW;
		}

		Account account = (Account) httpServletRequest.getSession().getAttribute("account");

		if (transaction.getAmount() > account.getAmount()) {
			httpServletRequest.getSession().setAttribute("bmsg", "You have not sufficient balance");
			return ConstantValues.USER_TRANSACTION_VIEW;
		}

		Account transferer = account;
		transferer.setId(account.getId());
		transferer.setAmount(account.getAmount() - transaction.getAmount());

		HttpEntity<Account> minusRequest = new HttpEntity<Account>(transferer, headers);
		restTemplate.postForObject("http://localhost:8888/account", minusRequest, Account.class);

		Account beneficiary = accountRespone;
		beneficiary.setId(accountRespone.getId());
		beneficiary.setAmount(accountRespone.getAmount() + transaction.getAmount());

		HttpEntity<Account> plusRequest = new HttpEntity<Account>(beneficiary, headers);
		restTemplate.postForObject("http://localhost:8888/account", plusRequest, Account.class);

		Transaction finalTransaction = new Transaction();
		finalTransaction.setAccountNumber(beneficiary.getAccountNumber());
		finalTransaction.setAmount(transaction.getAmount());
		finalTransaction.setCreated("" + System.currentTimeMillis());
		finalTransaction.setTicket("RSBT" + System.currentTimeMillis());
		finalTransaction.setAccountDetails(account);

		System.out.println("before transaction entry: " + finalTransaction);
		HttpEntity<Transaction> userRequest = new HttpEntity<Transaction>(finalTransaction, headers);
		restTemplate.postForObject("http://localhost:8888/transactions", userRequest, Transaction.class);
		return ConstantValues.USER_HOME;

	}

}
