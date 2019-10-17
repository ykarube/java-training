package dc1_1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DigitalClockAdapter  extends WindowAdapter{

	/**
	 * [×]を押され時の処理
	 * System(Frame)を終了させる。
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

}
