package ch02.ex18;

/**
 * 実行クラス
 *
 * 練習問題2.18
 */
public class Executor {

	public static void main(String[] args) {

		Vehicle[] vechicleList = new Vehicle[100]; //最大100とする.
		for (int i = 0; i < args.length; i++) {
			String name = args[i];
			vechicleList[i] = new Vehicle( name, i );
		}

		for (int i = 0; i < vechicleList.length; i++) {
			if(vechicleList[i] == null) {
				return;
			} else {
				System.out.println(vechicleList[i].toString());
			}
		}
	}

}
