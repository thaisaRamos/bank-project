package br.com.bank.persistence;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;

import br.com.bank.model.Account;
import br.com.bank.model.User;


public class Reader {

	private StorageMemory sm;
	private Scanner scanner;

	public void readFile(String fileName) throws FileNotFoundException {

		scanner = new Scanner(new FileReader(fileName));

		sm = StorageMemory.getInstance();

		System.out.println("Lendo matriz de custos e arestas:");

		//guarda os dados em MemoriaDB

		while (scanner.hasNext()) {

			User new_user = new User();
			Account new_acc = new Account();

			if (scanner.hasNext()) {

				String actualLine = scanner.next();
				String actualLine_part[] = actualLine.split(Pattern.quote(";"));
				new_user.setName(actualLine_part[0]);
				new_user.setCpf(actualLine_part[1]);
				new_acc.setAgencyNumber(actualLine_part[2]);
				new_acc.setAccountNumber(actualLine_part[3]);
				new_acc.setCash(100);
				sm.getAccounts().add(new_acc);
			}
		}
	}

	public StorageMemory getSm(){
		return sm;
	}
}


