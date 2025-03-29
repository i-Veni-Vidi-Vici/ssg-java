// 1 - 1 if 문 / 삼항 연산자
const grade = '운영자';

authority = ['글 읽기', '글 쓰기'];

if(grade === '손님'){
    console.log(grade + "의 경우 " + authority + "가 가능합니다");
}
else {
    console.log(grade + "의 경우 " + authority + ", 글 삭제"+ "가 가능합니다");
}

// 1 - 2 switch문
const browser = 'Edge';

switch (browser) {
    case 'Edge' : console.log("Edge를 사용하고 계시네요!"); break;
    case 'Chrome' : console.log("저희 서비스가 지원하는 브라우저를 사용하고 계시네요."); break;
    case 'Firefox' : console.log("저희 서비스가 지원하는 브라우저를 사용하고 계시네요."); break;
    default : console.log("현재 페이지가 괜찮아 보이길 바랍니다!");
}

// 1 - 3 반복문
let i = 1;
while(true) {
    console.log("number " + i);
    if(i++ > 9) break;
}

