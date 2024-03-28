package com.ssg.collections.list.customer;

import java.util.*;

/**1. 위 표에 제시한 순서대로 데이터를 List에 추가하세요.
 2. 위 리스트에 다음데이터를 맨앞에 추가하세요.
 3. 고객 이름 가나다순으로 정렬 해서 출력하세요.
 4. 나이 오름차순으로 정렬해서 출력하세요.
 5. 포인트 내림차순으로 정렬해서 출력하세요.
 *
 *
 */
public class CustomerMain {
    public static void main(String[] args) {
        List<Customer> list = new ArrayList<>();
        list.add(new Customer("홍길동", 25, '남', 1250.5));
        list.add(new Customer("박문수", 33, '남', 3457.8));
        list.add(new Customer("김춘추", 38, '남', 2485.6));
        list.add(new Customer("신사임당", 43, '여', 2300.9));


    }
}
