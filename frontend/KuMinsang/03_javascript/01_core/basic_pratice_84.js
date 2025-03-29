//문제1-1
//if문을 통한 처리
let authority;

var grade = '손님';
if(grade == '손님'){
    authority = "글 읽기"; 
}else if(grade == '일반회원'){
    authority = "글 읽기, 글 쓰기"; 
}else if(grade == '운영자'){
    authority = "글읽기, 글 쓰기, 글 삭제"; 
}
console.log(grade + "의 경우 " + authority + " 가 가능합니다.");

var grade = '회원';
if(grade == '손님'){
    authority = "글 읽기"; 
}else if(grade == '일반회원'){
    authority = "글 읽기, 글 쓰기"; 
}else if(grade == '운영자'){
    authority = "글읽기, 글 쓰기, 글 삭제"; 
}
console.log(grade + "의 경우 " + authority + " 가 가능합니다.");

var grade = '운영자';
if(grade == '손님'){
    authority = "글 읽기"; 
}else if(grade == '일반회원'){
    authority = "글 읽기, 글 쓰기"; 
}else if(grade == '운영자'){
    authority = "글읽기, 글 쓰기, 글 삭제"; 
}
console.log(grade + "의 경우 " + authority + " 가 가능합니다.");

//문제1-1
//삼항연산자를 이용한 처리
var grade = '손님';
authority = (grade == '손님') ? '글 읽기' : (grade == '일반회원') ? '글 읽기, 글 쓰기' : "글읽기, 글 쓰기, 글 삭제";
console.log(grade + "의 경우 " + authority + " 가 가능합니다.");

var grade = '일반회원';
authority = (grade == '손님') ? '글 읽기' : (grade == '일반회원') ? '글 읽기, 글 쓰기' : "글읽기, 글 쓰기, 글 삭제";
console.log(grade + "의 경우 " + authority + " 가 가능합니다.");

var grade = '운영자';
authority = (grade == '손님') ? '글 읽기' : (grade == '일반회원') ? '글 읽기, 글 쓰기' : "글읽기, 글 쓰기, 글 삭제";
console.log(grade + "의 경우 " + authority + " 가 가능합니다.");

//문제 1-2
//switch문
var browser = 'Edge';

switch(browser){
    case('Edge') : console.log('Edge를 사용하고 계시네요!'); break;
    case('Chrome') : console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.'); break;
    case('Firefox') : console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.'); break;
    case('Safari') : console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.'); break;
    case('Opera') : console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.'); break;
    default : console.log('현재 페이지가 괜찮아 보이길 바랍니다!'); break;
}

browser = 'Chrome';
switch(browser){
    case('Edge') : console.log('Edge를 사용하고 계시네요!'); break;
    case('Chrome') : console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.'); break;
    case('Firefox') : console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.'); break;
    case('Safari') : console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.'); break;
    case('Opera') : console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.'); break;
    default : console.log('현재 페이지가 괜찮아 보이길 바랍니다!'); break;
}

browser = 'Opera';
switch(browser){
    case('Edge') : console.log('Edge를 사용하고 계시네요!'); break;
    case('Chrome') : console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.'); break;
    case('Firefox') : console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.'); break;
    case('Safari') : console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.'); break;
    case('Opera') : console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.'); break;
    default : console.log('현재 페이지가 괜찮아 보이길 바랍니다!'); break;
}

browser = 'Whale';
switch(browser){
    case('Edge') : console.log('Edge를 사용하고 계시네요!'); break;
    case('Chrome') : console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.'); break;
    case('Firefox') : console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.'); break;
    case('Safari') : console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.'); break;
    case('Opera') : console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.'); break;
    default : console.log('현재 페이지가 괜찮아 보이길 바랍니다!'); break;
}

/**
 * 1-3 반복문
 */
let i = 0;
while(true){
    console.log('number' + (i+1));
    i++;
    if(i>=10) break;
}