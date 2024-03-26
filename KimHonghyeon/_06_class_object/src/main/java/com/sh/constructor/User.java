package com.sh.constructor;

import java.time.LocalDate;

public class User {
    private long id;
    private String name;
    private LocalDate createdAt;

    public User(){
        this.createdAt = LocalDate.now();
    }

    public User(long id, String name, LocalDate createdAt){
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        /*
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("createdAt = " + createdAt);
        */
    }

    public User(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.createdAt = user.getCreatedAt();
    }

    public User(long id, String name){
        this(id, name, LocalDate.now());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void printUser(){
        System.out.println("id: " + this.id + " name: "+this.name + " createdAt: " + this.createdAt);
    }

}
