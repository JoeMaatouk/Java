package chapter8;

import java.io.*;
import java.util.StringTokenizer;

public class Ex2 {
    public static void main(String[] args) {
        String s = "world";
        String x = "you";
        try {
            BufferedReader r = new BufferedReader(new FileReader("MyFile.txt"));
            FileWriter w = new FileWriter("YourFile.txt");
            String line;
            while ((line = r.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, " .,?!:;");
                while (st.hasMoreTokens()) {
                    String word = st.nextToken();
                    if (word.equalsIgnoreCase(s)) {
                        w.write(x);
                        w.write(" ");
                        continue;
                    }
                    w.write(word);
                    w.write(" ");
                }
                line = line.trim();
                char c = line.charAt(line.length() - 1);
                w.write(c);
                w.write('\n');
            }
            w.close();
            r.close();
            File f1 = new File("MyFile.txt");
            File f2 = new File("NewFile.txt");
            f1.delete();
            f2.renameTo(f1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}