// 1-1. if
const grade = '손님';     //'일반회원', '운영자'로 변경해서 테스트
let authority;

if (grade == '손님') {
    authority = '글 읽기';
} else if (grade == '일반회원') {
    authority = '글 읽기, 글 쓰기';
} else if (grade == '운영자') {
    authority = '글 읽기, 글 쓰기, 글 삭제';
} else {
    authority = '';
}

console.log(grade + "의 경우 " + authority + " 가 가능합니다.");

// 삼항연산자
// const grade = '손님';     //'일반회원', '운영자'로 변경해서 테스트
// const authority = (grade == '손님') ? '글 읽기' :
//         (grade == '일반회원') ? '글 읽기, 글 쓰기' :
//         (grade == '운영자') ? '글 읽기, 글 쓰기, 글 삭제' :
//         '';
// console.log(grade + "의 경우 " + authority + " 가 가능합니다.");


// 1-2. switch
const browser = 'Edge';   // 'Chrome', 'Firefox' 등으로 변경해서 테스트
switch (browser) {
    case 'Edge':
        console.log("Edge를 사용하고 계시네요!");
        break;
    case 'Chrome':
    case 'Firefox':
    case 'Safari':
    case 'Opera':
        console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.');
        break;

    default:
        console.log('현재 페이지가 괜찮아 보이길 바랍니다!');
}

// 1-3. for/while
for (let i = 0; i < 10; i++) {
    console.log('number' + (i + 1));
}

let i = 0;
while (i < 10) {
    console.log('number' + (i + 1));
    i++;
}