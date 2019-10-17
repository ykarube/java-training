package dc1_1;

import java.awt.Frame;
import java.awt.Graphics;
import java.util.Calendar;

/** 課題1-1
 * AWTを使用すること。Swingは不可
 *
 * AWTのFrameを使用して、時間を表示するデジタル時計を作成してください
 * ●java.awt.Frameを使用する
 * ●Windowsの普通のアプリケーションと同様にタイトルバーの「×」ボタンを
 *   クリックすると終了する
 * ●デジタル時計の描画はpaintメソッド内でGraphicsを使用して行う
 *   テキストラベルによる単なる表示は不可
 *
 */
public class DigitalClock extends Frame implements Runnable{

	private static final DigitalClock frame = new DigitalClock();
	private static final Thread thread = new Thread(frame);

	public DigitalClock() {
		super("Digital Clock:dc1_1");
	}

	public void init() {
		frame.setSize(500, 200);
		frame.setVisible(true);
		frame.addWindowListener(new DigitalClockAdapter());
	}

	@Override
	public void paint(Graphics g) {
		int x = 250;				//適宜x,yは調整
		int y = 100;
		String time = getCurrentTime();
		g.drawString(time, x, y);
	}

	private String getCurrentTime() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		int minute = Calendar.getInstance().get(Calendar.MINUTE);
		int second = Calendar.getInstance().get(Calendar.SECOND);
		return ( hour + ":" + minute + ":" + second );
	}

	public static void main(String[] args) {
		DigitalClock dc = new DigitalClock();
		dc.init();
		thread.start();
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
	}

}
