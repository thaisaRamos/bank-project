package br.com.bank.model;

import java.io.Serializable;

public class User implements Serializable{

	private String cpf;
	private String name;

	public User(){
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
