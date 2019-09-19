package ch01.ex14;

/*
 * 練習問題1.14
 * この説で述べたソニーウォークマン製品ファミリーのクラス構造を反映している
 * クラスを設計すること
 * 全てのデータをPrivateとし、メソッドをPublicとする
 * データを隠すためにメソッドを使用すること
 * Walkmanクラスではどのようなメソッドが必要か
 * どのメソッドが拡張されたクラスに追加するかW
 */
public class Exercise14 {

	public static void main(String[] args) {
		execute();
	}

	/**
	 * 練習問題の実行
	 */
	public static void execute() {
		Walkman3rd walkman = new Walkman3rd();

		System.out.println("====Walkman Function================");
		walkman.setTape(new Tape());
		((Walkman)walkman).start();

		System.out.println("====Walkman2nd Function================");
		walkman.start();

		System.out.println("====Walkman3rd Function================");
		Walkman3rd target = new Walkman3rd();
		walkman.connect(target);
		walkman.communicate("hello");
		walkman.close();
	}

}
