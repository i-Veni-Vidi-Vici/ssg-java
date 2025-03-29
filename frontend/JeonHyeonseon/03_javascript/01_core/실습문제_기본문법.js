/**
 * 1-1. if/삼항문자연산자
 */

// if문 code
var grade = '손님';
if(grade == '손님') {
    autority = "글 읽기";
} else if(grade == '일반 회원') {
    autority = "글 읽기, 글 쓰기";
} else if(grade == '운영자') {
    autority = "글 읽기, 글 쓰기, 글 삭제";
}
console.log(grade, "의 경우 ", autority, "가 가능합니다.");

var grade = '일반 회원';
if(grade == '손님') {
    autority = "글 읽기";
} else if(grade == '일반 회원') {
    autority = "글 읽기, 글 쓰기";
} else if(grade == '운영자') {
    autority = "글 읽기, 글 쓰기, 글 삭제";
}
console.log(grade, "의 경우 ", autority, "가 가능합니다.");

var grade = '운영자';
if(grade == '손님') {
    autority = "글 읽기";
} else if(grade == '일반 회원') {
    autority = "글 읽기, 글 쓰기";
} else if(grade == '운영자') {
    autority = "글 읽기, 글 쓰기, 글 삭제";
}
console.log(grade, "의 경우 ", autority, "가 가능합니다.");

// 삼항연산자 
var grade = '손님';
autority = (grade == '손님') ? "글 읽기" : (grade == '일반회원') ? "글 읽기, 글 쓰기" : "글 읽기, 글 쓰기, 글 삭제";
console.log(grade, "의 경우 ", autority, "가 가능합니다.");

var grade = '일반 회원';
autority = (grade == '손님') ? "글 읽기" : (grade == '일반회원') ? "글 읽기, 글 쓰기" : "글 읽기, 글 쓰기, 글 삭제";
console.log(grade, "의 경우 ", autority, "가 가능합니다.");

var grade = '운영자';
autority = (grade == '손님') ? "글 읽기" : (grade == '일반회원') ? "글 읽기, 글 쓰기" : "글 읽기, 글 쓰기, 글 삭제";
console.log(grade, "의 경우 ", autority, "가 가능합니다.");

/**
 * 1-2. switch문
 */
var browser = 'Edge';
switch(browser) {
    case ('Edge'): console.log(`Edge를 사용하고 계시네요!`); break;
    case ('Chrome'): console.log(`저희 서비스가 지원하는 브라우저를 사용하고 계시네요.`); break;
    case ('Firefox'): console.log(`저희 서비스가 지원하는 브라우저를 사용하고 계시네요.`); break;
    case ('Safari'): console.log(`저희 서비스가 지원하는 브라우저를 사용하고 계시네요.`); break;
    case ('Opera'): console.log(`저희 서비스가 지원하는 브라우저를 사용하고 계시네요.`); break;
    default: console.log(`현재 페이지가 괜찮아 보이길 바랍니다!`); break;
}


/**
 * 1-3. 반복문
 */

// while문 code
let i = 0;
while (i < 10) {
    console.log(`number` + (i + 1));
    i++;
}