package ch14.ex05;

public class Executer implements Runnable{

	private static Subtraction ad = new Subtraction();

	public static void main(String[] args) {

		Executer ex1 = new Executer();
		Executer ex2 = new Executer();
		Executer ex3 = new Executer();

		Thread th1 = new Thread(ex1);
		Thread th2 = new Thread(ex2);
		Thread th3 = new Thread(ex3);

		th1.start();
		th2.start();
		th3.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			ad.subPrint(1);
		}

	}
}
