package com.ssg.stream.product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    static List<Product> list = List.of(
            new Product("아이폰X", "apple", "전자기기류", 1000000),
            new Product("맥프로", "apple", "전자기기류", 6300000),
            new Product("베지밀", "정식품", "음료류", 1000000),
            new Product("파스타면", "de cecco", "식품류", 10000),
            new Product("LG G7", "LG", "전자기기", 700000),
            new Product("기계식키보드", "LEOPOLD", "전자기기류", 100000),
            new Product("고양이", "베르나르베르베르", "도서", 15000),
            new Product("간다, 봐라", "법정스님", "도서", 8900),
            new Product("까페라떼", "디초코", "음료류", 4000),
            new Product("아포가토", "디초코", "디저트류", 4500)
    );

    public static void main(String[] args) {
        // 문제별 메소드를 만들어서 작성하세요.
//		1.전자기기류만 모두 출력하세요.
        printElectronicDevices(list);

//		2.apple사가 전제품 10% 할인한다고 할때, 해당제품명과 할인된 가격을 출력하세요.
        printDiscountApple(list);

//		3. 디초코 상표명이 "dechocolatecoffee"로 변경되었다.
//		스트림상에서 디초코 상품들의 상표명을 "dechocolatecoffee"로 변경하고 출력하세요.
        printChangedDeChocoName(list);

//		4.금액이 십만원 이상인 상품을 따로 list로 생성하고 출력하세요.
        printLargeAmount(list);

//		5.상품이름순으로 정렬후 출력하세요. (sorted(Comparator)메소드 이용)
        printSortedName(list);
//		6.가격순으로 내림차순정렬후 출력하세요.
        printSortedPrice(list);
    }

    //		1.전자기기류만 모두 출력하세요.
    public static void printElectronicDevices(List<Product> list) {
//        list.forEach(product -> {
//            if (product.getCategory().equals("전자기기류")) {
//                System.out.println(product);
//            }
//        });

        list.stream().filter(product -> product.getCategory().equals("전자기기류"))
                .forEach(System.out::println);
        System.out.println();
    }

    //		2.apple사가 전제품 10% 할인한다고 할때, 해당제품명과 할인된 가격을 출력하세요.
    public static void printDiscountApple(List<Product> list) {
        list.stream().filter(product -> product.getBrand().equals("apple"))
                .forEach(product -> System.out.println(product.getProductName() + " " + (int) (product.getPrice() * 0.9)));
        System.out.println();
    }


    //		3. 디초코 상표명이 "dechocolatecoffee"로 변경되었다.
    //		스트림상에서 디초코 상품들의 상표명을 "dechocolatecoffee"로 변경하고 출력하세요.
    public static void printChangedDeChocoName(List<Product> list) {
        list.stream().filter(product -> product.getBrand().equals("디초코"))
                .forEach(product -> {
                    product.setBrand("dechocolatecoffee");
                    System.out.println(product);
                });
        System.out.println();
    }

    //		4.금액이 십만원 이상인 상품을 따로 list로 생성하고 출력하세요.
    public static void printLargeAmount(List<Product> list) {
        List<Product> collect = list.stream()
                .filter(product -> product.getPrice() >= 100_000).toList();

        collect.forEach(System.out::println);
        System.out.println();
    }

    //		5.상품이름순으로 정렬후 출력하세요. (sorted(Comparator)메소드 이용)
    public static void printSortedName(List<Product> list) {
        list.stream().sorted(Comparator.comparing(Product::getProductName)).forEach(System.out::println);
        System.out.println();
    }

    //		6.가격순으로 내림차순정렬후 출력하세요.
    public static void printSortedPrice(List<Product> list) {
        list.stream().sorted(Comparator.comparingInt(Product::getPrice).reversed()).forEach(System.out::println);
    }
}