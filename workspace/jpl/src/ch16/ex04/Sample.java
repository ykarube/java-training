package ch16.ex04;

public class Sample extends Thread {

	@HogeAnnotation("constructor")
	public Sample() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@HogeAnnotation("override method")
	public void run() {
		// TODO 自動生成されたメソッド・スタブ
		super.run();
	}


	public class InnerClassSample {
	}

	public class InnerClassSample2 implements Runnable{
		@Override
		public void run() {
			// TODO 自動生成されたメソッド・スタブ

		}
	}
}
