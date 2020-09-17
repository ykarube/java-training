package ch24.ex02;

import java.util.Currency;
import java.util.Locale;

public class CurrencySymbolTable {

	public static void main(String[] args) {

		Currency jp = Currency.getInstance(Locale.JAPAN);
		System.out.println(jp.getSymbol(Locale.JAPAN));
		System.out.println(jp.getSymbol());

		Currency us = Currency.getInstance(Locale.US);
		System.out.println(us.getSymbol(Locale.US));
		System.out.println(us.getSymbol());

		Currency ge = Currency.getInstance(Locale.GERMANY);
		System.out.println(ge.getSymbol(Locale.GERMANY));
		System.out.println(ge.getSymbol());

		Currency fr = Currency.getInstance(Locale.FRANCE);
		System.out.println(fr.getSymbol(Locale.FRANCE));
		System.out.println(fr.getSymbol());

		Currency ar = Currency.getInstance(new Locale("ar", "AR"));
		System.out.println(ar.getSymbol(new Locale("ar", "AR")));
		System.out.println(ar.getSymbol());

		Currency kr = Currency.getInstance(Locale.KOREA);
		System.out.println(kr.getSymbol(Locale.KOREA));
		System.out.println(kr.getSymbol());

	}

}