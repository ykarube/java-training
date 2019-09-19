package ch02.ex04;

/**
 * 練習問題2.3
 * 次の乗り物の識別番号を保持するstaticフィールドと
 * 車単位でID番号を保持すうための非staticフィールドをVihicleクラスに追加
 *
 * 練習問題2.4
 * 識別番号はフィールドはfinalとすべきか？
 *
 * (Answer)
 * finalとすべき。理由は
 * 	・車単位で持つIDは、オブジェクトで不変であるべき。
 * 	  (個々の車で異なり、同じ値を持つべきではない)
 * 	・オブジェクト生成時にきめるべき
 *
 */
public class Vehicle {

		public int speed_;		//現在のスピード
		public int angle_;		//方向(角度)
		public String owner_;	//所有者

		public static long nextID_;	//次の乗り物のID
		public long myID_;				//車単位で持つID

}
