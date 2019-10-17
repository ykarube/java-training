package ch05.ex02;

import ch05.ex02.BankAccount.Action;
import ch05.ex02.BankAccount.History;

public class Executer {

	public static void main(String[] args) {
		Executer ex = new Executer();
		ex.execute();
	}


	private static void execute() {
		BankAccount account1 = new BankAccount(1);
		BankAccount account2 = new BankAccount(2);
		account1.deposit(1000);
		account1.withdraw(100);
		account1.transfer(account2, 300);
		History history1 = account1.history();
		History history2 = account2.history();

		Action action = history1.next();
		while(action != null){
			System.out.println(action);
			action = history1.next();
		}
		action = history2.next();
		while(action != null){
			System.out.println(action);
			action = history2.next();
		}

		BankAccount acount3 = new BankAccount(3);
		acount3.deposit(100);
		acount3.deposit(200);
		acount3.deposit(300);
		acount3.deposit(400);
		acount3.deposit(500);
		acount3.deposit(600);
		acount3.deposit(700);
		acount3.deposit(800);
		acount3.deposit(900);
		acount3.deposit(1000);
		acount3.deposit(1100);
		History history3 = acount3.history();
		action = history3.next();
		while(action != null){
			System.out.println(action);
			action = history3.next();
		}

	}



}
