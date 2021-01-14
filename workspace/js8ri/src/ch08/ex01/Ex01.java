package ch08.ex01;

public class Ex01 {
	static long add(int a, int b){
		return (Integer.toUnsignedLong(a) + Integer.toUnsignedLong(b));
	}

	static long sub(int a, int b){
		return (Integer.toUnsignedLong(a) - Integer.toUnsignedLong(b));
	}

	static int div(int a, int b){
		return Integer.divideUnsigned(a, b);
	}

	static long comp(int a, int b){
		return Integer.compareUnsigned(a, b);
	}

	public static void main(String[] args) {
		int a = Integer.MAX_VALUE*2;
		System.out.println("Integer.MAX_VALUE : "+Integer.MAX_VALUE);
		System.out.println("Inetger.MAX_VALUE*2 : "+a);
		System.out.println("Integer.MAX_VALUE*2.toUnsignedLong:"+Integer.toUnsignedLong(a));
		System.out.println("-2.toUnsignedLong:"+Integer.toUnsignedLong(-2));
		System.out.print("ADD : 4294967194 + 4294967194 = ");
		long result = add(Integer.MAX_VALUE*2-100,Integer.MAX_VALUE*2-100);
		System.out.println(result);
		System.out.print("SUB : 4294967294 - 100 = ");
		result = sub(Integer.MAX_VALUE*2, 100);
		System.out.println(result);
		System.out.print("DIV : 4294967294 / 100 = ");
		result = div(Integer.MAX_VALUE*2, 100);
		System.out.println(result);
		System.out.print("CMP : 4294967294 <> 100 = ");
		result = comp(Integer.MAX_VALUE*2, 100);
		System.out.println(result);
	}
}
