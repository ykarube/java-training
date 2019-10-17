package ch03.ex06;

/**
 * 練習問題3.1
 * Vehicleを拡張してPassengerVehicleを作成する
 * 座席数と現在座っている人数を返す機能を追加する
 * mainを定義し、PassengerVehicleオブジェクトを複数追加して表示するようにすること
 */
public class PassengerVehicle extends Vehicle {

	private final int  seatNum_;
	private int ridePersonNum_;

	/**
	 * コンストラクタ
	 * @in String owner 最初の所有者
	 * @in myID 車の識別番号
	 * @in seatNum 座席の数
	 */
	public PassengerVehicle(String owner, long myID, int seatNum, EnergySource energySource ) {
		super(owner, myID, energySource);
		this.seatNum_ = seatNum;
		this.ridePersonNum_ = 0;
	}

	/**
	 * 座席数を取得する
	 * @return
	 */
	public int getSeatNum_() {
		return seatNum_;
	}

	/**
	 * 現在座っている人数を取得する
	 * @return
	 */
	public int getRidePerson() {
		return this.ridePersonNum_;
	}

	/**
	 * 乗車する人数を追加する
	 *
	 * @param rideNum 乗車する人数
	 * @throws IllegalStateException 乗車人数が座席数より超える場合
	 */
	public void addRidePerson(final int rideNum) {
		if (this.seatNum_ < this.ridePersonNum_ + rideNum ) {
			throw new IllegalStateException( "over capacity vehicle's seat size" );
		}
		this.ridePersonNum_ += rideNum;
	}

	/**
	 * 乗車する人数を減算する
	 *
	 * @param rideNum 乗車する人数
	 * @throws IllegalStateException 乗車する人がいなかった場合 または 乗車している人数より下車する人数が多い場合
	 */
	public void removeRidePerson(final int rideNum) {
		if (this.ridePersonNum_ ==  0 || this.ridePersonNum_ - rideNum < 0) {
			throw new IllegalStateException( "no ride person" );
		}
		this.ridePersonNum_ -= rideNum;
	}

//--------------------------------------------------------------------------------------------//
	public static void main(String[] args) {
		PassengerVehicle kei = new PassengerVehicle("kei_owner", 001, 4, new GasTank(10,1));
		PassengerVehicle normal = new PassengerVehicle("normal_owner", 002, 5, new GasTank(1000,10));
		PassengerVehicle wagon = new PassengerVehicle("wagon_owner", 003, 8, new Battery(10));

		kei.addRidePerson(3);
		normal.addRidePerson(2);
		wagon.addRidePerson(3);

		System.out.printf( "owner = %s, seatNum = %d, rideNum= %d \n", kei.getOwner(), kei.getSeatNum_(), kei.getRidePerson());
		System.out.printf( "owner = %s, seatNum = %d, rideNum= %d \n", normal.getOwner(), normal.getSeatNum_(), normal.getRidePerson());
		System.out.printf( "owner = %s, seatNum = %d, rideNum= %d \n", wagon.getOwner(), wagon.getSeatNum_(), wagon.getRidePerson());
	}


}
