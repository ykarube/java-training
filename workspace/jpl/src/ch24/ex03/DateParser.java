package ch24.ex03;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateParser {

	public static void printAllFormat(String text) throws ParseException {
		DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT);
		Date parseData = format.parse(text);
		System.out.println(DateFormat.getDateInstance(DateFormat.SHORT).format(parseData));

		format = DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.println(DateFormat.getDateInstance(DateFormat.MEDIUM).format(parseData));

		format = DateFormat.getDateInstance(DateFormat.LONG);
		System.out.println(DateFormat.getDateInstance(DateFormat.LONG).format(parseData));

		format = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println(DateFormat.getDateInstance(DateFormat.FULL).format(parseData));
	}

	public static void main(String[] args) throws ParseException {
		DateParser.printAllFormat("2020/09/19");
		System.out.println();
		DateParser.printAllFormat("2020/9/19");
		System.out.println();
		DateParser.printAllFormat("20/9/19");

	}

}