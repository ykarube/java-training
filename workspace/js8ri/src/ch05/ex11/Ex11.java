package ch05.ex11;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Ex11 {
	public static void main(String[] args) {

		ZonedDateTime flightFrom = ZonedDateTime.of(
				LocalDate.now(),
				LocalTime.of(14, 5),
				ZoneId.of("Europe/Berlin"));
		ZonedDateTime arrivalDateTime = ZonedDateTime.of(
				LocalDate.now(),
				LocalTime.of(16, 40),
				ZoneId.of("America/Los_Angeles"));
		Duration flightDuration = Duration.between(flightFrom.toInstant(), arrivalDateTime.toInstant());
		LocalTime flightTime = LocalTime.ofSecondOfDay(flightDuration.getSeconds());

		System.out.println("Flight time: " + flightTime);
	}
}