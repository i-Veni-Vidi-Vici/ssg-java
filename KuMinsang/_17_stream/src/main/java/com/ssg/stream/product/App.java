package com.ssg.stream.product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
1.전자기기류만 모두 출력하세요.
2.apple사가 전제품 10% 할인한다고 할때, 해당제품명과 할인된 가격을 출력하세요.
3. 디초코 상표명이 "dechocolatecoffee"로 변경되었다.
스트림상에서 디초코 상품들의 상표명을 "dechocolatecoffee"로 변경하고 출력하세요.
4.금액이 십만원 이상인 상품을 따로 list로 생성하고 출력하세요.
5.상품이름순으로 정렬후 출력하세요. (sorted(Comparator)메소드 이용)
6.가격순으로 내림차순정렬후 출력하세요.
*/
public class App {
    List<Product> list = List.of(
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
        App app = new App();
        app.test1();
        app.test2();
        app.test3();
        app.test4();
        app.test5();
        app.test6();

    }

    //전자기기류만 모두 출력
    public void test1(){
        System.out.println("전자기기류만 모두 출력");
        list.stream().forEach(product -> {
            if(product.getCategory().equals("전자기기류")){
                System.out.println(product);
            }
        });
    }

    //2.apple사가 전제품 10% 할인한다고 할때, 해당제품명과 할인된 가격을 출력하세요.
    public void test2(){
        System.out.println("2.apple사가 전제품 10% 할인한다고 할때, 해당제품명과 할인된 가격을 출력하세요.");
        list.stream().forEach(product -> {
            System.out.println(product.getProductName() + ", " + (int)(product.getPrice()*0.9));
        });
    }

    /*3. 디초코 상표명이 "dechocolatecoffee"로 변경되었다.
    스트림상에서 디초코 상품들의 상표명을 "dechocolatecoffee"로 변경하고 출력하세요.
     */
    public void test3(){
        System.out.println("상품 이름 변경");
        Stream<Product> stream = list.stream();
        List<Product> list2 = stream.filter((product) -> product.getBrand().equals("디초코")).peek(product -> product.setBrand("dechocolatecoffee")).toList();
        list2.forEach(System.out::println);

    }

    public void test4(){
        //금액이 십만원 이상인 상품을 따로 list로 생성하고 출려하세요.
        System.out.println("10만원 이상인 상품 리스트");
        Stream<Product> stream = list.stream();
        List<Product> list2 = stream.filter(product -> product.getPrice()>100_000).collect(Collectors.toList());
        list2.forEach(System.out::println);
    }

    public void test5(){
    //   상품이름순으로 정렬후 출력하세요. (sorted(Comparator)메소드 이용)
        System.out.println("상품 이름순으로 정렬 후 출력");
        Comparator<Product> nameCompare = Comparator.comparing(Product::getProductName);
        List<Product> sortedList = list.stream().sorted(nameCompare).toList();
        sortedList.forEach(System.out::println);
    }

    public void test6(){
//        6.가격순으로 내림차순정렬후 출력하세요.
        System.out.println("가격 순으로 내림차순 정렬");
        Comparator<Product> productComparator = Comparator.comparing(Product::getPrice).reversed();
        list.stream().sorted(productComparator).forEach(System.out::println);

    }

}
