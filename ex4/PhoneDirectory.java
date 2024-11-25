package chapter8.ex4;

import java.io.*;

public class PhoneDirectory {
    private RandomAccessFile raf;

    public PhoneDirectory (String filename) throws IOException {
        raf = new RandomAccessFile(filename, "rw");
    }

    public void addEntry(String fname, String lname, String number) throws IOException {
        raf.seek(raf.length());
        raf.writeUTF(fname);
        raf.writeUTF(lname);
        raf.writeUTF(number);
        raf.writeChar('\n');
    }

    public void firstEntry()throws IOException{
        raf.seek(0);
        String fname = raf.readUTF();
        String lname = raf.readUTF();
        String number = raf.readUTF();
        System.out.println(fname + " " + lname + " " + number);
    }

    public void lastEntry() throws IOException {
        raf.seek(raf.length()); 
        long currentPos = raf.getFilePointer();
        long nowPos = currentPos;
        raf.seek(0);
        while (raf.getFilePointer() < currentPos){
            nowPos = raf.getFilePointer();
            raf.readLine();
        }
        raf.seek(nowPos);
        String fname = raf.readUTF();
        String lname = raf.readUTF();
        String number = raf.readUTF();
        System.out.println("Previous Entry: " + fname + " " + lname + " " + number);
    }

    public void nextEntry() throws IOException {
        if (raf.getFilePointer() == raf.length()){
            System.out.println("End of Directory. No more next entry");
            return;
        }
        raf.readChar(); // raf.readLine(); to skip the \n character or the rest of the line
        String fname = raf.readUTF();
        String lname = raf.readUTF();
        String number = raf.readUTF();   
        System.out.println("Next Entry: " + fname + " " + lname + " " + number);
    }

    public void previousEntry() throws IOException {
        if (raf.getFilePointer() == 0){
            System.out.println("Beginning of Directory. No previous entry");
            return;
        }
        long currentPos = raf.getFilePointer();
        long previousPos = 0, nowPos = currentPos;
        raf.seek(0);
        while (raf.getFilePointer() < currentPos){
            previousPos = nowPos;
            nowPos = raf.getFilePointer();
            raf.readLine();
        }
        raf.seek(previousPos);
        String fname = raf.readUTF();
        String lname = raf.readUTF();
        String number = raf.readUTF();
        System.out.println("Previous Entry: " + fname + " " + lname + " " + number);
    }


    public static void main(String[] args){
        try{
            PhoneDirectory p = new PhoneDirectory("Directory.bin");
            p.addEntry( "Janine", "Habib", "03126458");
            p.addEntry("Kamal", "Saad", "03586458");
            p.addEntry("Ibrahim", "Chammas", "70877421");
            p.firstEntry();
            p.nextEntry();
            p.nextEntry();


            p.previousEntry();
            p.lastEntry();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}