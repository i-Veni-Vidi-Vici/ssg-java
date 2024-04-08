package com.sh.lambda._01.inner.clazz;

public class Member {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
