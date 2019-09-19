package ch01.ex15;

public class LookupContener implements LookupList {

	private Object[] obj_;
	private String[] names_;
	private int counter_;

	private static final int MAX_LENGTH = 100;

	/**
	 * コンストラクタ
	 */
	public LookupContener() {
		this.obj_ = new Object[MAX_LENGTH];
		this.names_ = new String[MAX_LENGTH];
		this.counter_ = 0;
	}


	@Override
	public Object find(String name) {
		for (int i = 0; i < names_.length; i++) {
			if(this.names_[i] == null )
				return null;
			if(this.names_[i].equals(name)) {
				return this.obj_[i];
			}
		}
		return null;
	}

	@Override
	public void add(Object obj, String name) {
		if (obj == null )
			throw new NullPointerException("obj is null");
		if ( name == null )
			throw new NullPointerException("obj is null");
		if ( name == "" )
			throw new IllegalArgumentException("name is blank");

		int count = currentCounter();
		this.obj_[count] = obj;
		this.names_[count] = name;
		addCounter();
	}

	@Override
	public void remove(String name) {
		if ( name == null )
			throw new NullPointerException("obj is null");
		if ( name == "" )
			throw new IllegalArgumentException("name is blank");

		for (int i = 0; i < this.names_.length; i++) {
			if(this.names_[i] == null) {
				return;
			}
			if(this.names_[i].equals(name)) {
				this.obj_[i] = "";
				this.names_[i] = "";
				return;
			}
		}
	}

	/**
	 * 現在のカウンタ値を取得する
	 * @return
	 */
	private int currentCounter() {
		return this.counter_;
	}


	/**
	 * 現在のカウンタ値に１追加する
	 * @return
	 */
	private void  addCounter() {
		this.counter_++ ;
	}
}
