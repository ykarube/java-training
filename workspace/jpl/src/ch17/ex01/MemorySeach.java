package ch17.ex01;

/**
 *   起動時と多くのオブジェクトを生成した後で、利用可能なメモリ量を調べるプログラムを書きなさい。
 *   ガーベッジコレクタを呼び出して、空きメモリ量がどのように変化するかを調べなさい。
 *   もちろん、新たに生成されたオブジェクトヘの参照を間違いなく保持していないようにしてください。
 *
 */
public class MemorySeach {

	public static void main(String[] args){
	Runtime runtime = Runtime.getRuntime();
	long memory = runtime.freeMemory();

	System.out.println(memory);

	String[] test = new String[10000];
	for(int i = 0 ; i < 10000; i ++){
		test[i] = new String("test");
	}
	memory = runtime.freeMemory();

	System.out.println(memory);

	runtime.runFinalization();
	runtime.gc();
	memory = runtime.freeMemory();

	System.out.println(memory);

	}

	/*
	 * 実行結果
	 * 130188056
	 * 129727752
	 * 9242776
	 */

}
