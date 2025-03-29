package com.sh.generics._01._class;

public class Box<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public String printInfo(){
        return value.toString();
    }
}
