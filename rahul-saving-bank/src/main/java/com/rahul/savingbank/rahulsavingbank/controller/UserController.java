package com.rahul.savingbank.rahulsavingbank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
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
		transferer.setAmount(account.getAmount() - transaction.getAmount());

		HttpEntity<Account> minusRequest = new HttpEntity<Account>(transferer, headers);
		restTemplate.put("http://localhost:8888/account", minusRequest, Account.class);

		Account beneficiary = accountRespone;
		beneficiary.setAmount(accountRespone.getAmount() + transaction.getAmount());

		HttpEntity<Account> plusRequest = new HttpEntity<Account>(beneficiary, headers);
		restTemplate.put("http://localhost:8888/account", plusRequest, Account.class);

		Transaction finalTransactionBenificiar = new Transaction();
		finalTransactionBenificiar.setAccountNumber(beneficiary.getAccountNumber());
		finalTransactionBenificiar.setAmount(transaction.getAmount());
		finalTransactionBenificiar.setCreated("" + System.currentTimeMillis());
		finalTransactionBenificiar.setTicket("RSBT" + System.currentTimeMillis());
		finalTransactionBenificiar.setAccountDetails(account);

		HttpEntity<Transaction> benificierRequest = new HttpEntity<Transaction>(finalTransactionBenificiar, headers);
		restTemplate.postForObject("http://localhost:8888/transactions/data", benificierRequest, Transaction.class);

		Transaction finalTransactionTransferer = new Transaction();
		finalTransactionTransferer.setAccountNumber(account.getAccountNumber());
		finalTransactionTransferer.setAmount(transaction.getAmount());
		finalTransactionTransferer.setCreated("" + System.currentTimeMillis());
		finalTransactionTransferer.setTicket("RSBT" + System.currentTimeMillis());
		finalTransactionTransferer.setAccountDetails(beneficiary);

		HttpEntity<Transaction> transfererRequest = new HttpEntity<Transaction>(finalTransactionTransferer, headers);
		restTemplate.postForObject("http://localhost:8888/transactions/data", transfererRequest, Transaction.class);

		return ConstantValues.USER_HOME;

	}

	@GetMapping(value = ConstantValues.USER_PRINT_PDF)
	public <T> String printPdf(HttpServletRequest httpServletRequest, Document document, PdfWriter pdfWriter,
			HttpServletResponse response) {
		Account account = (Account) httpServletRequest.getSession().getAttribute("account");

		try {
			response.setHeader("Expires", "0");
			response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Pragma", "public");
			response.setContentType("application/pdf");
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			@SuppressWarnings("unchecked")
			ResponseEntity<Transaction[]> transactionsEntitties = restTemplate.exchange(
					"http://localhost:8888/transactions/data/account/" + account.getAccountNumber(), HttpMethod.GET,
					new HttpEntity<T>(headers), Transaction[].class);
			Transaction[] transactions = transactionsEntitties.getBody();

			Table table = new Table(3);
			table.addCell("Account Number");
			table.addCell("Amount");
			table.addCell("Time");
			for (Transaction transaction : transactions) {
				table.addCell(transaction.getAccountNumber().toString());
				table.addCell(transaction.getAmount().toString());
				table.addCell(transaction.getCreated());

			}
			document.add(table);
			document.close();

		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ConstantValues.USER_HOME;
	}

}
