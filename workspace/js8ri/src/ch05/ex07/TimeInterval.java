package ch05.ex07;

import java.time.LocalDateTime;


public class TimeInterval {
	private LocalDateTime begin, end;

	/**
	 * コンストラクタ
	 * @param begin 始端
	 * @param end 終端
	 */
	private TimeInterval(LocalDateTime begin, LocalDateTime end) {
		this.begin = begin;
		this.end = end;
	}

	/**
	 * インスタンス生成
	 * @param begin 区間の端1
	 * @param end 区間の端2
	 * @return 自インスタンス
	 */
	public static TimeInterval of(LocalDateTime begin, LocalDateTime end) {
		if(begin.isAfter(end)){
			return new TimeInterval(end, begin);
		} else {
			return new TimeInterval(begin, end);
		}
	}

	/**
	 * 始端取得
	 * @return 始端
	 */
	public LocalDateTime GetBegin() {
		return this.begin;
	}

	/**
	 * 終端取得
	 * @return 終端
	 */
	public LocalDateTime GetEnd() {
		return this.end;
	}

	/**
	 * 2つのインターバルの重なりチェック
	 * @param x インターバル1
	 * @param y インターバル2
	 * @return true: 重なりあり。 false: 重なり無し
	 */
	public static boolean intersectWith(TimeInterval x, TimeInterval y) {
		return !x.begin.isAfter(y.end) && !y.begin.isAfter(x.end);
	}
}
