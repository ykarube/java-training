package ch05.ex05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ex05 {
	public static void main(String[] args) {
		LocalDate birthDay = LocalDate.of(1988, 5, 8);
		LocalDate today = LocalDate.now();

		long days = ChronoUnit.DAYS.between(birthDay, today);
		System.out.println(days + "日");
	}
}