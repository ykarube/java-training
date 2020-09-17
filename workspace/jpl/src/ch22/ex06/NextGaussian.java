package ch22.ex06;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
/**
 * ex22-6  p565
 *
 * nextGaussianを検査するプログラムを作成して、
 * 膨大な数の呼び出し結果をグラフ(*文字の棒グラフ)で表示しなさい。
 */
public class NextGaussian {

	public static void main(String[] args){

		Random r = new Random();
		Map<Double, Integer> distribution = new TreeMap<>();

		for (int i = 0; i < 1200; i++) {
			BigDecimal g = new BigDecimal(r.nextGaussian());
			g = g.setScale(1, BigDecimal.ROUND_HALF_UP);
			if(distribution.containsKey(g.doubleValue())){
				int count = distribution.get(g.doubleValue());
				distribution.put(g.doubleValue(), count + 1);
			}else{
				distribution.put(g.doubleValue(), 1);
			}
		}

		for(double d : distribution.keySet()){
			int count = (int) distribution.get(d);
			System.out.print(d+":");
			for (int i = 0; i < count; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}