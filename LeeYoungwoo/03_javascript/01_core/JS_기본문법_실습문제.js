const grade = '일반 회원';
let authority;

// if문 code
if(grade === '손님') {
    authority = "글 읽기";
}
else if(grade === '일반 회원') {
    authority = "글 읽기, 글 쓰기";
}
else if(grade ==='운영자') {
    authority = "글 읽기, 글 쓰기, 글 삭제"
}

console.log(grade + "의 경우 " + authority + " 가 가능합니다.");

// 삼항연산자 code
(grade === "손님") ? authority = "글 읽기"


console.log(grade + "의 경우 " + authority + " 가 가능합니다.");
