package collections._01.list;

import java.time.LocalDate;
import java.util.*;

public class App1 {
    public static void main(String[] args) {
//        ArrayList list1 = new ArrayList();
//        List list2 = new ArrayList();
//        Collection list3 = new ArrayList();

        List<String> list = new ArrayList<>();

        // 요소추가
        list.add("abc");
        list.add("banana");
        list.add("call");
        list.add("data");
        list.add("eeeeeeeeee");
//        list.add(123);
//        list.add(123.456);
//        list.add(LocalDate.now());

        // get(인덱스: int)
        String elem0 = list.get(0); // 리턴타입 String 보장!
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));
//        System.out.println(list.get(3));
//        System.out.println(list.get(4));

        // 삽입 add(int, E)
        list.add(2, "ㅋㅋㅋ");

        // 대체 (set(int, E)
        list.set(2, "ㅎㅎㅎ");

        // 제거 remove(int)
        list.remove(2);

        // 정렬 - 기본 오름차순 정렬
        Collections.sort(list); // 원본 리스트 수정

        // 내림차순
        Comparator<String> comparator = Collections.reverseOrder(); // 정렬기준객체
        Collections.sort(list, comparator);

        //
        System.out.println(list.size()); // 5

        // 반복처리
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

        // iterator 객체를 통한 반복처리 (Iterable#iterator() -> list, set)
        // - hasNext() 다음요소 존재여부 반환
        // - next() 다음요소 반환
//        Iterator<String> iter = list.iterator();
//        while (iter.hasNext()) {
//            String next = iter.next();
//            System.out.println(next);
//        }

        // 다른 리스트를 통으로 복사하기
        List<String> list2 = new ArrayList<>(list);
        System.out.println(list2);

        // toString
        System.out.println(list);
    }
}
