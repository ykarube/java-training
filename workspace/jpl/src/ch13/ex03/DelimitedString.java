package ch13.ex03;

import java.util.ArrayList;

/**
 *  練習問題13.3
 *  すべての区切られた文字列を取り出して配列にして返すバージョンを作成しなさい
 */
public class DelimitedString {

	//教科書 P271から
    public static String delimitedString(String from, char start, char end) {
        int startPos = from.indexOf(start);
        int endPos = from.lastIndexOf(end);
        if (startPos == -1) // 開始文字が見つからない
            return null;
        else if (endPos == -1) // 終了文字が見つからない
            return from.substring(startPos);
        else if (startPos > endPos) // 開始文字が終了文字の後にある
            return null;
        else
            // 開始文字と終了文字が見つかった
            return from.substring(startPos, endPos + 1);
    }

    public static String[] delimitedStrings(String from, char start, char end) {
        if (from == null)
            throw new NullPointerException();
        String tmp = delimitedString(from, start, end);
        ArrayList<String> result = new ArrayList<>();
        while (true) {
            int startPos = tmp.indexOf(start);
            int endPos = tmp.indexOf(end);
            if (startPos == -1 || endPos == -1)
                break;
            result.add(tmp.substring(startPos, endPos + 1));
            tmp = tmp.substring(endPos + 1);
        }
        return result.toArray(new String[result.size()]);
    }
}
