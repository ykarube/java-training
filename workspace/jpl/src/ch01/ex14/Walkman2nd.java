package ch01.ex14;

/**
 *
 * Walkmanの第2世代
 * 1端子→2端子に拡張
 *
 */
public class Walkman2nd extends Walkman {

	/** 2個目の端子*/
	private Terminal terminal2nd_;

	/**
	 * コンストラクタ
	 */
	Walkman2nd(){
		super();
		this.terminal2nd_ = new Terminal();
	}


	@Override
	public void start() {
		Tape tape = getTape();
		if(tape != null) {
			super.start();
			System.out.println(this.terminal2nd_.hashCode() + this.terminal2nd_.out(tape.play() ));
		}
	}
}
