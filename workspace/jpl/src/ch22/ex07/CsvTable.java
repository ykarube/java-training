package ch22.ex07;

import static java.io.StreamTokenizer.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
/**
 * ex22-7  p570
 *
 * 期待されるデータのセル数を引数として渡せるようにreadCSVTableを書き直しなさい。
 *
 */
public class CsvTable {

    private static final String PATH = System.getProperty("user.dir") + "\\src\\ch22\\ex07\\input.csv";

    public static void main(String[] args) {
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(PATH));
            List<String[]> result = new CsvTable().readCSVTable(input, 3);
            for (String[] values : result) {
                for (int i = 0; i < values.length; i++)
                    System.out.print(values[i] + "\t");
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<String[]> readCSVTable(Reader source, int nCells)
            throws IOException {
        if (nCells < 1)
            throw new IllegalArgumentException();
        StreamTokenizer in = new StreamTokenizer(source);
        in.ordinaryChar(',');
        in.eolIsSignificant(true);
        List<String[]> vals = new ArrayList<>();
        List<String> cells = new ArrayList<>();
        int count = 0;
        while (in.nextToken() != TT_EOF) {
            switch (in.ttype) {
            case TT_WORD:
                cells.add(in.sval);
                count = 0;
                break;
            case TT_EOL:
                vals.add(cells.toArray(new String[0]));
                cells = new ArrayList<>();
                count = 0;
                break;
            default:
                if (count == 1) {
                    cells.add(null);
                    count = 0;
                }
                count++;
                break;
            }
        }
        vals.add(cells.toArray(new String[0]));
        return vals;
    }
}