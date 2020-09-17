package ch24.ex01;

import java.util.ListResourceBundle;

public class GlobalRes_ar extends ListResourceBundle {

	private static final Object[][] contents = {
			{ GlobalRes.HELLO, "مرحبا" }, { GlobalRes.GOODBYE, "مع السلامة" }
	};

	@Override
	protected Object[][] getContents() {
		return contents;
	}

}

