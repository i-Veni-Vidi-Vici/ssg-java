package com.ssg.collections.map.book.controller;

import com.ssg.collections.list.book.model.vo.Book;

import java.util.*;

public class BookMapManager {
    private Map<String, Book> bookMap = new HashMap<>();

    public BookMapManager() {
        bookMap.put("A3B2C1", new Book("A3B2C1", 2, "나미야 잡화점의 기적", "히가시노 게이고"));
        bookMap.put("35LK23", new Book("35LK23", 3, "파리의 아파트", "기욤 뮈소"));
        bookMap.put("DS25KZ", new Book("DS25KZ", 1, "ABCDE", "도레미"));
        bookMap.put("K0DR0S", new Book("K0DR0S", 2, "미중전쟁", "김진명"));
        bookMap.put("5KOSR3", new Book("5KOSR3", 1, "JAVA 삽질하기", "김동현"));
    }
    public BookMapManager(Map<String, Book> bookMap) {
        this.bookMap = bookMap;
    }

    // 맵에 객체 추가, 도서번호를 키로 사용함
    public void addBook(Book book) {
        bookMap.put(book.getNo(), book);
        System.out.println("> 새 도서를 추가했습니다.");
    }

    // 맵에서 객체 제거
    public void deleteBook(String key) {
        if(key != null) {
            bookMap.remove(key);
            System.out.println("> 도서를 삭제했습니다.");
        }
        else
            System.out.println("> 도서를 삭제하지 못 했습니다. 도서명을 잘못 입력하셨습니다.");
    }

    // map을 순회하면서
    //  - 전달받은 도서명과 일치하는 도서가 있다면, 객체의 도서번호를 리턴
    //  - 전달받은 도서명과 일치하는 도서가 없으면, null 리턴함
    public String searchBook(String title) {
        Iterator<Map.Entry<String, Book>> iter = bookMap.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<String, Book> next = iter.next();
            String key = next.getKey();
            Book value= next.getValue();

            if(title.equals(bookMap.get(key).getTitle()))
                return key;
        }
        return null;
    }

    // 맵정보 모두 출력
    public void printAll() {
        System.out.println("BookMap" + bookMap);
    }

    // 전달받은 책 목록 출력
    public void printBookMap(List<Book> bookList) {
        System.out.println("BookMap" + bookList);
    }

    // 책한권 출력
    public void printBook(String key) {
        if(key != null) {
            System.out.println("> 도서를 검색했습니다.");
            System.out.println("key[" + key + "] : " + bookMap.get(key));
        }
        else
            System.out.println("> 도서를 검색하지 못 했습니다. 도서명을 잘못 입력하셨습니다.");
    }

    // Map#values():Collection를 새로운 List<Book> 인자로 전달해서 복사본을 만들어 사용
    // 기본정렬(번호 오름차순) 후 반환
    public List<Book> sortedBookListByNo() {
        List<Book> bookList = new ArrayList<>(bookMap.values());
        Comparator<Book> bookNoAscComparator = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getNo().compareTo(o2.getNo());
            }
        };
        Collections.sort(bookList, bookNoAscComparator);
        return bookList;
    }

    // Map#values():Collection를 새로운 List<Book> 인자로 전달해서 복사본을 만들어 사용
    // 카테고리 오름차순 후 반환
    public List<Book> sortedBookListByCategory() {
        List<Book> bookList = new ArrayList<>(bookMap.values());
        Comparator<Book> bookCategoryAscComparator = new Comparator<Book>() {
          @Override
          public int compare(Book o1, Book o2) {
              return o1.getCategory() - o2.getCategory();
          }
        };
        Collections.sort(bookList, bookCategoryAscComparator);
        return bookList;
    }
}
