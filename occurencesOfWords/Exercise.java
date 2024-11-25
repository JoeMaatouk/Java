package chapter9.occurencesOfWords;

import java.util.*;
// Using a map

public class Exercise {
    public static void main(String[] args){
        String text = "Are you ready for the exam? The exam is very very very interesting. \nReady? The interesting exam will be in 16 days.";

        // key = word (String) and value = occurence (Integer)
        // entry = key, value
        java.util.TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        StringTokenizer st = new StringTokenizer(text, " .,?!;:\n");
        while (st.hasMoreTokens()){
            String word = st.nextToken().toLowerCase();
            int value = 1;
            if (map.containsKey(word)){
                value = map.get(word); //return value = (number of occurences)
                value++;
            }
            map.put(word, value);
        }//end of while
        System.out.println(map);
    }
}