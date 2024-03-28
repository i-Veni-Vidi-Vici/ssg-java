package com.ssg.collections.list.customer;
import java.util.*;
public class CustomerMain {
    public static void main(String[] args) {
        List<Customer> list = new ArrayList<Customer>();
        list.add(new Customer("홍길동", 25, '남', 1250.5));
        list.add(new Customer("박문수", 33, '남', 3457));
        list.add(new Customer("김춘추", 38, '남', 2485.6));
        list.add(new Customer("신사임당", 43, '여', 2300.9));
        System.out.println(list);

        //리스트의 맨 앞에 새로운 데이터 추가
        list.add(0, new Customer("이황", 66, '남', 9999.9));
        System.out.println(list);

        //이름 키 값으로 하여 사전순 정렬
        list.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(list);

        //나이 오름차순 정렬
        list.sort(new Comparator<>(){
            @Override
            public int compare(Customer o1, Customer o2){
                return o1.getAge()-o2.getAge();
            }
        });
        System.out.println(list);

        //포인트 내림차순
        list.sort(new Comparator<>(){
           @Override
           public int compare(Customer o1, Customer o2){
               return (int)(o2.getPoint()-o1.getPoint());   //비교 순서를 바꿔서 내림차순으로 동작
           }
        });
        //Comparator 인터페이스의 compare는 비교 결과에 따라 양수, 음수, 0을 반환
        //음수 : 첫 번째 인수가 두 번째 인수보다 작음
        //양수 : 첫 번재 인수가 두 번째 인수보다 큼
        // 0 : 두 인수가 같음
        //이 규칙에 따르면 기본적인 로직은 오른차순으로 동작함
        //반환 값의 부호를 바꿔주면 반대로 내림차순으로 동작함
        System.out.println(list);

    }
}
