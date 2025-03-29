/* 1-1. if문/삼항연산자 */

// if문 code
var grade = '손님'; //'일반회원', '운영자'로 변경해서 테스트
// 코드 작성
let authority;
const read = '글 읽기';
const write = '글 쓰기';
const remove = '글 삭제';

if (grade == '일반회원') {
    authority = read + ', ' + write;
} else if (grade == '운영자') {
    authority = read + ', ' + write + ', ' + remove;
} else { // 손님
    authority = read;
}
console.log(grade + "의 경우 " + authority + "가 가능합니다.");

// 삼항연산자 code
var grade = '손님'; //'일반회원', '운영자'로 변경해서 테스트
// 코드 작성
authority = grade == '손님' ? read : (grade = '일반회원' ? read + ', ' + write : read + ', ' + write + ', ' + remove)
console.log(grade + "의 경우 " + authority + "가 가능합니다.");


/* 1-2. switch문 */

// if문 code
var browser = 'Edge'; // 'Chrome', 'Firefox' 등으로 변경해서 테스트
if (browser == 'Edge') {
    console.log("Edge를 사용하고 계시네요!");
} else if (browser == 'Chrome'
        || browser == 'Firefox'
        || browser == 'Safari'
        || browser == 'Opera') {
    console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.');
} else {
    console.log('현재 페이지가 괜찮아 보이길 바랍니다!');
}

// switch문 code
var browser = 'Edge'; // 'Chrome', 'Firefox' 등으로 변경해서 테스트
// 코드 작성
switch (browser) {
    case 'Edge': console.log("Edge를 사용하고 계시네요!"); break;
    case 'Chrome':
    case 'Firefox':
    case 'Safari':
    case 'Opera': console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.'); break;
    default: console.log('현재 페이지가 괜찮아 보이길 바랍니다!'); break;
}


/* 1-3. 반복문 */

// for문 code
for (var i = 0; i < 10; i++) {
    console.log('number' + (i+1));
}

// while문 code
// 코드 작성
var i = 0;
while (i < 10) {
    console.log('number' + (i+1));
    i++;
}