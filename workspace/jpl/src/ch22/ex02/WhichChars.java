package ch22.ex02;

import java.util.BitSet;

/**
 * ex22-2  p560
 * WhichCharsクラスは、Unicode範囲の上位の文字を記録するのに問題を抱えています。
 * それは、上位の文字は、下位の範囲に関して多くの使用されないビットを残してしまうことです。
 * 出現した文字ごとにCharacterオブジェクトをHashsetに保存することで、この問題を解決しなさい。
 */
public class WhichChars {

	private BitSet used = new BitSet();

	public WhichChars(String str){
		for(int i = 0; i < str.length(); i++)
			used.set(str.charAt(i)); //文字に対応したビットを設定
	}

	public String toString(){
		String desc =  "[";
		for(int i = used.nextClearBit(0);i >= 0;i = used.nextSetBit(i+1) ){
			desc += (char) i;
		}
			return desc + "]";
	}

	public static void main(String[] args){
		WhichChars wc = new WhichChars("test 1 2 3");
		System.out.println(wc);
	}

}
