package ch02.ex17;

/**
 * 練習問題6.2 
 * TURN_LEFT,TURNとTURN_RIGHTを表すenumを使用して
 * 練習問題2.17をやり直す
 * enumを利用するとどのような利点があるか
 * 
 * Answer of 6.2
 * コード参照
 * 利点は、メソッドパラメータで型をenumの取りうる値に制限できる
 * 
 * --------------------------------------
 * 練習問題2.17
 * ２つのturnメソッドを追加する
 * １つは引数として回転する角度を受け取り、
 * もう1つは定数Vechicle.TURN_LEFTかTURN_RIGHTを引数として受け取ります
 */
public class Vehicle {

		private int speed_;		//現在のスピード
		private int angle_;		//方向(角度)
		private String owner_;		//所有者

		private static long nextID_;		//次の乗り物の識別番号を保持するstaticフィールド
		private long myID_;				//車単位で持つID

		public static enum Turn {
			TURN_LEFT(-90),
			TURN_RIGHT(90);

			private int angle;
			private Turn( final int angle ) {
				this.angle = angle;
			}
			/*
			 * TURNの方向(角度)を取得する
			 */
			public int getAngle() {
				return angle;
			}
		}

		//コンストラクタより先に実行
		{
			nextID_++;
		}

		/**
		 * コンストラクタ
		 */
		@SuppressWarnings("unused")
		private Vehicle(){
			this.changeSpeed(0);
			this.setAngle(0);
			this.owner_ = null;
			this.myID_ = 0;
		}

		/**
		 * コンストラクタ
		 * @in String owner 最初の所有者
		 */
		Vehicle( final String owner, final long myID ) {
			this();
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
		 * 現在のスピードを変更する
		 * @in int 変更するスピード
		 */
		public void changeSpeed( final int speed) {
			this.speed_ = speed;
		}

		/**
		 * 停止する(スピードを0にする)
		 * @in
		 */
		public void stop() {
			this.speed_ = 0;
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
		 * 現在の方向(角度)から回転させる
		 * @param addTurnAngle 回転する方向(角度)
		 */
		public void turn( int addTurnAngle ){
			this.angle_ += addTurnAngle;
		}

		/**
		 * 現在の方向(角度)から回転させる
		 * @param addTurnAngle 回転する方向(角度)
		 */
		public void turn( Turn turn ){
			this.angle_ += turn.getAngle();
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
