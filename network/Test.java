package chapter9.network;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException{
        Network n = new Network();
        // ma badde esta3mol binary so ma besta3mel chi fiyo stream;

        BufferedReader b = new BufferedReader(new FileReader("File.txt"));
        String line;
        while ( (line = b.readLine()) != null ) {
            String[] s = line.split(";"); //can also use string tokenizer
            String name = s[0].trim();
            String industry = s[1].trim();
            String type = s[2].trim();
            try{
                n.createProfile(name, industry, type);
            }catch(Exception e) { //not IOException
                //skip current details
                System.out.println("Skipping " + name);
            }
        }
        System.out.println(n);
    }
}