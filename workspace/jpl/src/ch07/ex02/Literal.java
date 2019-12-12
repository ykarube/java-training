package ch07.ex02;

/**
 * 練習問題7.2
 *
 * 数値である各基本データのフィールドを宣言しているクラスを作成して
 * 異なる式を使用して値を代入してみなさい。たとえばint フィル―ドに3.5fを代入してみるとか。
 * どのリテラルがどのフィールド型と一緒に使用できますか
 * 値の大きさを変えてどのような影響があるか調べなさい。
 *
 */
public class Literal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int i = 0;
		byte b = 0;
		char c = 'a';
		short s = 0;
		long l = 0;
		float f = 0;
		double d = 0;
		i = b;
		System.out.println(i);
		i = c;
		System.out.println(i);
		i = s;
		System.out.println(i);

		//i=3.5f;
		//Exception in thread "main" java.lang.Error: Unresolved compilation problem:
		//型の不一致: float から int には変換できません

		//i=l;
		//Exception in thread "main" java.lang.Error: Unresolved compilation problem:
		//型の不一致: long から int には変換できません


	}
}
