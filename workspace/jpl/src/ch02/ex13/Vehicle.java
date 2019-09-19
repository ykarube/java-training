package ch02.ex13;

/**
 * 練習問題2.13
 * Vehicleクラスのフィールドをprivateにして、フィールドに対するアクセッサ―メソッドを追加
 * どのフィールドが変更を許すメソッドを持ち、どのフィールドがそのようなメソッドを持つべきではないのか
 */
public class Vehicle {

		private int speed_;		//現在のスピード
		private int angle_;		//方向(角度)
		private String owner_;		//所有者

		private static long nextID_;		//次の乗り物の識別番号を保持するstaticフィールド
		private long myID_;				//車単位で持つID

		//コンストラクタより先に実行
		{
			nextID_++;
		}

		/**
		 * コンストラクタ
		 */
		@SuppressWarnings("unused")
		private Vehicle(){
			this.setSpeed(0);
			this.setAngle(0);
			this.owner_ = null;
			this.myID_ = 0;
		}

		/**
		 * コンストラクタ
		 * @in String owner 最初の所有者
		 */
		Vehicle( final String owner, final long myID ) {
			this.setSpeed(0);
			this.setAngle(0);
			this.owner_ = owner;
			this.myID_ = myID;
		}

		/**
		 * toStringのオーバーライド.
		 * 所有者(owner)と車単位の識別ID(myID)を出力する
		 * @Override
		 */
		public String toString() {
			String str;
			str = "owner:" + this.owner_ + ", id:" + this.myID_;
			return str;
		}

		/**
		 * 次の乗り物の識別番号を返却する
		 * @return long 次の乗り物の識別番号
		 */
		public static long getNextID() {
			return Vehicle.nextID_;
		}

		/**
		 * 現在のスピードを取得する
		 * @return int スピード
		 */
		public int getSpeed() {
			return speed_;
		}

		/**
		 * 現在のスピードを設定する
		 * @in int スピード
		 */
		public void setSpeed( final int speed) {
			this.speed_ = speed;
		}

		/**
		 * 現在の方向(角度)を取得する
		 * @return int 方向(角度)
		 */
		public int getAngle() {
			return angle_;
		}

		/**
		 * 現在の方向(角度)を設定する
		 * @in int 方向(角度)
		 */
		public void setAngle( final int angle) {
			this.angle_ = angle;
		}


		/**
		 * 現在の所有者を取得する
		 * @return String 所有者
		 */
		public String getOwner() {
			return this.owner_;
		}

		/**
		 * 現在の所有者を設定する
		 * @in String 所有者
		 */
		public void setOwner( final String owner) {
			this.owner_ = owner;
		}


		/**
		 * 車単位で持つIDを取得する
		 * @return int 車のID
		 */
		public long getMyID() {
			return this.myID_;
		}
}
