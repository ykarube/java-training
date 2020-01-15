package ch14.ex06;

/**
 * ex14-7
 * Babbleを複数回実行して、結果を調べなさい。常に同じ結果ですか。
 * 可能なら、異なるシステムで実行して比較しなさい。
 *
 * Ans.常に同じ結果とならない
*/
class Babble extends Thread {
	static boolean doYield; //他のスレッドに実行を譲るか?
	static int howOften; //表示する回数
	private String word; //このスレッドの単語
	Babble(String whatToSay){
		word = whatToSay;
	}
	public void run(){
	for (int i =0; i < howOften; i++){
		System.out.println(word);
		if (doYield)
			Thread.yield();//他のスレッドを走らせる
		}
	}

	public static void main(String[] args){
		String[] args2 = {"true", "10", "Did", "Didnot"};
		args = args2;
		doYield = new Boolean(args[0]).booleanValue();
		howOften = Integer.parseInt(args[1]);

		//各単語に対してスレッドを生成
		for (int i = 2; i < args.length; i++)
			new Babble(args[i]).start();
		}
}

/*
 *
1回目実行結果：
Did
Did
Didnot
Did
Didnot
Did
Didnot
Did
Didnot
Did
Didnot
Did
Didnot
Did
Didnot
Didnot
Did
Didnot
Did
Didnot

2回目実行結果
Did
Didnot
Didnot
Did
Didnot
Didnot
Didnot
Didnot
Didnot
Didnot
Did
Did
Did
Didnot
Did
Didnot
Did
Did
Did
Did

 *
 */