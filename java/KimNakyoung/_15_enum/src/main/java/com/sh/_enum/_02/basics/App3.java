package com.sh._enum._02.basics;

import java.util.EnumSet;
import java.util.Iterator;

public class App3 {

    //클래스 객체란?
    // 실제 인스턴스 생성을 위해 참조하는 타입별 원형객체(필드/메소드관련 정보를 가지고 있다.)

    public static void main(String[] args) {
        EnumSet<SubjectType> enumSet = EnumSet.allOf(SubjectType.class);
        Iterator<SubjectType> iterator = enumSet.iterator();
        while (iterator.hasNext()){
            SubjectType next = iterator.next();
            System.out.println(next.ordinal() + " " + next.name());

        }

        // enum타입의 일부만 다시 그룹핑할 수 있다.
        // 이넘 전용 셋
        EnumSet<SubjectType> backendSet = EnumSet.of(SubjectType.JAVA, SubjectType.MYSQL);
//        EnumSet<SubjectType> frontendSet = EnumSet.of(SubjectType.HTML, SubjectType.CSS,SubjectType.JAVASCRIPT);
        EnumSet<SubjectType> frontendSet = EnumSet.complementOf(
                                                    EnumSet.of(SubjectType.JAVA, SubjectType.MYSQL)); // 전체에서 뺄 수 도 있음.


        for (SubjectType subjectType : backendSet) {
            System.out.println(subjectType);
        }
        System.out.println("------------------------------");

        for (SubjectType subjectType : frontendSet) {
            System.out.println(subjectType);

        }


    }
}
