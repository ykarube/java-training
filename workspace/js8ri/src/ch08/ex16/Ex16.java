package ch08.ex16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex16 {

	private static final String ADDRESS_PATTERN = "(?<city>[\\p{L} ]+),\\s*(?<state>[A-Z]{2}),\\s*(?<zip>(\\d{5}(\\-\\d{4}){0,1}))";

	public static void main(String[] args) {
		// OK
		printAddress("example a b c, DC, 11111-2222");
		printAddress("example a b c, DC, 33333");
		// NG
		printAddress("example a b c, DC, 4444");
		printAddress("example a b c, DC 55555");
	}

	static void printAddress(String addr) {
		Matcher matcher = Pattern.compile(ADDRESS_PATTERN).matcher(addr);
		if(matcher.matches()) {
			String city = matcher.group("city");
			String state = matcher.group("state");
			String zip = matcher.group("zip");

			System.out.print("City= " + city + ", ");
			System.out.print("State: " + state + ", ");
			System.out.println("Zip: " + zip);
		} else {
			System.out.println("not matching.");
		}
	}
}