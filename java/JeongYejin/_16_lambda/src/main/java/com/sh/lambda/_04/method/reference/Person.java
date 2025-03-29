package com.sh.lambda._04.method.reference;

public class Person {
    private long id;
    private String name;
    private int age;

    public Person() {
    }

    public Person(long id) {
        this.id = id;
    }

    public Person(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
