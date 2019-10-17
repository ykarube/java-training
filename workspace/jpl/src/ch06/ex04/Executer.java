package ch06.ex04;

/**
 * 練習問題6.4
 * 132項の練習問題6.1の信号機の色のenumを修正して
 * 各enum定数が適切なカラーオブジェクトを持ち、そのオブジェクトをgetColor
 * でとれるようにしなさい
 *
 * ｑ： Stringじゃなくて、
 * Colorクラスを定義してサブクラスで色(赤青黄)作成してEnum定数にもたせる？
 */
public class Executer {

	/** 信号 */
	public enum Signal {
		RED("RED"),
		YELLOW("YELLOW"),
		BLUE("BLUE");

		private String color;

		private Signal(String color){
			this.color = color;
		}

		public String getColor(){
			return color;
		}
	}


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
