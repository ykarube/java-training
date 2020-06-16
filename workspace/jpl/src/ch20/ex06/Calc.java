package ch20.ex06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 *name op value形式の入力を受け取るプログラムを作成しなさい。
 *nameは自分で選んだ3個の単語の1つで、opは+、一、=のどれかで、valueは数です。
 *名前付値に各演算子を適用しなさい。
 *
 *入力がなくなったら、3つの値を表示しなさい。
 *もし、興味があれば、Attributedlmplで使用されたHashMapを使用してみなさい。
 *そうすれば、任意の個数の名前付定数を使用できます。
 */
class Calc {

	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        String line;
        Map<String, Integer> map = new HashMap<>();
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                for (String key : map.keySet())
                    System.out.println(key + " = " + map.get(key));
                break;
            }
            String[] strs = line.split(" ");
            String name = strs[0];
            String op = strs[1];
            String value = strs[2];
            Integer prev = map.get(name);
            if (prev == null)
                prev = 0;
            switch (op) {
            case "+":
                prev += Integer.parseInt(value);
                break;
            case "-":
                prev -= Integer.parseInt(value);
                break;
            case "=":
                prev = Integer.parseInt(value);
                break;
            default:
                throw new IllegalArgumentException("Undefined op: " + op);
            }
            map.put(name, prev);
        }
	}
}