package ch05.ex10;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Ex10 {
	public static void main(String[] args) {

		ZonedDateTime flightFrom = ZonedDateTime.of(				// 出発時刻
				LocalDate.now(),
				LocalTime.of(3, 5),
				ZoneId.of("America/Los_Angeles"));

		ZonedDateTime flightTo = flightFrom.plusHours(10).plusMinutes(50);				// 飛行時間を加算
		ZonedDateTime arrivalDateTime = ZonedDateTime.ofInstant(flightTo.toInstant(), ZoneId.of("Europe/Berlin"));				// 到着時刻を現地時間に変換

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
		System.out.println("Arrive time: " + formatter.format(arrivalDateTime));
	}
}