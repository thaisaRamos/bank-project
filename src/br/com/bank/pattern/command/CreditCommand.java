package br.com.bank.pattern.command;

import br.com.bank.model.Account;

public class CreditCommand implements IBankCommand{

	private Account account;
	private double cash;
	
	public CreditCommand(Account account,double cash) {
		this.account = account;
		this.cash = cash;
	}
	
	@Override
	public Account execute() {
		account.setCash(account.getCash()+cash);
		return account;
	}

}
