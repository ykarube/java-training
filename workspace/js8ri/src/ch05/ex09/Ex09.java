package ch05.ex09;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;

public class Ex09 {
	public static void main(String[] args) {
		final LocalDateTime today = LocalDateTime.now();

		ZoneId.getAvailableZoneIds().stream()
			.map(zone -> ZonedDateTime.of(today, ZoneId.of(zone)))
			.filter(zonedatetime -> Math.abs(zonedatetime.getOffset().getTotalSeconds()) < TimeUnit.HOURS.toSeconds(1))
			.map(zonedatetime -> zonedatetime.getZone())
			.forEach(System.out::println);
	}
}