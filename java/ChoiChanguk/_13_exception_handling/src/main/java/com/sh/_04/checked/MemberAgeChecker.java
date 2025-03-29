package com.sh._04.checked;

public class MemberAgeChecker {
    //얘가 메인문에서 정보를 받고, 판단한 후 RuntimeException을 슈퍼클래스로 갖는
    // notAdult로 쏴준다 그러면 notAdult 에서 슈퍼클래스에게 super(str)을 줘서
    // str을 뿌려준다
    public void checkAge(int age) throws NotValidMemberAgeException {
        if(age<20)
            throw new NotValidMemberAgeException("미성년자 이므로 게임을 이용할 수 없습니다 나이 : "+age);
    }
}
