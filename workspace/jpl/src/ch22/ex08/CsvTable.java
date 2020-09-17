package ch22.ex08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
/**
 * ex22-8 p570
 *
 * 現状では、readCSVTableは、それが期待する入力形式に関して、
 * 厳格すぎると同時に寛容すぎます。
 * 入力の終わりに空行があるとIOExceptonをスローしますので、厳格すぎます。
 * 4つ以上のカンマを持つ行でも例外が発生しませんので、寛容すぎます。
 * この両方の問題を修正しなさい
 *
 */
public class CsvTable {

    private static final String PATH = System.getProperty("user.dir") + "\\src\\ch22\\ex08\\input.csv";

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

    public List<String[]> readCSVTable(Readable source, int nCells)
            throws IOException {
        if (nCells < 1)
            throw new IllegalArgumentException();
        Scanner in = new Scanner(source);
        List<String[]> vals = new ArrayList<>();
        try {
            String exp = "^(.*)";
            for (int i = 1; i < nCells; i++)
                exp += ",(.*)";
            Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
            while (in.hasNextLine()) {
                String line = in.findInLine(pat);
                if (line != null) {
                    String[] cells = new String[nCells];
                    MatchResult match = in.match();
                    for (int i = 0; i < cells.length; ++i)
                        cells[i] = match.group(i + 1);
                    vals.add(cells);
                    in.nextLine();
                } else {
                    String next = in.nextLine();
                    if (!next.isEmpty())
                        throw new IOException("input format error");
                }
            }
            IOException ex = in.ioException();
            if (ex != null)
                throw ex;
        } finally {
            in.close();
        }
        return vals;
    }
}