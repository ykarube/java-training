package ch02.ex05;

/**
 * 練習問題2.5
 * Vehicleクラスにmainメソッドを書いて、
 * 数個の乗り物を作成し、それらのオブジェクトのフィールドの値を表示すること
 */
public class Vehicle {

		public int speed_;		//現在のスピード
		public int angle_;		//方向(角度)
		public String owner_;	//所有者

		public static long nextID_;	//次の乗り物のID
		public long myID_;				//車単位で持つID

		/**
		 * main関数
		 */
		public static void main(String[] args) {
			execute();
		}

		/**
		 * 練習問題の実行関数
		 */
		public static void execute() {
			Vehicle toyota = new Vehicle();
			toyota.nextID_ =+ 1 ;
			out(toyota);

			System.out.println("----");
			Vehicle nissan = new Vehicle();
			nissan.speed_ = 60;
			nissan.angle_ = 90;
			nissan.owner_ = "taro";
			nissan.myID_ = 100;
			nissan.nextID_ =+ 1 ;
			out(nissan);
		}

		/**
		 * 文字列出力関数
		 * @in Vehicle target 出力関数
		 */
		public static void out(final Vehicle target ) {
			System.out.println("angle :" + target.angle_);
			System.out.println("speed :" + target.speed_);
			System.out.println("owner :" + target.owner_);
			System.out.println("myID  :" + target.myID_);
			System.out.println("nextID:" + target.nextID_);
		}

}
