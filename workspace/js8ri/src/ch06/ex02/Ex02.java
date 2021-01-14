package ch06.ex02;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;


public class Ex02 {

    private static final Ex02 INSTANCE = new Ex02();
    private final AtomicLong value;
    private final LongAdder adder;

    public static Ex02 getInstance() {
        return INSTANCE;
    }

    public long generate() {
        long newId;
        adder.increment(); // adder isn't return value
        newId = value.incrementAndGet();
        return newId;
    }

    private Ex02() {
        value = new AtomicLong();
        adder = new LongAdder();
    }

    public static void main(String[] args) {
		Ex02 e = Ex02.getInstance();
		System.out.println(e.value.toString() +"," +e.adder.toString());
		e.generate();
		System.out.println(e.value.toString() +"," +e.adder.toString());
	}

}