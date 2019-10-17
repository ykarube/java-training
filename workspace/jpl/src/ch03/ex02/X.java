package ch03.ex02;

public class X {

	protected int xMask = 0x00ff;
	protected int fullMask = 0x00ff;

	public X() {
		fullMask = xMask;
	}

	public int mask( int orig ) {
		return ( orig & fullMask );
	}

}
