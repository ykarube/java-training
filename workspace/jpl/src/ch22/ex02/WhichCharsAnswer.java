package ch22.ex02;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * ex22-2  p560
 * WhichCharsクラスは、Unicode範囲の上位の文字を記録するのに問題を抱えています。
 * それは、上位の文字は、下位の範囲に関して多くの使用されないビットを残してしまうことです。
 * 出現した文字ごとにCharacterオブジェクトをHashsetに保存することで、この問題を解決しなさい。
 */
public class WhichCharsAnswer {

//	private BitSet used = new BitSet();
    private Set<Character> used = new HashSet<>();

	public WhichCharsAnswer(String str){
        for (int i = 0; i < str.length(); i++) {
            // used.set(str.charAt(i));
            used.add(str.charAt(i));
        }
	}

	public String toString(){
        Set<Character> used = new TreeSet<>(this.used);
        String desc = "[";
        // for (int i = used.nextSetBit(0); i >= 0; i = used.nextSetBit(i + 1)) {
        for (Character i : used) {
            desc += (char) i;
        }
        return desc + "]";
	}

	public static void main(String[] args){
		WhichCharsAnswer wc = new WhichCharsAnswer("test 1 2 3");
		System.out.println(wc);
	}

}
