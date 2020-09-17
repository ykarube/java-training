package ch23.ex02;

import java.io.IOException;

public class Executer {

	public static void main(String[] args) throws IOException {
		for(int i = 0; i < args.length; i++){
			Runtime r = Runtime.getRuntime();
			System.out.print((i+1) + ":");
			r.exec(args[i]);
		}
	}

}