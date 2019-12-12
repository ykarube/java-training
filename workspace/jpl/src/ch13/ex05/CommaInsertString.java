package ch13.ex05;


public class CommaInsertString {

    public static String insertComma(String source) {
        if (source == null)
            throw new NullPointerException();
        for (int i = source.length() - 3; i > 0; i -= 3)
            source = source.substring(0, i) + "," + source.substring(i);
        return source;
    }
}
