package com.team.work;

import java.util.Random;
import java.util.Scanner;

public class UpDown {

    public static void main(String[] args) {
        Random rand = new Random();
        int answer = rand.nextInt(100)+1;
        int userInput = 150;
        Scanner scan = new Scanner(System.in);
        while(userInput != answer){
            userInput = scan.nextInt();
            if(userInput > answer) System.out.println("다운");
            else if (userInput < answer) System.out.println("업");
        }
        System.out.println("축하!");
    }
}
