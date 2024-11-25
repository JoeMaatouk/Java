package chapter8;

import java.io.*;

public class Write {
    public static void main(String[] args) {
        try{
            FileWriter w = new FileWriter("MyFile.txt", true);
            w.write("Hello World!\n");
            w.write("Bonjour tout le monde!\n");
            w.flush();
            w.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
