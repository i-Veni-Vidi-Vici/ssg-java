package com.ssg.collections.map.book.controller;

import com.ssg.collections.list.book.model.vo.Book;

import java.util.*;

public class BookMapManager {
    private HashMap<String, Book> bookMap;

    public BookMapManager() {
        bookMap = new HashMap<String, Book>();
    }

    public BookMapManager(HashMap<String, Book> bookMap) {
        this.bookMap = new HashMap<String, Book>(bookMap);
    }

    //맵에 객체 추가, 도서번호 키로 사용함
    public void addBook(Book book){
        bookMap.put(book.getNo(), book);
    }
    //맵에서 객체 제거
    public void deleteBook(String key){
        bookMap.remove(key);
    }
    //맵을 순회하면서 전달 받은 도서명과 일치하는 도서가 있다면, 객체의 도서번호를 리턴
    //전달받은 도서명과 일치하는 도서가 없으면 null
    public String searchBook(String title){
        Set<String> keySet = bookMap.keySet();
        for(String key : keySet){
            if(bookMap.get(key).getTitle().equals(title)){
                return key;
            }
        }
        return null;
    }

    //맵정보 모두 출력
    public void printAll(){
        System.out.println("""
                ==========================
                모든 도서 목록 출력
                ==========================
                도서번호  분류코드  제목  저자""");
        Set<String> kSet = bookMap.keySet();
        for(String key : kSet){
            Book book = bookMap.get(key);
            System.out.printf("%s  %d  %s  %s\n",book.getNo(), book.getCategory(), book.getTitle(), book.getAuthor());
        }
    }

    //전달 받은 책 목록 출력
    public void printBookMap(List<Book> book){
        System.out.println("""
                ==========================
                도서 목록 출력
                ==========================
                도서번호  분류코드  제목  저자""");
        for(Book e : book){
            System.out.println(e.getNo()+"  " + e.getCategory()+ "  " + e.getTitle()+ "  " + e.getAuthor());
        }
    }

    //책 한권 출력
    public void printBook(String key){
        System.out.println("""
                ==========================
                책 한 권 정보 출력
                ==========================
                도서번호  분류코드  제목  저자""");
        Book book = bookMap.get(key);
        System.out.printf("%s  %d  %s  %s\n",book.getNo(), book.getCategory(), book.getTitle(), book.getAuthor());
    }

    public List<Book> SortedBookListByNo(){
        List<Book> list = new ArrayList<>();
        Set<String> keys = bookMap.keySet();
        for(String key : keys){
            list.add(bookMap.get(key));
        }
        Collections.sort(list, new Comparator<Book>(){
            @Override
            public int compare(Book o1, Book o2){
                return Integer.parseInt(o1.getNo()) - Integer.parseInt(o2.getNo());
            }
        });
        return list;
    }

    public List<Book> sortedBookListByCategory(){
        List<Book> list = new ArrayList<>();
        Set<String> keys = bookMap.keySet();
        for(String key : keys){
            list.add(bookMap.get(key));
        }
        Collections.sort(list, new Comparator<Book>(){
            @Override
            public int compare(Book o1, Book o2){
                return o1.getCategory()-o2.getCategory();
            }
        });
        return list;
    }
}
