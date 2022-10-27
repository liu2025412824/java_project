package generic_;

public class Generic02 {
    public static void main(String[] args) {

        Person<String> person1 = new Person<>("haha");
        person1.t();
        Person<Integer> person2 = new Person<Integer>(19);
        person2.t();

    }
}

class Person<E>{
    private E s;

    public Person(E s) {
        this.s = s;
    }

    public E f(){
        return s;
    }
    public void t(){
        System.out.println(s.getClass());
    }
}
