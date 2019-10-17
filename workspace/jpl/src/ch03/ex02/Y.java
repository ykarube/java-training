package ch03.ex02;

public class Y extends X {
	protected int yMask = 0xff00;

	public Y() {
		fullMask |= yMask;		//a|=b →→ a=a|b と同じ
	}
}
