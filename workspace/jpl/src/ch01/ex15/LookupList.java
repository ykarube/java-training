package ch01.ex15;

public interface LookupList extends Lookup {

	/**
	 * Objectとnameを関連付けで保持する
	 * @param obj
	 * @param name
	 */
	public void add ( Object obj, String name );


	/**
	 * nameと関連付けされたObjectを削除し配列に空文字""をセットする
	 * @param name
	 */
	public void remove ( String name );

}
