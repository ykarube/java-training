package ch02.ex07;

/**
 * 練習問題2.5
 * Vehicleクラスに2つのコンストラクタを追加しなさい
 * 1つは引数なしコンストラクタで、もう1つは最初の所有者の名前を引数にとる
 * mainプログラムを修正して前回と同じ出力が生成されるようにしなさい。
 *
 */
public class Vehicle {

		public int speed_;		//現在のスピード
		public int angle_;		//方向(角度)
		public String owner_;	//所有者

		public static long nextID_;	//次の乗り物のID
		public long myID_;				//車単位で持つID

		//コンストラクタより先に実行
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
			out(toyota);

			System.out.println("----");
			Vehicle nissan = new Vehicle( "taro" );
			nissan.speed_ = 60;
			nissan.angle_ = 90;
			nissan.myID_ = 100;
			out(nissan);

			System.out.println("----");
			Vehicle honda = new Vehicle( "jiro" );
			honda.speed_ = 77;
			honda.angle_ = 180;
			honda.owner_ = "jiro";
			honda.myID_ = 1000;
			out(honda);

		}

		public static void out(final Vehicle target ) {
			System.out.println("angle :" + target.angle_);
			System.out.println("speed :" + target.speed_);
			System.out.println("owner :" + target.owner_);
			System.out.println("myID  :" + target.myID_);
			System.out.println("nextID:" + target.nextID_);

		}

}
