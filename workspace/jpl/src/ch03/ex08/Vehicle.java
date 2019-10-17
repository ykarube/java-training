package ch03.ex08;

/**
 * 練習問題3.06からコピー
 *
 * 練習問題3.08
 * VehicleとPassengerVehicleをClonableにしなさい
 * 複製に関して、4つの選択肢のどれを選択すべきでしょうか
 * ObjectCloneによる単純なコピーはそれらのクラスのcloneメソッドとしては正しいでしょうか
 */
public class Vehicle implements Cloneable{

		private int speed_;		//現在のスピード
		private int angle_;		//方向(角度)
		private String owner_;		//所有者

		private static long nextID_;		//次の乗り物の識別番号を保持するstaticフィールド
		private long myID_;				//車単位で持つID

		private EnergySource energySource_;


		/**
		 * 練習問題 3.8 回答
		 * プリミティブ型以外のメンバのcloneを作成
		 * よってEnegySouceのメンバのcloneを作成。（このときEnegySourceもcloneサポート)
		 */
		protected Vehicle clone(){
		// TODO 自動生成されたメソッド・スタブ
			Vehicle clone = null;
			try {
				clone  = (Vehicle)super.clone();
				clone.energySource_ =this.energySource_.clone();
			} catch (CloneNotSupportedException e) {
				//can not happen,
				//クローンサポート済み.
				throw new InternalError(e.toString());
			}

			return clone;
		}


		public static enum Turn {
			TURN_LEFT(-90),	/** 左90度回転(-90度) */
			TURN_RIGHT(90);	/** 右90度回転(+90度)) */

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
			this.energySource_ = null;
		}

		/**
		 * コンストラクタ
		 * @in String owner 最初の所有者
		 * @in myID 車の識別番号
		 */
		public Vehicle( final String owner, final long myID, final EnergySource energySource ) {
			this();
			this.owner_ = owner;
			this.myID_ = myID;
			this.energySource_ = energySource;
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
			this.angle_ = turn.getAngle();
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

		/**
		 * 練習問題3.6
		 * vehicleをエンジンスタートを実施する
		 * energyが空の場合は、IllegalStateExcptionをスローします。
		 */
		public void start() {
			if(this.energySource_.empty()) {
				throw new IllegalStateException(" energySorce is empty. cannnot start.");
			}
			while ( !this.energySource_.empty() ) {
				this.energySource_.run();
				System.out.println(" running.... ");
			}
			System.out.println("stop");
		}
}
