package test;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {


        Person p = new Person("norman",18);
        ArrayList<Person> list = new ArrayList<>();
        list.add(p);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getAge());
        }
    }
}
