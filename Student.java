package chapter9;

public class Student implements Comparable<Student> {
    private String fname, lname;
    private int age;
    private String grade;

    public Student(String fname, String lname, int age, String grade){
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.grade = grade;
    }

    public int compareTo(Student o){
        if (this.fname.compareTo(o.fname) == 0)
            return this.lname.compareTo(o.lname);
        return this.fname.compareTo(o.fname);
    }

    public String getFname() {
        return fname;
    }
}