package ch01.ex14;

/**
 * 練習問題1.14
 * 1人がテープを聞くための1個の端子のみ
 * 次のモデルではテープを2人で聞けるように端子が２つ.
 *
 * 2端子モデルでテープを共有しながらお互いには足がしたいと顧客が要望
 * 音楽を聴きながら話ができるように双方向コミュニケーションができる機能を
 * 2端子モデルに追加した
 * このコミュニケーションモデルは2端子モデルのサブクラスであり振る舞いを
 * 全て継承し再度新しい機能を追加している
 *
 *
 * Walkmanクラス
 * 端子１つがあり、Tapeをセットし再生、停止ができる
 *
 */
public class Walkman {

	private Terminal terminal_socket_; 	//端子ソケット
	private Tape tape_;					//テープ


	/**
	 * 初期化
	 */
	Walkman(){
		this.terminal_socket_ = new Terminal();
		this.tape_ = null;
	}

	/**
	 * 再生
	 */
	public void start() {
		if( this.tape_ != null ) {
			System.out.println(this.terminal_socket_.hashCode() + this.terminal_socket_.out( this.tape_.play() ));
		} else {
			//何もしない
		}
	}

	/**
	 * 停止
	 */
	public void stop() {
		if( this.tape_ != null ) {
			System.out.println(this.tape_.pause());
		} else {
			//何もしない
		}
	}


	/**
	 * Terminal(端子)をWalkmanにセットする
	 */
	public void setTerminal(final Terminal terminal ) {
		this.terminal_socket_ = terminal;
	}

	/**
	 * Tape(テープ)をWalkmanにセットする
	 */
	public void setTape(final Tape tape ) {
		this.tape_ = tape;
	}


	/**
	 * Tape(テープ)をWalkmanにセットする
	 */
	public Tape getTape() {
		return this.tape_;
	}

	/**
	 * Tape(テープ)をWalkmanにセットする
	 */
	public Terminal getTerminal() {
		return this.terminal_socket_;
	}

}
