package com.ssg.stream.product;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    List<Product> list = List.of(
            new Product("아이폰X", "apple", "전자기기류", 1000000),
            new Product("맥프로", "apple", "전자기기류", 6300000),
            new Product("베지밀", "정식품", "음료류", 1000000),
            new Product("파스타면", "de cecco", "식품류", 10000),
            new Product("LG G7", "LG", "전자기기류", 700000),
            new Product("기계식키보드", "LEOPOLD", "전자기기류", 100000),
            new Product("고양이", "베르나르베르베르", "도서", 15000),
            new Product("간다, 봐라", "법정스님", "도서", 8900),
            new Product("까페라떼", "디초코", "음료류", 4000),
            new Product("아포가토", "디초코", "디저트류", 4500)
    );

    public static void main(String[] args) {
        // 문제별 메소드를 만들어서 작성하세요.
        App app = new App();
        app.test1();
        app.test2();
        app.test3();
        app.test4();
        app.test5();
        app.test6();
    }

    void test1() {
        list.stream()
                .filter((l) -> l.getCategory().equals("전자기기류"))
                .forEach(System.out::println);
    }

    void test2() {
        list.stream()
                .filter((l) -> l.getBrand().equals("apple"))
                .forEach((l) -> System.out.println("제품명 : " + l.getProductName() + " 가격 : " + (int)(l.getPrice()*0.9) + "원"));
    }

    void test3() {
        list.stream()
                .filter((l) -> l.getBrand().equals("디초코"))
                .peek((l) -> l.setBrand("dechocolatecoffee"))
                .forEach(System.out::println);
    }

    void test4() {
        System.out.println("십만원 이상인 상품입니다!");
        Stream<Product> list2 = list.stream()
                .filter((l) -> l.getPrice() >= 100000);
        list2.forEach(System.out::println);
    }

    void test5() {
        System.out.println("상품 이름 순으로 정렬 !");
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getProductName().compareTo(o2.getProductName());
            }
        };
        list.stream()
                .sorted(comparator)
                .forEach(System.out::println);
    }

    void test6() {
        System.out.println("가격 내림차순 정렬!");
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getPrice() - o1.getPrice();
            }
        };
        list.stream().sorted(comparator).forEach(System.out::println);
    }
}