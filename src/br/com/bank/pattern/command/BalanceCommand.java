package br.com.bank.pattern.command;

import br.com.bank.model.Account;

public class BalanceCommand implements IBankCommand{

	private Account account;
	
	public BalanceCommand(Account account) {
		this.account = account;
	}
	
	@Override
	public String execute() {
		return String.valueOf(account.getCash());
	}

}
