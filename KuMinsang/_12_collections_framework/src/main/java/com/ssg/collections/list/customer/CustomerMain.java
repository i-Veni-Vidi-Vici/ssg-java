package com.ssg.collections.list.customer;

import java.util.ArrayList;
import java.util.Comparator;

public class CustomerMain {
	private ArrayList<Customer> list = new ArrayList<>();

	public static void main(String[] args) {
		CustomerMain main = new CustomerMain();
		main.test1();
		main.test2();
		main.test3();
		main.test4();
	}

	private void test1() {
		this.list.add(new Customer("홍길동", 25, '남', 1250.5));
		this.list.add(new Customer("박문수", 33, '남', 3457.8));
		this.list.add(new Customer("김춘추", 38, '남', 2485.6));
		this.list.add(new Customer("신사임당", 43, '여', 2300.9));
		System.out.println("[문제1] " + this.list);
	}
	
	private void test2() {
		this.list.add(0, new Customer("이황", 66, '남', 9999.9));
		System.out.println("[문제2] " + this.list);
	}
	
	private void test3() {
		// List#sort(Comparator) : Collections.sort(List, Comparator) 동일하다.
		this.list.sort((c1, c2) -> c1.getName().compareTo(c2.getName()));
		System.out.println("[문제3] " + this.list);
	}
	
	private void test4() {
		this.list.sort(new Comparator<Customer>() {
			@Override
			public int compare(Customer o1, Customer o2) {
				return (int) (o2.getPoint() - o1.getPoint());
			}
		});
		System.out.println("[문제4] " + this.list);		
	}

}
