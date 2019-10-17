package ch03.ex09;

/**
 * 練習問題3.9
 * 何個かのVehicleオブジェクトを配列に保持できるGarageクラスを作成しなさい
 * GarageをCloneable型にして、適切なcloneメソッドを書きなさい
 * cloneをテストするGarage.mainメソッドを書きなさい
 */
public class Garage implements Cloneable {

	private Vehicle garage[];

	/** コンストラクタ */
	public Garage( final int capacity ) {
		this.garage = new Vehicle[capacity];
	}

	/** garageのcapacity(最大収容サイズ)を取得*/
	public int getCapacity() {
		return this.garage.length;
	}

	/** garageに入庫する */
	public void inGarage (final Vehicle vehicle ) {
		for (int i = 0; i < this.garage.length; i++) {
			Vehicle obj = this.garage[i];
			if( obj == null ) {
				this.garage[i] = vehicle;
				break;
			}
		}
	}

	/** garageから出庫する */
	public Vehicle outGarage (final int parkingNum ) {
		Vehicle ret = null;
		Vehicle obj = this.garage[parkingNum];
		if (obj != null) {
			ret = obj;
		}
		return ret;
	}

	/** Garageに空きがあるか */
	public boolean isEmpty() {
		boolean ret = false;
		for (int i = 0; i < garage.length; i++) {
			if( garage[i] == null )
				ret = true;
		}
		return ret;
	}

	/** ●Answer of ex3.8 */
	@Override
	public Garage clone() {
			try {
				Garage cloneObj = (Garage)super.clone();
				cloneObj.garage = this.garage.clone();
				for (int i = 0; i < this.garage.length; i++) {
					if( this.garage[i] != null )
						cloneObj.garage[i] = (Vehicle)this.garage[i].clone();
				}
				return cloneObj;
			} catch (CloneNotSupportedException e) {
				//cannot happen.
				throw new InternalError(e.toString());
			}
		}

	/** ●Answer of ex3.8 */
	public static void main(String[] args) {
		Vehicle v1 = new Vehicle("first",	1, new GasTank(100, 10));
		Vehicle v2 = new Vehicle("second", 	2, new GasTank(200, 20));
		Vehicle v3 = new Vehicle("third", 	3, new GasTank(300, 30));

		int space = 4;
		Garage originalGarage = new Garage( space );
		originalGarage.inGarage(v1);
		originalGarage.inGarage(v2);
		originalGarage.inGarage(v3);

		Garage cloneGarage = originalGarage.clone();

		System.out.println("######  clone test  ######");
		System.out.println("garage space : " + cloneGarage.getCapacity());
		Vehicle cloneV1 = cloneGarage.outGarage(0);
		Vehicle cloneV2 = cloneGarage.outGarage(1);
		Vehicle cloneV3 = cloneGarage.outGarage(2);

		System.out.println("original hashcode:" + v1.hashCode() + "\t, clone hashcode:" + cloneV1.hashCode() );
		System.out.println("original hashcode:" + v2.hashCode() + "\t, clone hashcode:" + cloneV2.hashCode() );
		System.out.println("original hashcode:" + v3.hashCode() + "\t, clone hashcode:" + cloneV3.hashCode() );

		System.out.println("original owner:" + v1.getOwner() + "\t, clone owner:" + cloneV1.getOwner());
		System.out.println("original owner:" + v2.getOwner() + "\t, clone owner:" + cloneV2.getOwner());
		System.out.println("original owner:" + v3.getOwner() + "\t, clone owner:" + cloneV3.getOwner());

		System.out.println("original myID:" + v1.getMyID() + "\t, clone myID:" + cloneV1.getMyID());
		System.out.println("original myID:" + v2.getMyID() + "\t, clone myID:" + cloneV2.getMyID());
		System.out.println("original myID:" + v3.getMyID() + "\t, clone myID:" + cloneV3.getMyID());

		System.out.println("original nextID:" + v1.getNextID() + "\t, clone nextID:" + cloneV1.getNextID());
		System.out.println("original nextID:" + v2.getNextID() + "\t, clone nextID:" + cloneV2.getNextID());
		System.out.println("original nextID:" + v3.getNextID() + "\t, clone nextID:" + cloneV3.getNextID());

	}
}
