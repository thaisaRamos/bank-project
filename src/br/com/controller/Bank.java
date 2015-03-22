package br.com.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import sun.security.jca.GetInstance;
import br.com.bank.model.Account;
import br.com.bank.pattern.command.BalanceCommand;
import br.com.bank.pattern.command.CreditCommand;
import br.com.bank.pattern.command.DebitCommand;
import br.com.bank.pattern.command.IBankCommand;
import br.com.bank.persistence.StorageMemory;

@ManagedBean (name = "bank")
@RequestScoped
public class Bank implements Serializable {

	private String accNumber;
	private String agNumber;
	private double debitValue;
	private double creditValue;
	private String balanceValue;

	//transfer
	private String sAccNumber;
	private String sAgNumber;
	private String tAccNumber;
	private String tAgNumber;
	private double transferValue;
	private String sourceBalance;
	private String targetBalance;
	
	private List<Account> accountsList = new ArrayList<Account>();
	
	private StorageMemory storage;
	private IBankCommand bank;

	private final String bankWelcome = "Welcome to the bank!";

	public Bank(){
		storage = StorageMemory.getInstance();
	}

	/*
	@PostConstruct
	public void initStorage() {
		storage.makeInitialStorage();
	}
	*/
	
	public String getBankWelcome() {
		return bankWelcome;
	}

	public String doOperations(){

		Account acc = storage.getAccount(this.accNumber, this.agNumber);
		
		bank = new CreditCommand(acc, creditValue);
		bank.execute();

		bank = new DebitCommand(acc, debitValue);
		bank.execute();

		bank = new BalanceCommand (acc);
		balanceValue = (String) bank.execute();

		return "result.xhtml";
	}
	
	public String doTransfer() {
		Account sourceAcc = storage.getAccount(this.sAccNumber, this.sAgNumber);
		Account targetAcc = storage.getAccount(this.tAccNumber, this.tAgNumber);
		
		bank = new DebitCommand(sourceAcc, transferValue);
		bank.execute();
		
		bank = new CreditCommand(targetAcc, transferValue);
		bank.execute();

		bank = new BalanceCommand (sourceAcc);
		sourceBalance = (String) bank.execute();	
		
		bank = new BalanceCommand (targetAcc);
		targetBalance = (String) bank.execute();
		
		return "transferResult.xhtml";
	}
	
	public String toListAccounts() {
		accountsList = storage.getInstance().getAccounts();
		return "accountsList.xhtml";
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public String getAgNumber() {
		return agNumber;
	}

	public void setAgNumber(String agNumber) {
		this.agNumber = agNumber;
	}

	public double getDebitValue() {
		return debitValue;
	}

	public void setDebitValue(double debitValue) {
		this.debitValue = debitValue;
	}

	public double getCreditValue() {
		return creditValue;
	}

	public void setCreditValue(double creditValue) {
		this.creditValue = creditValue;
	}

	public String getBalanceValue() {
		return balanceValue;
	}

	public void setBalance(String balanceValue) {
		this.balanceValue = balanceValue;
	}

	public String getsAccNumber() {
		return sAccNumber;
	}

	public void setsAccNumber(String sAccNumber) {
		this.sAccNumber = sAccNumber;
	}

	public String getsAgNumber() {
		return sAgNumber;
	}

	public void setsAgNumber(String sAgNumber) {
		this.sAgNumber = sAgNumber;
	}

	public String gettAccNumber() {
		return tAccNumber;
	}

	public void settAccNumber(String tAccNumber) {
		this.tAccNumber = tAccNumber;
	}

	public String gettAgNumber() {
		return tAgNumber;
	}

	public void settAgNumber(String tAgNumber) {
		this.tAgNumber = tAgNumber;
	}

	public double getTransferValue() {
		return transferValue;
	}

	public void setTransferValue(double transferValue) {
		this.transferValue = transferValue;
	}

	public String getSourceBalance() {
		return sourceBalance;
	}

	public void setSourceBalance(String sourceBalance) {
		this.sourceBalance = sourceBalance;
	}

	public String getTargetBalance() {
		return targetBalance;
	}

	public void setTargetBalance(String targetBalance) {
		this.targetBalance = targetBalance;
	}

	public StorageMemory getStorage() {
		return storage;
	}

	public void setStorage(StorageMemory storage) {
		this.storage = storage;
	}

	public IBankCommand getBank() {
		return bank;
	}

	public void setBank(IBankCommand bank) {
		this.bank = bank;
	}

	public void setBalanceValue(String balanceValue) {
		this.balanceValue = balanceValue;
	}

	public List<Account> getAccountsList() {
		return accountsList;
	}

	public void setAccountsList(List<Account> accountsList) {
		this.accountsList = accountsList;
	}
}