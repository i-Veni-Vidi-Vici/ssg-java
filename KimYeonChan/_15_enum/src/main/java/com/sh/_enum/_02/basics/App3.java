package com.sh._enum._02.basics;

import java.util.EnumSet;
import java.util.Iterator;

/**
 * <pre>
 *     반복처리를 위해 EnumSet 타입을 제공한다.
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        // 클래스객체란? 실제 인스턴스 생성을 위해 참조하는 타입별 원형 객체(필드, 메소드 관련 정보를 가지고 있다.)
        EnumSet<SubjectType> enumSet1 = EnumSet.allOf(SubjectType.class);
        Iterator<SubjectType> iterator = enumSet1.iterator();
        while (iterator.hasNext()) {
            SubjectType next = iterator.next();
            System.out.println(next.ordinal() + " " + next.name());
        }

        // enum 타입의 일부만 다시 그룹핑할 수 있다.
        EnumSet<SubjectType> backendSet = EnumSet.of(SubjectType.JAVA, SubjectType.MYSQL);
        EnumSet<SubjectType> frontendSet = EnumSet.of(SubjectType.HTML, SubjectType.CSS, SubjectType.JAVASCRIPT);

        for (SubjectType subjectType : backendSet) {
            System.out.println(subjectType.ordinal() + " " + subjectType.name());
        }
        for (SubjectType subjectType : frontendSet) {
            System.out.println(subjectType.ordinal() + " " + subjectType.name());
        }
    }
}
