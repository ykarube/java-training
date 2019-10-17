package ch03.ex06;

/**
 * ガソリンタンク
 */
public class GasTank extends EnergySource {

	private int gas = 0;
	private final int size;
	private final int nenpi;

	/**
	 * コンストラクタ
	 */
	public GasTank( int gasTankSize, int nenpi )  {
		this.gas = 0;
		this.size = gasTankSize;
		this.nenpi = nenpi;
	}

	@Override
	boolean empty() {
		if (this.gas == 0) {
			return true;
		}
		return false;
	}

	@Override
	void charge( int energy ) {
		final int checkSize = this.gas + energy;
		if ( checkSize > size ) {
			throw new IllegalArgumentException(" gas is over.");
		}
		this.gas = checkSize;
	}

	/**
	 * gasを利用して消費します
	 * @param gas 消費するgas
	 * @return true: 利用(gas消費)済 false:gasの容量が不足して利用できない
	 */
	boolean run() {
		if( empty() ) {
			System.out.println( "cannot running...");
			return false;
		}
		this.gas -= nenpi ;
		return true;
	}

	/**
	 * ガソリン残量を取得する
	 * @return int gas
	 */
	public int getGasSize() {
		return this.gas;
	}

}
