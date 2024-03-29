package com.ssg.collections.list.customer;

import java.util.ArrayList;
import java.util.Comparator;

public class CustomerMain {
	private ArrayList<Customer> list = new ArrayList<>();

	public static void main(String[] args) {
		CustomerMain cMain = new CustomerMain();
		cMain.test1();
		cMain.test2();
		cMain.test3();
		cMain.test4();
		cMain.test5();
	}

	private void test1() {
		this.list.add(new Customer("홍길동", 25, '남', 1250.5));
		this.list.add(new Customer("박문수", 33, '남', 3457.8));
		this.list.add(new Customer("김춘추", 38, '남', 2485.6));
		this.list.add(new Customer("신사임당", 43, '여', 2300.9));
		System.out.println("1번 : " + this.list);
	}
	
	private void test2() {
		this.list.add(0, new Customer("이황", 66, '남', 9999.9)); // 데이터 추가
		System.out.println("2번 : " + this.list);
	}
	
	private void test3() {
		this.list.sort((c1, c2) -> c1.getName().compareTo(c2.getName())); // 이름 가나다 오름차순
		System.out.println("3번 : " + this.list);
	}

	private void test4(){
		this.list.sort(new Comparator<Customer>() {
			@Override
			public int compare(Customer o1, Customer o2) {
				return (int) (o1.getAge() - o2.getAge()); // 나이 오름차순
			}
		});
		System.out.println("4번 : " + this.list);
	}

	private void test5() {
		this.list.sort(new Comparator<Customer>() {
			@Override
			public int compare(Customer o1, Customer o2) {
				return (int) (o2.getPoint() - o1.getPoint()); // 포인트 내림차순
			}
		});
		System.out.println("5번 : " + this.list);
	}

}
