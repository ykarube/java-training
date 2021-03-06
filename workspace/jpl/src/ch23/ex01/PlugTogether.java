package ch23.ex01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *ex23.1:
 *
 *plugTogetherメソッドを作成しなさい。スレッドを使用する必要があるでしょう。
 *
 */
public class PlugTogether {


	public static void main(String[] args) {
		try {
			PlugTogether pt = new PlugTogether();
			pt.userProg("ls -al");
            System.out.println(pt.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public static Process userProg(String cmd) throws IOException {
        Process proc = Runtime.getRuntime().exec(cmd);
        plugTogether(System.in, proc.getOutputStream());
        plugTogether(System.out, proc.getInputStream());
        plugTogether(System.err, proc.getErrorStream());
        return proc;
    }

    public static void plugTogether(InputStream in, OutputStream out) {
        new Thread(new Executor(in, out)).start();
    }

    public static void plugTogether(OutputStream out, InputStream in) {
        new Thread(new Executor(in, out)).start();
    }

    private static class Executor implements Runnable {

        private final InputStream in;
        private final OutputStream out;

        public Executor(InputStream in, OutputStream out) {
            this.in = in;
            this.out = out;
        }

        @Override
        public void run() {
            int ch;
            try {
                while ((ch = in.read()) != -1)
                    out.write(ch);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}