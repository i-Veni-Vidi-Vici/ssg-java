package com.ssg.test.loop;

import java.util.Scanner;

public class Test6 {
    public static void main(String[] args){
        showMenu();
        selectMenu();
        addOrder();
    }

    private static void addOrder() {
        Scanner sc = new Scanner(System.in);
        System.out.print("추가 주문하시겠습니까? (y/n) : ");
        char add = sc.nextLine().charAt(0);
        if(add=='y'){
            selectMenu();
        }
        else{
            finishMenu();
        }

    }

    private static void finishMenu() {

    }

    private static void selectMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("원하시는 메뉴의 번호를 입력하세요 : ");
        int num = sc.nextInt();
        System.out.print("수량을 입력하세요 : ");
        int count = sc.nextInt();
    }

    private static void showMenu() {
        System.out.println("김밥류==============");
        System.out.println("1.원조김밥=====1500원");
        System.out.println("2.치즈김밥=====2000원");
        System.out.println("3.참치김밥=====2300원");
        System.out.println("라면류==============");
        System.out.println("4.그냥라면=====3000원");
        System.out.println("5.치즈라면=====3500원");
        System.out.println("6.짬뽕라면=====4000원");
        System.out.println("분식류==============");
        System.out.println("7.떡볶이=======2500원");
        System.out.println("8.순대========2500원");
        System.out.println("9.오뎅========1000원");
        System.out.println("기타================");
        System.out.println("10.음료수======1000원");
        System.out.println("\n---------------------------");
    }
}
