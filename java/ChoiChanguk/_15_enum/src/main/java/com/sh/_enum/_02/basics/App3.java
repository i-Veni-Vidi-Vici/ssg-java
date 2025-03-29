package com.sh._enum._02.basics;

import java.util.EnumSet;
import java.util.Iterator;
/**
 * <pre>
 * 반복처리를 위해 EnumSet타입을 제공한다.
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        // 클래스객체란? 실제 인스턴스 생성을 위해 참조하는 타입별 원형객체
        // ordinal = 인덱스값
        EnumSet<SubjectType> enumSet1=EnumSet.allOf(SubjectType.class);
        EnumSet<SubjectType> enumSet2=enumSet1.clone();

        Iterator<SubjectType> iterator = enumSet1.iterator();

        while (iterator.hasNext()) {
            SubjectType next = iterator.next();
            System.out.println("ordinal(인덱스) " + next.ordinal() + " " + ".name()" + next.name());
        }

        // clone
        System.out.println("clone " + enumSet1);
        System.out.println("clone " + enumSet2);

        // enum타입의 일부만 다시 그룹핑할 수 있다.
        //
        EnumSet<SubjectType> backendset1=EnumSet.of(SubjectType.MYSQL, SubjectType.JAVA);
        //EnumSet<SubjectType> frontendset=EnumSet.of(SubjectType.HTML, SubjectType.CSS, SubjectType.JAVASCRIPT);

        EnumSet<SubjectType> frontendset=EnumSet.complementOf(EnumSet.of(SubjectType.MYSQL, SubjectType.JAVA));

        System.out.println("백엔드만 찍어라");
        for(SubjectType subjectType:backendset1)
        {
            System.out.println(subjectType);
        }

        System.out.println("프론트엔드만 찍어라");
        for(SubjectType subjectType:frontendset)
        {
            System.out.println(subjectType);
        }
    }
}
