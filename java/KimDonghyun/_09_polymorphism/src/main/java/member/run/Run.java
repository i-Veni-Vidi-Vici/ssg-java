package member.run;

import member.repository.MemberRepository;
import member.model.vo.Gold;
import member.model.vo.Ruby;
import member.model.vo.Silver;
import member.model.vo.VVip;
import member.model.vo.Vip;

public class Run {
	public static void main(String[] args){
		MemberRepository memberRepository = new MemberRepository();
		memberRepository.insertMember(new Silver("홍길동", "Silver",1000));
		memberRepository.insertMember(new Silver("고길동", "Silver",2000));
		memberRepository.insertMember(new Silver("홍동민", "Silver",3000));
		memberRepository.insertMember(new Gold("김회장", "Gold",1000));
		memberRepository.insertMember(new Gold("이회장", "Gold",2000));
		memberRepository.insertMember(new Gold("오회장", "Gold",3000));
		memberRepository.insertMember(new Vip("최순실", "Vip",10000));
		memberRepository.insertMember(new VVip("박근혜", "VVip",100000));
		
		// Ruby등급추가
		memberRepository.insertMember(new Ruby("문재인", "Ruby", 500000));
		
		memberRepository.printData();
		
		// 물건구매시 할인된 가격출력
		memberRepository.printBuyInfo(10000);
		
		
		
	}
}
