package ch10.ex02;

/**
 * 練習問題10.2
 * 練習問題10.1をswitch分で置き換える
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
        switch (c) {
        case '\n': return "\\n";
        case '\t': return "\\t";
        case '\b': return "\\b";
        case '\r': return "\\r";
        case '\f': return "\\f";
        case '\\': return "\\\\";
        case '\'': return "\\'";
        case '\"': return "\\\"";
        default:
        	return String.valueOf(c);
        }
    }

}