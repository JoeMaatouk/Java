package chapter9.displaying_words;

import java.io.*;
import java.util.*;

public class ExercisePrime {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("File1.txt"));
        String line;
        TreeSet<String> set = new TreeSet<String>(new StringComp()); // Treeset not hashset ta ysiro in alphabetical
                                                                     // order
        while ((line = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, " .,?!:;\n");
            while (st.hasMoreTokens()) {
                String word = st.nextToken().toLowerCase();
                set.add(word);
            }
        }
        System.out.println(set);

        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
