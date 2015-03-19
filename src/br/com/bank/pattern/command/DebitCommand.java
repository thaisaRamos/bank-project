package br.com.bank.pattern.command;

import br.com.bank.model.Account;

public class DebitCommand implements IBankCommand{
	private Account account;
	private double cash;
	
	public DebitCommand(Account account, double cash) {
		this.account = account;
		this.cash = cash;
	}
	
	@Override
	public Account execute() {
		if (cash <= account.getCash()) {
			account.setCash(account.getCash()-cash);
			return account;
		}
		return null;
	}

}
