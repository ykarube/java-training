package ch03.ex07;

/**
 * 練習問題3.7
 * CollorAtterに対してequalsとhashCodeをオーバーライドしなさい
 */
public class ColorAttr extends Attr {

	private ScreenColor myColor; //変換された色

	public ColorAttr(String name, Object value) {
		super(name, value);
		decodeColor();
	}
	public ColorAttr(String name) {
		this(name, "transparent");
	}

	public ColorAttr(String name, ScreenColor value ) {
		super(name, value.toString());
		this.myColor = value;
	}

	public Object setValue( Object newValue ) {
		Object retval = super.setValue(newValue);
		decodeColor();
		return retval;
	}


	/** 値を記述ではなくScreenColorに設定する  */
	public ScreenColor setValue(ScreenColor newValue) {
		super.setValue(newValue.toString());
		ScreenColor oldval = myColor;
		this.myColor = newValue;
		return oldval;
	}

	/** 変換されたScreenColorオブジェクトを返す */
	public ScreenColor getColor() {
		return this.myColor;
	}

	/** getValue()で得られる記述からScreenColorを設定する */
	protected void decodeColor() {
		if ( getValue() == null )
			this.myColor = null;
		else
			this.myColor = new ScreenColor(getValue());
	}

	@Override
	public boolean equals(Object obj) {
		if (this.myColor  == obj )
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		int ret = 1;
		ret = 1 + ((myColor == null) ? 0 : myColor.hashCode());
		return ret;
	}
}
