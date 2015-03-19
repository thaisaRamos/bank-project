package br.com.bank.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.bank.model.Account;

public class StorageMemory {

	private static StorageMemory instance;
	
	private List<Account> accounts;
	
	private StorageMemory(){
		accounts = new ArrayList<Account>();
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

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
}
