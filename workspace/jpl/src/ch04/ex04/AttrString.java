package ch04.ex04;

public class AttrString implements Attr<String>{

	private final String name;
	private String value;

	public AttrString (String name) {
		this.name = name;
		this.value = null;
	}


	public AttrString( String name, String value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "attr name:" +  this.name + ", value: " + this.value;
	}

}
