package ch05.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

import ch05.ex02.BankAccount.Action;


public class TestBankAccount {


	@Test
	public void testAccount() {
		BankAccount account1 = new BankAccount(1);
		account1.deposit(1000);
		assertEquals(1000, account1.getBalance());

		account1.withdraw(100);
		assertEquals(900, account1.getBalance());
		try {
			account1.transfer(null, 100);
			fail();
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}

		BankAccount account2 = new BankAccount(2);
		account1.transfer(account2, 100);
		assertEquals(1000, account1.getBalance());
		assertEquals(-100, account2.getBalance());
	}

	@Test
	public void testAction() {
		BankAccount account = new BankAccount(1);
		Action a = account.new Action("user1", 100);

		//コンソール確認
		assertNotNull(a.toString());
		System.out.println(a.toString());
	}

}
