package ch01.ex14;

/**
 *
 * Walkman2nd(2端子モデル)に、双方向コミュニケーションを実現したWalkman
 * (音楽を聴きながら話もできる)
 *
 */
public class Walkman3rd extends Walkman2nd {

	private Walkman3rd target_;

	public Walkman3rd() {
		this.target_ = null;
	}

	/**
	 * 双方向コミュニケーション相手と接続する
	 * nullをセットした場合はIllegalStateExceptionをスローする
	 * @param walkman 接続対象
	 */
	public void connect( final Walkman3rd walkman ) {
		if (walkman == null) {
			throw new NullPointerException();
		} else {
			target_ = walkman;
		}
	}

	/**
	 * 接続相手と通信する
	 * 接続相手がいない場合はIllegalStateExceptionをスローする
	 * @param walkman 接続対象
	 *
	 */
	public void communicate(final String conversation){
		if(this.target_ == null ) {
			throw new IllegalStateException("not connected.");
		}
		System.out.println( conversation );
	}

	public void close() {
		this.target_ = null;
	}

}
