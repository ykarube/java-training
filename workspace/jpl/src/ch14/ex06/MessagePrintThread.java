package ch14.ex06;

/**
 * ex14-6
 * 15秒間隔でメッセージを表示する別のスレッドを持ち、
 * 実行開始からの経過時間を表示するプログラムを作ること
 *
 * メッセージ表示スレッドは、時間表示スレッドから1秒経過するごとに通知されるようにしなさい
 * 時間表示スレッドを修正することなく、7秒間隔で異なるメッセージを表示する別のスレッドを追加しなさい
 */

/**
 * メッセージ表示スレッド
 *
 */
public class MessagePrintThread extends Thread {

	private int count = 1;
	private final int interval;		//表示間隔
	private final String message;		//表示内容


	public MessagePrintThread( int interval, String message ) {
		this.interval = interval;
		this.message = message;
	}


	public synchronized void printMessage(){
		if ( this.count == this.interval) {
			System.out.println(this.message );
			this.count = 1; //初期化
		} else {
			this.count++;
		}
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void kick() {
		notify();
	}

	@Override
	public void run() {
		while(true) {
			printMessage();
		}
	}

}
