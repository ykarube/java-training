package ch14.ex06;

import java.util.List;

/**
 * ex14-6
 * 15秒間隔でメッセージを表示する別のスレッドを持ち、
 * 実行開始からの経過時間を表示するプログラムを作ること
 *
 * メッセージ表示スレッドは、時間表示スレッドから1秒経過するごとに通知されるようにしなさい
 * 時間表示スレッドを修正することなく、7秒間隔で異なるメッセージを表示する別のスレッドを追加しなさい
 */
public class CountTimerThread extends Thread {

	private int interval;
	private List<MessagePrintThread> messagePrintThreadList;
	public CountTimerThread(final int interval, final List<MessagePrintThread> list) {
		this.interval = interval;
		this.messagePrintThreadList = list;
	}

	@Override
	public void run() {
		int count = 1;
		while(true) {
			System.out.println( "countTimer:" + count);
			count++;

			try {
				Thread.sleep(interval);
			} catch (Exception e) {
				System.err.println(e);
			}

			for (MessagePrintThread messagePrintThread : messagePrintThreadList) {
				messagePrintThread.kick();
			}
		}
	}
}
