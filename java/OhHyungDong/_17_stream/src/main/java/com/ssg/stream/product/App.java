package com.ssg.stream.product;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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

         //1.전자기기류만 모두 출력하세요.
        // 카테고리가 전자기기인지 확인하고 전자기기 맞으면 name 출력
        List<String> productName = list.stream()
                .filter(product -> product.getCategory().contains("전자기기"))
                .map(Product -> Product.getProductName())
                .collect(Collectors.toList());
        System.out.println("모든 전자기기류 호출 ");
        productName.forEach(System.out::println);
        System.out.println();

         //2.apple사가 전제품 10% 할인한다고 할때, 해당제품명과 할인된 가격을 출력하세요.

        Map<String,Integer> appleDiscount = list.stream()
                .filter(product -> product.getBrand().equals("apple"))
                .collect(Collectors.toMap(
                    product -> product.getProductName(),
                        price -> (int)(price.getPrice() * 0.9)
                ));
        System.out.println("아이폰 할인 이벤트 ");
        appleDiscount.forEach((name, price) -> System.out.println(name + " : " + price));
        System.out.println();
         //3. 디초코 상표명이 "dechocolatecoffee"로 변경되었다. 스트림상에서 디초코 상품들의 상표명을 "dechocolatecoffee"로 변경하고 출력하세요.//
        Map<String,String> dechoco = list.stream()
                .filter(product -> product.getBrand().equals("디초코"))
                .peek(product -> product.setBrand("dechocolatcoffee"))
                .collect(Collectors.toMap(
                        Product::getProductName,
                        Product::getBrand
                        )
                );
        System.out.println("dechocolatecoffee");
        dechoco.forEach((name,brand )-> System.out.println(name + " : "  +brand  ));
        System.out.println();

         //4.금액이 십만원 이상인 상품을 따로 list로 생성하고 출려하세요.
        // 10만원 이상 -> .filter(price -> prodcut.getPrice() >= 100000)
        List<String> price = list.stream()
                    .filter(product -> product.getPrice() >=100000)
                    .map(product -> product.getProductName())
                    .collect(Collectors.toList());
        System.out.print("10만원이 넘는 제품 : ");
            price.forEach((n) -> System.out.print(n + " "));
        System.out.println();
        System.out.println();
         //5.상품이름순으로 정렬후 출력하세요. (sorted(Comparator)메소드 이용)
        List<String> printName = list.stream()
                .map(prodcut -> prodcut.getProductName())
                .sorted(Comparator.comparing(String::toString))
                .collect(Collectors.toList());

        System.out.println("상품을 이름순으로 출력");
        printName.forEach(System.out::println);
        System.out.println();

         //6.가격순으로 내림차순정렬후 출력하세요.
        List<Integer> productDesc = list.stream()
                .map(descPrice -> descPrice.getPrice())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("가격을 내림차순으로 정렬 ");
        productDesc.forEach(System.out::println);
    }
}
