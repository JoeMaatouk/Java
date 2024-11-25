package chapter8;

import java.io.*;

public class Read {
    public static void main(String[] args) {
        File f = new File("YourFile.txt");
        try{

            BufferedReader r = new BufferedReader(new FileReader(f));
            String line;
            while( (line = r.readLine()) !=null){
                System.out.println(line);
            }
            r.close();
            
            //FileReader r = new FileReader(f);
            //char[] buffer = new char[(int)f.length()];
            //r.read(buffer);
            //System.out.println(buffer);
            //r.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}