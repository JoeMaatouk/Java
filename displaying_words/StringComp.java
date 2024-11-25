package chapter9.displaying_words;
import java.util.*;

public class StringComp implements Comparator<String> {

    /**
     * Ascending Order
     * return 0 if o1=o2
     * return <0 if o1<o2
     * return >0 if o1>o2
     * 
     * Descending order
     * Flip using -()
     */

    @Override
    public int compare(String o1, String o2){
        if (o1.length() == o2.length())
            return o1.compareTo(o2); // alphabetical order
        return -(o1.length() - o2.length()); // -() for descending order
    }
}