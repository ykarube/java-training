package ch22.ex14;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 複数の浮動小数点数字を含む文字列を取り
 * 区切り文字として空白を使用して分解して、数字の合計を返すメソッドを書きなさい。
 *
 */
public class SplitString {


    public static void main(String[] args) {
    	SplitString s = new SplitString();
    	String data = "1.0 1.0000 -1.5 +1.5 1.00000000001";
        System.out.println(s.splitString(data));
        System.out.println(s.sum(data));
    }

	private List<String> splitString(String data){
		List<String> splitData = new ArrayList<>();
		StringTokenizer tokens = new StringTokenizer(data, " ");
		while(tokens.hasMoreTokens()){
			splitData.add(tokens.nextToken());
		}
		return splitData;
	}

	public double sum(String data){
		List<String> splitData = splitString(data);
		double sum = 0;
		for(String s : splitData){
			sum = sum + Double.valueOf(s);
		}
		return sum;
	}
}