package ch02.ex13;

/**
 * 実行クラス
 */
public class Executor {

	public static void main(String[] args) {
		execute();
	}

	/**
	 * 練習問題を実行する
	 */
	public static void execute() {
		Vehicle toyota = new Vehicle( "taro", 123 );
		System.out.println(toyota.toString());

		System.out.println("----");
		Vehicle nissan = new Vehicle( "jiro", 456 );
		nissan.setSpeed(60);
		nissan.setAngle(90);
		System.out.println(nissan.toString());

		System.out.println("----");
		Vehicle honda = new Vehicle( "saburo", 789 );
		honda.setSpeed(77);
		honda.setAngle(180);
		System.out.println(honda.toString() + ", speed:" + honda.getSpeed() +
				", angle" + honda.getAngle() + ", nextID:" + honda.getNextID());

	}

}
