package collections._02.set;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set 인터페이스
 * - 중복을 허용해서는 안되는 데이터를 관리힌다.
 * - 저장된 순서를 관리하지 않는다.
 * - 구현클래스 HashSet, LinkedHashSet(저장된 순서 기억), TreeSet(오름차순 정렬처리)
 * - List 와 공통된 부모인터페이스 Collection 을 공유하다.
 */
public class App {
    public static void main(String[] args) {
//        HashSet set1 = new HashSet();
//        Set set2 = new HashSet(); // 주로 Set 으로 관리
//        Collection set3 = new HashSet();
        Set<String> set = new HashSet<>();
        // add(E) 요소추가
        set.add("java");
        set.add("mysql");
        set.add("html");
        set.add("css");
        set.add("spring");

        // 중복저장
        System.out.println(set.add("java"));

        // 전체 요소수
        System.out.println(set.size());

        // 포함 여부
        System.out.println(set.contains("spring"));
        System.out.println(set.contains("node"));

      //    set.indexOf() // Set 에는 인덱스 기반의 메소드가 존재하지 않는다.
      //    set.get(0)

        // toString
        System.out.println(set);

        // 반복처리 - 인덱스가 존재하지 않으므로, 일반 for 문을 사용할 수 없다.
        // 1. for each
        for (String str : set) {
            System.out.println(str);
        }
        // 2. Iterator
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            String next = iter.next();
            System.out.println(next);
        }

        // clear() 모든 요소 제거
        set.clear();

        // isEmpty() 비어있는지 여부
        System.out.println(set.isEmpty());
    }
}
