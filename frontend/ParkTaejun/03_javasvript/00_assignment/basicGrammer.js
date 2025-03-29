// 1-1. if문 /삼항연산자

var grade = '운영자';
let authority = '글 읽기 ';

if(grade == '손님'){
    authority;
}
else if(grade == '일반회원'){
     authority = '글 읽기, 글 쓰기';
}
else{
 authority = '글 읽기, 글 쓰기, 글 삭제';
}

console.log(grade + "일 경우 " + authority+"가 가능합니다.");

// 삼항연산자코드

;

var grade = '손님';

authority =  (grade == '손님') ? ' 글 읽기' : (grade == '일반회원') ? '글 읽기, 글 쓰기' : ' 글 읽기, 글 쓰기, 글 삭제';

console.log(grade + '일 경우 ' + authority + '가 가능합니다 . ');

// switch문 변환

var brower = 'Firefox'
switch(true){
    case brower == 'Edge' : 
    console.log("Edge를 사용하고 계시네요!"); break;
    case brower == 'Chrome' : 
    console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.'); break;
    case brower == 'Firefox' :
    console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.'); break;
    case brower == 'Safari' :
    console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.'); break;
    case brower == 'Opera' :
    console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.'); break;
    default :
    console.log('현재 페이지가 괜찮아 보이길 바랍니다. '); break;
}

//반복문 (for 문 while 문으로 바꿈)
var i = 0;
while(true){
        console.log(' number ' + (i+1));
        i ++;
        if(i == 10) break;
}