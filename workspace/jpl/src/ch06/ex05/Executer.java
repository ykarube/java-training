package ch06.ex05;


/**
 * 練習問題6.5
 * 練習問題6.4で、getColorをabstractとして、
 * 各enum定数が正しいcolorオブジェクトを返すように
 * 定数固有のメソッドを定義しなさい
 * colorオブジェクトを返すために定数固有のメソッドを使用することを推奨しますか
 *
 * ■Answer of 6.5
 * 推奨しない。
 * 個々に同様なメソッドがあり、enumのメリットがなく推奨しない。
 */
public class Executer {

	/** 信号 */
	public enum Signal {
		RED{
			@Override
			String getColor() {
				return "red";
			}

		},
		YELLOW{
			@Override
			String getColor() {
				return "yellow";
			}
		},
		BLUE{
			@Override
			String getColor() {
				return "blue";
			}
		};

		abstract String getColor();

/////////////////////////////////////////////////////
	public static void main(String[] args){
		execute();
	}


	public static void execute() {
		System.out.println(Signal.RED.getColor());
		System.out.println(Signal.BLUE.getColor());
		System.out.println(Signal.YELLOW.getColor());
	}

	}
}
