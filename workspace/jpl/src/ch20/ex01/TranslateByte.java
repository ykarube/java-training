package ch20.ex01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * TranslateByteプログラムをメソッドに書き直して、InputStreamの内容をoutputStreamに変換するようにしなさい。
 * 変換マッピングとストリームはメソッドのパラメータとして渡します。
 *
 * 本章で述べられる各InputStreamとOutputStreamについて、
 * その型のストリームに対して操作を行うために、変換メソッドを使用する新たなmainメソッドを書きなさい。
 * もし入力と出力で一対となるストリームならば、1つのmainメソッドで両方を扱うことができます
 *
 */
class TranslateByte{

    public static void main(String[] args) {
        TranslateByte tb = new TranslateByte();
        InputStream in = System.in;
        OutputStream out = System.out;
        try {
            tb.translate(new String[] { "b", "B" }, in, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void translate(String[] input, InputStream in, OutputStream out)
            throws IOException {
        byte from = (byte) input[0].charAt(0);
        byte to = (byte) input[1].charAt(0);
        int b;
        while ((b = in.read()) != -1)
        	System.out.println(b == from ? to : b);
            out.write(b == from ? to : b);
    }
}