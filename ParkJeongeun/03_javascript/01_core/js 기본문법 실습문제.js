// 1.1 if문/삼항연산자

// if문
const a = function(grade){
    if(grade == '손님'){
        authority = '글 읽기',
        console.log(grade, '의 경우 ', authority, '가 가능합니다.')
    } else if(grade == '일반 회원'){
        authority = '글 읽기, 글 쓰기',
        console.log(grade, '의 경우 ', authority, '가 가능합니다.');
    } else {
        authority = '글 읽기, 글 쓰기, 글 삭제',
        console.log(grade, '의 경우 ', authority, '가 가능합니다.');
    }
}
a('일반 회원');

// 삼항연산자
const grade = '운영자';
grade == '손님' && console.log(grade, '의 경우 글 읽기가 가능합니다.');
grade == '일반 회원' && console.log(grade, '의 경우 글 읽기, 글 쓰기가 가능합니다.');
grade == '운영자' && console.log(grade, '의 경우 글 읽기, 글 쓰기, 글 삭제가 가능합니다.');

// 1.2 switch문
const browser = 'naver';
switch(browser){
    case 'Edge' : console.log('Edge를 사용하고 계시네요!'); break;
    case 'Chrome' : 
    case 'Firefox' : 
    case 'Safari' : 
    case 'Opera' : console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.'); break;
    default : console.log('현재 페이지가 괜찮아 보이길 바랍니다!'); break;
}

// 1.3 반복문
let i = 0;
while(i < 10){
    console.log('number' + (i + 1));
    i++;
}