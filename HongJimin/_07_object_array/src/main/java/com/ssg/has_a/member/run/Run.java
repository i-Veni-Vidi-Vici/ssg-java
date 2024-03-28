package com.ssg.has_a.member.run;

import com.ssg.has_a.member.model.repository.MemberRepository;
import com.ssg.has_a.member.model.vo.Gold;
import com.ssg.has_a.member.model.vo.Silver;

public class Run {
    public static void main(String[] args){
        MemberRepository memberRepository = new MemberRepository();
        memberRepository.silverInsert(new Silver("홍길동", "Silver",1000));
        memberRepository.silverInsert(new Silver("김말똥", "Silver",2000));
        memberRepository.silverInsert(new Silver("고길동", "Silver",3000));
        memberRepository.goldInsert(new Gold("김회장", "Gold",1000));
        memberRepository.goldInsert(new Gold("이회장", "Gold",2000));
        memberRepository.goldInsert(new Gold("오회장", "Gold",3000));
        memberRepository.printData();


        /**출력 예시
         * ---------------------------<<회원정보>>---------------------------
         * 이름              등급             포인트         이자포인트
         * -----------------------------------------------------------------
         * 홍길동             Silver          1000            20.00
         * 김말똥             Silver          2000            40.00
         * 고길동             Silver          3000            60.00
         * 김회장             Gold            1000            50.00
         * 이회장             Gold            2000            100.00
         * 오회장             Gold            3000            150.00
         */

//        // vip 추가
//        m.vipInsert(new Vip("이부자", "Vip",10000));
//        // vvip 추가
//        m.vvipInsert(new VVip("김갑부", "VVip",100000));
    }

}
