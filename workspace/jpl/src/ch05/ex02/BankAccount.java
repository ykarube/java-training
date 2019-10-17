package ch05.ex02;

import java.util.LinkedList;

/**
 * 練習問題6.1
 * 週の曜日と信号機の色に対する単純なenumを定義すること
 */
//p118-119
public class BankAccount {
	private long number;
	private long balance;
	protected LinkedList<Action> lastActionList = new LinkedList<Action>();
	private int historyNumber = 0;

	public BankAccount(long number){
		this.number = number;
	}

	private void addLastAct(Action lastAct){
		if(lastActionList.size() == 10)lastActionList.poll();
		lastActionList.addLast(lastAct);
	}
	public History history(){
		return new History();
	}

	/**
	 * Actionクラス
	 *
	 */
	public class Action{
		private String act;
		private long amount;
		Action(String act, long amount){
			this.act = act;
			this.amount = amount;
		}
		public String toString(){
			return number + ":" + act + " " + amount;
		}
	}

	/**
	 * Historyクラス
	 */
	public class History{
		@SuppressWarnings("unchecked")
		private LinkedList<Action> actionList = (LinkedList<Action>)lastActionList.clone();

		public Action next(){
			return actionList.poll();
		}
	}

	/** balanceの取得*/
	public long getBalance() {
		return this.balance;
	}

	public void deposit(long amount){
		balance += amount;
		addLastAct( new Action("deposit", amount));
	}

	public void withdraw(long amount){
		balance -= amount;
		addLastAct( new Action("withdraw", amount));
	}
	public void transfer(BankAccount other, long amount){
		if(other == null) {
			throw new NullPointerException("tranfer account is null");
		}
		other.withdraw(amount);
		deposit(amount);
		addLastAct( this.new Action("transfer", amount));
		other.addLastAct( other.new Action("transer", amount));
	}


}
