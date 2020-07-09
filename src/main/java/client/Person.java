package client;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //Dummy constructor is necessary for Jackson to serialize the object correctly.

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "client.Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
