package com.rahul.savingbank.rahulsavingbankinterest.service;

import java.text.DecimalFormat;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.rahul.savingbank.rahulsavingbankinterest.model.Account;
import com.rahul.savingbank.rahulsavingbankinterest.model.Interest;
import com.rahul.savingbank.rahulsavingbankinterest.utils.UtilMethods;

@Component
@EnableScheduling
public class SchedularService {

	private RestTemplate restTemplate = new RestTemplate();
	private HttpHeaders headers = UtilMethods.createHeaders("rpbht", "rpbht123");
	private static DecimalFormat df2 = new DecimalFormat("#.##");

	@Scheduled(cron = "0 */1 * * * ?")
	private <T> void updateInterest() {

		Account[] accounts = restTemplate.exchange("http://SpringBoot-Bank-Gateway:8888/account/", HttpMethod.GET,
				new HttpEntity<T>(headers), Account[].class, Account.class).getBody();

		for (Account account : accounts) {

			long accountNumber = account.getAccountNumber();

			Double interestAmount = UtilMethods.calculateInterest(account.getAmount());

			Interest previousInterest = restTemplate.exchange("http://SpringBoot-Bank-Gateway:8888/interest/value/" + accountNumber,
					HttpMethod.GET, new HttpEntity<T>(headers), Interest.class).getBody();

			double newAmont = Double.valueOf(df2.format(previousInterest.getAmount() + interestAmount));

			Interest interest = new Interest(accountNumber, newAmont);

			HttpEntity<Interest> interestReq = new HttpEntity<Interest>(interest, headers);
			restTemplate.put("http://SpringBoot-Bank-Gateway:8888/interest/value/edit", interestReq, Interest.class);

			// run 3monthly job and transactions
		}

	}

	@Scheduled(cron = "0 0 12 1 */3 ?")
	private <T> void payInterest() {

		Account[] accounts = restTemplate.exchange("http://SpringBoot-Bank-Gateway:8888/account/", HttpMethod.GET,
				new HttpEntity<T>(headers), Account[].class, Account.class).getBody();

		for (Account account : accounts) {

			Interest interest = restTemplate
					.exchange("http://SpringBoot-Bank-Gateway:8888/interest/value/" + account.getAccountNumber(), HttpMethod.GET,
							new HttpEntity<T>(headers), Interest.class)
					.getBody();

			account.setAmount(account.getAmount() + interest.getAmount());

			HttpEntity<Account> accountRequest = new HttpEntity<Account>(account, headers);
			restTemplate.postForObject("http://SpringBoot-Bank-Gateway:8888/account", accountRequest, Account.class);
			System.out.println("Account updated");
		}
	}

}
