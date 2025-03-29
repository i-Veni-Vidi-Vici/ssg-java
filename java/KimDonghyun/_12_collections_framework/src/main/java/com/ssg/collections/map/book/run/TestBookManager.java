package com.ssg.collections.map.book.run;

import com.ssg.collections.list.book.model.vo.Book;
import com.ssg.collections.map.book.controller.BookManager;

import java.util.Random;
import java.util.Scanner;

public class TestBookManager {
	Scanner sc = new Scanner(System.in);
	BookManager bm = new BookManager();
	
	public static void main(String[] args) {
		TestBookManager t = new TestBookManager();
		t.menu();
		System.out.println("프로그램을 종료합니다.");
	}

	public void menu() {
		String menu = """
				*** 도서 관리 프로그램 ***
				1. 새 도서 추가
				2. 도서정보 출력(책번호 오름차순)
				3. 도서정보 출력(카테고리 오름차순)
				4. 도서 삭제
				5. 도서 검색출력
				6. 전체 출력
				0. 끝내기
				--------------------
				메뉴선택 : """;
		
		while(true){
			System.out.print(menu);
			String selected = sc.next();
			switch (selected) {
			case "1" : bm.addBook(inputBook()); break;
			case "2" : bm.printBookList(bm.sortedBookListByNo()); break;
			case "3" : bm.printBookList(bm.sortedBookListByCategory()); break;
			case "4" : bm.deleteBook(bm.searchBook(inputBookTitle())); break;
			case "5" : bm.printBook(bm.searchBook(inputBookTitle())); break;
			case "6" : bm.printAll(); break;
			case "0" : return;
			default: System.out.println("잘못 입력하셨습니다."); break;
			}	
		}
	
	}

	public String inputBookTitle() {
		sc.nextLine();
		System.out.print("책제목을 입력하세요 : ");
		return sc.nextLine();
	}

	public Book inputBook() {
//		System.out.print("책번호 : ");
//		String no = sc.next();
		String no = generateBookNo();
		System.out.print("책카테고리 (1.인문/2.자연과학/3.의료/4.기타) : ");
		int category = sc.nextInt();
		sc.nextLine();
		System.out.print("책제목 : ");
		String title = sc.nextLine();
		System.out.print("저자 : ");
		String author = sc.nextLine();
		return new Book(no, category, title, author);
	}
	
	/**
	 * 임의의 책번호 6자리를 발급하는 메소드
	 * - 영대문자/숫자 혼합
	 * @return
	 */
	private String generateBookNo() {
		StringBuilder sb = new StringBuilder();
		Random rnd = new Random();
		for(int i = 0; i < 6; i++)
			if(rnd.nextBoolean())
				sb.append(rnd.nextInt(10)); // 0 ~ 9사이의 임의수 1
			else 
				sb.append((char) (rnd.nextInt(26) + 'A')); // A ~ Z
		return sb.toString();
	}

}
