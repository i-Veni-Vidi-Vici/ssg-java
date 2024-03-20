package com.sh.dto;

import com.sh.custom.type.Member;

/**
 * <pre>
 * DTO Data Transfer Object
 * - 데이터 전송객체
 * - 클래스가 행위가 아니라 데이터를 보관하고, 전달하기 위한 목적으로 설계 할 수 있다.
 * - 캡슐화원칙에 따라 private필드, public메소드를 작성한다.
 * - 각 필드에 대해서 기본적으로 값을 설정하는 setter메소드와 값을 읽기위한 getter메소드를 작성해둔다.
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        MemberDTO memberDTO = new MemberDTO();
    }
}
