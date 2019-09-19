package ch02.ex09;

/**
 * 練習問題2.9
 * Vehicleクラスにいままで使われた識別番号の最大値を返すstaticメソッドを追加
 */
public class Vehicle {

		public int speed_;		//現在のスピード
		public int angle_;		//方向(角度)
		public String owner_;	//所有者

		public static long nextID_;	//次の乗り物の識別番号を保持するstaticフィールド
		public long myID_;				//車単位で持つID

		//(memo)コンストラクタより先に実行
		{
			this.nextID_++;
		}

		/**
		 * コンストラクタ
		 */
		Vehicle(){
			this.speed_ = 0;
			this.angle_ = 0;
			this.owner_ = null;
			this.myID_ = 0;
		}

		/**
		 * コンストラクタ
		 * @in String owner 最初の所有者
		 */
		Vehicle( String owner ) {
			this.speed_ = 0;
			this.angle_ = 0;
			this.owner_ = owner;
			this.myID_ = 0;
		}

		/**
		 * 次の乗り物の識別番号を返却する
		 * @return long 次の乗り物の識別番号
		 */
		public static long getNextID() {
			return Vehicle.nextID_;
		}


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
			System.out.println("■netNextID=" + getNextID());
			out(toyota);
			System.out.println("■netNextID=" + getNextID());

			System.out.println("----");
			Vehicle nissan = new Vehicle( "taro" );
			nissan.speed_ = 60;
			nissan.angle_ = 90;
			nissan.myID_ = 100;
			out(nissan);
			System.out.println("■netNextID=" + getNextID());


			System.out.println("----");
			Vehicle honda = new Vehicle( "jiro" );
			honda.speed_ = 77;
			honda.angle_ = 180;
			honda.owner_ = "jiro";
			honda.myID_ = 1000;
			out(honda);
			System.out.println("■netNextID=" + getNextID());

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
