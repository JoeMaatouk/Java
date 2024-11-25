package chapter9;
//Defining a new generic class
public class Pair<E> {
    private E element1;
    private E element2;


    public Pair(E element1, E element2){
        if (element1.equals(element2))
            System.out.println("Cannot ...");
        else{
            this.element1 = element1;
            this.element2 = element2;
        }
    }

    public E getElement1() {
        return element1;
    }
    public void setElement1(E element1) {
        if (!this.element2.equals(element1))
            this.element1 = element1;
        else System.out.println("Cannot set element1");
    }
    public E getElement2() {
        return element2;
    }
    public void setElement2(E element2) {
        if (this.element1.equals(element2))
            this.element2 = element2;
        else System.out.println("Cannot set element2");
    }
}