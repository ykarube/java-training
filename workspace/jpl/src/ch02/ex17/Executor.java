package ch02.ex17;

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
		toyota.setAngle(180);
		System.out.println( "before:" + toyota.getAngle());
		toyota.turn(90);
		System.out.println( "after:" + toyota.getAngle());

		System.out.println("----");
		Vehicle nissan = new Vehicle( "jiro", 456 );
		nissan.setAngle(90);
		System.out.println( "before:" + nissan.getAngle());
		nissan.turn( Vehicle.Turn.TURN_LEFT);
		System.out.println( "after:" + nissan.getAngle());
	}

}
