package br.com.bank.pattern.command;

import br.com.bank.model.Account;

public class TransferCommand implements IBankCommand{

	private Account accountDebit;
	private Account accountCredit;
	private double cash;
	
	public TransferCommand(Account accountDebit, Account accountCredit, double cash) {
		this.accountCredit = accountCredit;
		this.accountDebit = accountDebit;
		this.cash = cash;
	}
	
	@Override
	public Account execute() {
		if (cash <= accountDebit.getCash()) {
			accountCredit.setCash(accountCredit.getCash()+cash);
			accountDebit.setCash(accountDebit.getCash()-cash);
			return accountCredit;
		}
		return null;
		
	}

}
