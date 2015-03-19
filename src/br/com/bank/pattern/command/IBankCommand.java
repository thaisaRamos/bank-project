package br.com.bank.pattern.command;

import br.com.bank.model.Account;

public interface IBankCommand {
	public Object execute();
}
