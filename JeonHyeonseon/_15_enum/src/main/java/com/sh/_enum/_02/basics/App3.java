package com.sh._enum._02.basics;

import javax.swing.text.html.HTMLDocument;
import java.util.EnumSet;
import java.util.Iterator;

/**
 * <pre>
 * 반복처리를 위해 EnumSet타입을 제공한다.
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        // 클래스객체란?? 실제 인스턴스 생성을 위해 참조하는 타입별 원형객체(필드/메소드 관련 정보를 가지고 있다.)
        // 클래스객체는 두 개가 될 수 없다.
        EnumSet<SubjectType> enumSet1 = EnumSet.allOf(SubjectType.class);
        Iterator<SubjectType> iterator = enumSet1.iterator();
        while(iterator.hasNext()) { // iterator.hasNext() = iterator야 다음거 있니..?라는 의미
            SubjectType next = iterator.next();
            System.out.println(next.ordinal() + " " + next.name());
        }
        System.out.println();

        // enum타입의 일부만 다시 그룹핑할 수 있다.
        EnumSet<SubjectType> backendSet = EnumSet.of(SubjectType.JAVA, SubjectType.MYSQL);// 백엔드끼리만 묶음
//        EnumSet<SubjectType> frontendSet = EnumSet.of(SubjectType.HTML, SubjectType.CSS, SubjectType.JAVASCRIPT);// 프론트엔드끼리만 묶음Iterator<SubjectType> iterator2 = backendSet.iterator();
        EnumSet<SubjectType> frontendSet = EnumSet.complementOf(EnumSet.of(
                                                    SubjectType.JAVA, SubjectType.MYSQL));
                                        // complementOf : (SubjectType.JAVA, SubjectType.MYSQL) 뺴고 다 출력해주세요.라는 의미
        for(SubjectType subject : backendSet)
            System.out.println("backend : " + subject);
        System.out.println();
        for(SubjectType subject : frontendSet)
            System.out.println("fronted : " + subject);

    }
}
