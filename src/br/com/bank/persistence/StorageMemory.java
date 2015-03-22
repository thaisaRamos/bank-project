package br.com.bank.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.bank.model.Account;
import br.com.bank.model.User;

public class StorageMemory {

	private static StorageMemory instance;

	private List<Account> accounts;

	private StorageMemory(){
		accounts = new ArrayList<Account>();
		makeInitialStorage();
	}

	public void makeInitialStorage() {

		User user1 = new User();
		user1.setName("Renato");
		user1.setCpf("06159242474");
		Account acc1 = new Account();
		acc1.setAccountNumber("34407");
		acc1.setAgencyNumber("1668");
		acc1.setCash(0);
		acc1.setUser(user1);
		accounts.add(acc1);

		User user2 = new User();
		user2.setName("Francisco");
		user2.setCpf("11111111111");
		Account acc2 = new Account();
		acc2.setAccountNumber("12345");
		acc2.setAgencyNumber("1234");
		acc2.setCash(100);
		acc2.setUser(user2);
		accounts.add(acc2);

	}

	public static StorageMemory getInstance(){
		if (instance == null) {
			return new StorageMemory();
		}
		return instance;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public Account getAccount(String accNumber, String agNumber) {

		Account acc = null;

		for (int i = 0 ; i < accounts.size() ; i++) {

			if ((accounts.get(i).getAccountNumber().equals(accNumber)) &&
					(accounts.get(i).getAgencyNumber().equals(agNumber))) {	
				acc = accounts.get(i);
				return acc;
			}
		}
		return acc;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}
