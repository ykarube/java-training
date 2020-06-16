package ch20.ex03;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * バイトを何らかの値とXORするなど、どのようなアルゴリズムでも良いので、
 * バイトを暗号化する一組のFilterストリームクラスであるDecryptlnPutStreamとEncryptOutputStreamを作成しなさい。
 * DecryptlnputStrealnは、EncryptOutputStrealnクラスが生成したバイトを復号化します。
*/

public class DecryptInputStream extends FilterInputStream {

    private final int key;

    public DecryptInputStream(InputStream in, int key) {
        super(in);
        this.key = key;
    }

    @Override
    public int read() throws IOException {
        int in = super.read();
        if (in != -1)
            in = in ^ key;
        return in;
    }

    public static void main(String[] args) {
        final int key = 2014;
        DecryptInputStream input = new DecryptInputStream(System.in, key);
        EncryptOutputStream output = new EncryptOutputStream(System.out, key);
        try {
            int enc;
            while ((enc = input.read()) != -1) {
                System.out.println("Encoded: " + (char) enc);
                System.out.println("Encoded: " + enc);
                System.out.print("Decoded: ");
                output.write(enc);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}