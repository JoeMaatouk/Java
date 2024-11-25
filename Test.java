package chapter9;

public class Test {
    public static void main(String[] args){
        Student s1= new Student ("Karl", "Boulos", 20, "Sophomore");
        Student s2 = new Student("Karlo", "Boulos", 20, "Sophomore");
        System.out.println(s1.compareTo(s2));

        Pair<String> p1 = new Pair<String> ("abc", "def");
        String x = p1.getElement1();

        Pair <Student> p2 = new Pair<Student> (s1, s2);
        Student y = p2.getElement1();
     }
}