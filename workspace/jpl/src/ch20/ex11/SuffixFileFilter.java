package ch20.ex11;

import java.io.File;
import java.io.FilenameFilter;

/*
 * デイレクトリと接尾語をパラメータとして取り、その接尾語を持つすべてのフアイルを表示する
 * プログラムをFilenameFilterあるいはFileFilterを使用して作成しなさい。
 */
public class SuffixFileFilter implements FilenameFilter {

    private final File dir;
    private final String suffix;

    public static void main(String[] args) {
    	String dir = System.getProperty("user.dir") + "\\src\\ch20\\ex11";
        SuffixFileFilter filter = new SuffixFileFilter(dir, "txt");
        for (String list : filter.list())
            System.out.println(list);
    }

    public SuffixFileFilter(String dir, String suffix) {
        this.dir = new File(dir);
        this.suffix = suffix;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(suffix);
    }

    public String[] list() {
        return dir.list(this);
    }
}