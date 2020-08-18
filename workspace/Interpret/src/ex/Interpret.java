package ex;

/*
	2.4 『プログラミング言語Java 第4 版』| Interpret 課題
 */
//memo

//以下サイトより、JDK ver11→1.8とした
//https://qiita.com/Tsuyoshi_Murakami/items/07c967cc651ad2eb1113
// java9ではMethod#setAccessibleでInaccessibleObjectExceptionが発生しています。
// Jigsawの導入により、Java APIのnon-publicメンバへのアクセスが許可されなくなったためです。

public class Interpret {

	public static void main(String[] args) {
		execute();
	}

	public static void execute() {
		InterpretFrame frame = new InterpretFrame();
		frame.setVisible(true);
	}
}
