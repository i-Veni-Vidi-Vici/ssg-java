package com.sh.singletone;

public class Manager {
    private static Manager instance;

    private Manager(){

    }
    public static Manager getInstance(){
        if(instance==null){
            instance = new Manager();
            return instance;
        }
        else{
            return instance;
        }
    }
}
