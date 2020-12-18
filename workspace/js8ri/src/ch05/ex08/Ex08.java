package ch05.ex08;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Ex08 {
	public static void main(String[] args) {
		final LocalDateTime today = LocalDateTime.now();

		ZoneId.getAvailableZoneIds().stream()
			.map(zone -> ZonedDateTime.of(today, ZoneId.of(zone)).getOffset())
			.forEach(System.out::println);
	}
}
