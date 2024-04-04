package com.sh._enum._02.basics;

import java.util.EnumSet;
import java.util.Iterator;

/**
 * <pre>
 * 반복처리를 위해 EnumSet 타입 제공
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        // class 객체 : 실제 인스턴스 생성을 위해 참조하는 타입별 원형 객체(필드/메소드 관련 정보 가짐)
        EnumSet<SubjectType> enumSet1 = EnumSet.allOf(SubjectType.class);
        Iterator<SubjectType> iterator = enumSet1.iterator();
        while (iterator.hasNext()) {
            SubjectType next = iterator.next();
            System.out.println(next.ordinal() + " " + next.name());
        }

        // enum타입의 일부만 다시 그룹핑 가능
        EnumSet<SubjectType> backendSet = EnumSet.of(SubjectType.JAVA, SubjectType.MYSQL);
        EnumSet<SubjectType> frontendSet = EnumSet.of(SubjectType.HTML, SubjectType.CSS, SubjectType.JAVASCRIPT);
//        EnumSet<SubjectType> frontendSet = EnumSet.complementOf(EnumSet.of(SubjectType.JAVA, SubjectType.MYSQL)); // 맨 안쪽 괄호 값 빼고 출력
//        Iterator<SubjectType> iter = backendSet.iterator();
//        while (iter.hasNext()) {
//            SubjectType next1 = iter.next();
//            System.out.println(next1);
//        }
//        Iterator<SubjectType> iter2 = frontendSet.iterator();
//        while (iter2.hasNext()) {
//            SubjectType next2 = iter2.next();
//            System.out.println(next2);
//        }

        for (SubjectType subject : backendSet)
            System.out.println("backend : " + subject);
        System.out.println();
        for (SubjectType subject : frontendSet) {
            System.out.println("frontend : " + subject);
        }
    }
}
