package com.ssh.condition._switch;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String num1 = scn.next();
        String num2 = scn.next();

        String op = scn.next();

        switch(op) {
            case "+":
                System.out.println(num1 + " + "+num2 +" -> "+ (Integer.parseInt(num1) + Integer.parseInt(num2)) );
                break;
            case "-":
                System.out.println(num1 + " - "+num2 +" -> "+ (Integer.parseInt(num1) - Integer.parseInt(num2)) );
                break;
            case "*":
                System.out.println(num1 + " * "+num2 +" -> "+ (Integer.parseInt(num1) * Integer.parseInt(num2)) );
                break;
            case "/":
                System.out.println(num1 + " / "+num2 +" -> "+ Integer.parseInt(num1) / Integer.parseInt(num2) );
                break;
            case "%":
                System.out.println(num1 + " % "+num2 +" -> "+ Integer.parseInt(num1) % Integer.parseInt(num2) );
                break;

            default:
                System.out.println("잘못 된 숫자 입니다.");
                break;
        }
    }
}
