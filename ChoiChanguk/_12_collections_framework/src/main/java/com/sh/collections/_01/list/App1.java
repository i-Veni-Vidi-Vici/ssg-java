package com.sh.collections._01.list;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

/**
 * <pre>
 * Collection
 *  - List
 *      - ArrayList (대표)
 *      - LinkedList
 *
 * ArrayList 객체안에는 데이터를 관리할 배열을 가지고 있다.
 * </pre>
 */
public class App1 {
    private long id;
    private String title;
    private String author;
    private int price;
    @Override
    public String toString() {
        return "Book { " +
                "id = " + id +
                ", title = '" + title + '\'' +
                ", author = '" + author + '\'' +
                ", price = " + price +
                " }" + "\n";
    }

    public App1() {

    }

    public App1(long id, String title, String author, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public static void main(String[] args) {

//        ArrayList list1=new ArrayList();
//        List list2=new ArrayList(); //이걸 많이들 쓴다, List에 추상메소드가 ArrayList에 있으니
//        Collection list3=new ArrayList();

        //List list = new ArrayList(); //이 경우는 슈퍼클래스 Object다 = 사실 이렇게 잘 안쓴다
        List<String> list=new ArrayList<>(); // String 형식의 리스트 객체를 만든다

        list.add("asb");// 여기서부터는 형식을 정해주지 않아 Object로 등록이 된다
        //list.add(123123);
        //list.add(168 + 234234);
        list.add("오늘은");
        list.add("비가");
        list.add("추적추적 온다");

        // 등록과 반환을 Object로 했기 때문에 인트로는 안된다 + 다운캐스팅을 해주면 가능하다
        //int a = list.get(1)+123;
        //list.add(LocalDate.now());

        System.out.println(list);

        //List<String >list1=new ArrayList<>();

        //요소추가


        //get(인덱스)
        //int a = list.get(1)+13214;
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        //삽입
        list.add(1, "erfasdf");

        //대체 set(int, E)
        list.set(2,"ggg");

        //제거 remove(int)
        list.remove(2);

        //정렬 / 기본 오름차순
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        //정렬/ 내림차순
        Comparator<String > comparator=Collections.reverseOrder();
        //Collections.sort(list,comparator);

        //Collections.sort(list,Collections.reverseOrder());
//        for (int i = 0; i < list.size(); i++)
//            System.out.println(list.get(i));

        //toString
        System.out.println(list);

        //사이즈
        System.out.println(list.size());

        // 반복처리
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
        //for(<T> )

        // iterator 객체를 통한 반복처리 (Iterable#interator() -> list, set)
        // - hasNext() 다음요소 존재여부 반환
        // - next() 다음요소 반환


        //이것도 토큰과 똑같이 1회성이다 hasNext()에서는 항상 false반환
//        Iterator<String > iterator = list.iterator();
//        while(iterator.hasNext()) {
//            String next = iterator.next();
//            System.out.println(next);
//        }

        //다른 리스트를 통으로 복사하기
        List<String >list2=new ArrayList<>(list);

        System.out.println("리스트 복사 "+list2);
    }
}
