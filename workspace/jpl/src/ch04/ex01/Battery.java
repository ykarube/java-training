package ch04.ex01;

/**
 * バッテリークラス
 */
public class Battery implements EnergySource {

	private int power = 0;
	private final int size;
	private int nenpi;

	public Battery( int nenpi ) {
		this.power = 0;
		this.size = 100;
		this.nenpi = nenpi;
	}

	public boolean empty() {
		if ( this.power == 0 )
			return	true;
		return false;
	}

	public void charge(int enegy) {
		int i = 0;
		if( this.power + enegy >= this.size ) {
			 this.power = 100;
		} else {
			this.power += enegy;
		}
	}

	/**
	 * gasを利用して消費します
	 * @param nenpi 消費するgas
	 * @return true: 利用(gas消費)済 false:gasの容量が不足して利用できない
	 */
	public boolean run() {
		if( this.empty() ) {
			System.out.println( "cannot running...");
			return false;
		}
		this.power -= this.nenpi ;
		return true;
	}

}
