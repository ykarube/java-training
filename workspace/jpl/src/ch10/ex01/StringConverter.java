package ch10.ex01;

/**
 * 練習問題10.1
 * 文字列のパラメータを取り、その文字列中の全ての特殊文字を
 * 対応するJava言語の表現で置き換えたメソッドを if-elseを使用して書きなさい
 * たとえば文字列中に"が含まれていたら、"を\"でo置き換えた文字列を返します
 *
 */
//no testCode
public class StringConverter {

	public static void main(String[] args) {
        String input = "\"\\\\ \\\" \\' \\t \\b \\r \\f \\n\"";

        System.out.println("-----in-----");
        System.out.println(input);
        System.out.println("-----out-----");
        System.out.println(new StringConverter().convert(input));
	}

	/**
     * 文字列変換
     */
    public String convert( final String elements ) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < elements.length(); i++) {
            result.append(replace(elements.charAt(i)));
        }
        return result.toString();
    }


    /**
     * 文字列置き換え
     */
    private String replace( final char c) {
    	if (c == '\n') {
            return "\\n";
        } else if (c == '\t') {
            return "\\t";
        } else if (c == '\b') {
            return "\\b";
        } else if (c == '\r') {
            return "\\r";
        } else if (c == '\f') {
            return "\\f";
        } else if (c == '\\') {
            return "\\\\";
        } else if (c == '\'') {
            return "\\'";
        } else if (c == '\"') {
            return "\\\"";
        }
        return String.valueOf(c);
    }
}