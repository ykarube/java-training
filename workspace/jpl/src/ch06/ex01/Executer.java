package ch06.ex01;

public class Executer {

	/** 曜日 */
	enum Day {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}

	/** 信号 */
	enum Signal {
		BLUE, YELLOW, RED
	}

	public static void main(String[] args) {
		execute();
		execute(Signal.YELLOW);
	}

	public static void execute() {
		System.out.println(Day.SUNDAY + "," + Day.MONDAY  + Day.WEDNESDAY);
		System.out.println(Signal.BLUE);
	}

	public static void execute( Signal color) {
		if( color == Signal.BLUE) {
			System.out.println("blue");
		} else if (color == Signal.RED) {
			System.out.println("red");

		} else if (color == Signal.YELLOW) {
			System.out.println("yellow");
		}
		else {
			System.out.println("err");
		}

	}



}
