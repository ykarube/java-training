package ch14.ex03;

/**
 * ex14-3.
 * 現在の値を保持し、その値に加算して新たな値を表示するメソッドを持つオブジェクトのクラスを作成
 * そのオブジェクトを生成し、複数のスレッドを生成し、各スレッドからその加算メソッドを繰り返す呼び出すこと
 * 加算の結果が失われないこと
 */
public class Addtion {

	private int current_num;

	public Addtion() {
		this.current_num  = 0;
	}

	public void addPrint(final int num) {
		this.current_num += num;
		System.out.println(this.current_num);
	}

}
