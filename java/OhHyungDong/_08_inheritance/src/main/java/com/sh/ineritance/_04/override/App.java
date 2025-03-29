package com.sh.ineritance._04.override;

/**
 *
 */
public class App {

    public static void main(String[] args)
    {
            SubClass subClass = new SubClass();
        subClass.method(100);
        subClass.finalMethod();
        subClass.protectedMethod();

    }
}
