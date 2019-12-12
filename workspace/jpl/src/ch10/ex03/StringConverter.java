package ch10.ex03;

/**
 * 練習問題6.1の「週の曜日」を表すenumを使用して、
 * 曜日を受け取ってその日が働く日であればtrueを返し、そうでなければfalseを返すメソッドを書きなさい
 * 最初にネストしたif-elseを使用して、それからswitch文を使用
 * どちらが明瞭なコードか
 *
 */
//no testCode
public class StringConverter {

	/** 曜日 */
	enum Day {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}

	public static void main(String[] args) {
		System.out.println(isWorkDay(Day.SATURDAY));
		System.out.println(isWorkDay(Day.MONDAY));

		System.out.println(isWorkDaySwitchcase(Day.SATURDAY));
		System.out.println(isWorkDaySwitchcase(Day.MONDAY));


	}


	public static boolean isWorkDay( Day day ) {
		if ( day == Day.SATURDAY ) {
			return false;
		} else if ( day == Day.SUNDAY ) {
			return false;
		} else {
			return true;
		}
	}


	public static boolean isWorkDaySwitchcase( Day day ) {
		switch (day) {
		case SATURDAY:
		case SUNDAY:
			return false;
		default:
			return true;
		}
	}
}