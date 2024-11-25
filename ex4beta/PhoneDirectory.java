package chapter8.ex4beta;

import java.io.*;

public class PhoneDirectory {
    private RandomAccessFile raf;

    public PhoneDirectory (String filename) throws IOException {
        raf = new RandomAccessFile(filename, "rw");
    }

    public void addEntry(PhoneEntry entry) throws IOException {
        raf.seek(raf.length());
        raf.writeUTF(entry.getFname());
        raf.writeUTF(entry.getLname());
        raf.writeUTF(entry.getNumber());
        raf.writeChar('\n');
    }

    public PhoneEntry firstEntry()throws IOException{
        raf.seek(0);
        String fname = raf.readUTF();
        String lname = raf.readUTF();
        String number = raf.readUTF();
        return new PhoneEntry(fname, lname, number);
    }

    public void lastEntry() throws IOException {
        raf.seek(raf.length());
        return this.previousEntry();
    }

    public PhoneEntry nextEntry() throws IOException {
        if (raf.getFilePointer() == raf.length()){
            System.out.println("End of Directory. No more next entry");
            return null;
        }
        raf.readChar(); // raf.readLine(); to skip the \n character or the rest of the line
        String fname = raf.readUTF();
        String lname = raf.readUTF();
        String number = raf.readUTF();   
        return new PhoneEntry();
    }

    public void previousEntry() throws IOException {
        if (raf.getFilePointer() == 0){
            System.out.println("Beginning of Directory. No previous entry");
            return;
        }
        long currentPos = raf.getFilePointer();
        PhoneEntry previousEntry, nowEntry;
        raf.seek(0);
        while (raf.getFilePointer() < currentPos){
            previousEntry = nowEntry;
            nowEntry = this.nextEntry();        }
        raf.seek(previousPos);
        String fname = raf.readUTF();
        String lname = raf.readUTF();
        String number = raf.readUTF();
        System.out.println("Previous Entry: " + fname + " " + lname + " " + number);
    }


    public static void main(String[] args){
        try{
            PhoneDirectory p = new PhoneDirectory("Directory.bin");
            p.addEntry(new PhoneEntry("Janine", "Habib", "03126458"));
            p.addEntry(new PhoneEntry("Kamal", "Saad", "03586458"));
            p.addEntry(new PhoneEntry("Ibrahim", "Chammas", "70877421"));
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