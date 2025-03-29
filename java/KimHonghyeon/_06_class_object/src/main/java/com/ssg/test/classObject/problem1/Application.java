package com.ssg.test.classObject.problem1;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("제목을 입력하세요: ");
        String title = scanner.nextLine();
        System.out.print("출판사를 입력하세요: ");
        String publisher = scanner.nextLine();
        System.out.print("저자를 입력하세요: ");
        String author = scanner.nextLine();
        System.out.print("가격을 입력하세요: ");
        int price = scanner.nextInt();
        System.out.print("할인율을 입력하세요: ");
        double discountRate= scanner.nextDouble();
        BookDto book = new BookDto(title, publisher, author, price, discountRate);
        book.printInformation();


    }
}
