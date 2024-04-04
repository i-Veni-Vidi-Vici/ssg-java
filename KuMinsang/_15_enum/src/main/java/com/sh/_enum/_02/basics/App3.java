package com.sh._enum._02.basics;

import java.util.EnumSet;
import java.util.Iterator;

/**
 * <pre>
 *     반복처리를 위해 EnumSet 타입을 제공한다
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        // 클래스 객체란? 실제 인스턴스 생성을 위해 참조하는 타입별 원형객체
        EnumSet<SubjectType> enumSet1 = EnumSet.allOf(SubjectType.class);
        Iterator<SubjectType> iterator = enumSet1.iterator();
        while(iterator.hasNext()){
            SubjectType next = iterator.next();
            System.out.println(next.ordinal() + " " + next.name());
//            0 JAVA
//            1 MYSQL
//            2 HTML
        }

        //enum타입의 일부만 다시 그룹핑도 가능하다
        EnumSet<SubjectType> backendSet = EnumSet.of(SubjectType.JAVA, SubjectType.MYSQL);
//        EnumSet<SubjectType> frontendSet = EnumSet.of(SubjectType.HTML, SubjectType.CSS, SubjectType.JAVA);
        EnumSet<SubjectType> frontendSet = EnumSet.complementOf(EnumSet.of(SubjectType.JAVA, SubjectType.MYSQL));
        //EnumSet에 포함되지 않는 다른 요소를 반환

        Iterator<SubjectType> backIter = backendSet.iterator();
        Iterator<SubjectType> frontIter = frontendSet.iterator();
        for(SubjectType subject : backendSet){
            System.out.println("backend : " + subject);
        }
        for(SubjectType subject : frontendSet){
            System.out.println("frontend : " + subject);
        }
    }

}
