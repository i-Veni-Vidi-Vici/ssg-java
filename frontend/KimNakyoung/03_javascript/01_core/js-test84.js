// 1-1 문제

//변수 grade의 값이 "손님"인 경우 "글 읽기", 
//"일반 회원"인 경우 "글 읽기, 글 쓰기", 
//"운영자"인 경우 "글읽기, 글 쓰기, 글 삭제" 라는 값을 변수에 저장하여 아래와 같이 콘솔로 출력한다.


// var grade = "손님"; 
// var grade = "일반회원"; 
var grade = "운영자"; 
if (grade === "손님"){
    authority = "글 읽기";
} else if (grade === "일반 회원") {
    authority = "글 읽기, 글 쓰기";
} else {
    authority = "글 읽기, 글 쓰기, 글 삭제";
}

console.log(grade + "의 경우 " + authority + " 가 가능합니다.");

// 삼항연산자

var authority = (grade === '손님') ? "글읽기" 
                : (grade === '일반 회원') ? "글 읽기, 글 쓰기"
                :  "글 읽기, 글 쓰기, 글 삭제" ;

console.log(grade + "의 경우 " + authority + " 가 가능합니다.");

// 1-2 

// var browser = 'Edge';
// var browser = 'Chrome';
// var browser = 'Firefox';
// var browser = 'Safari';
// var browser = 'Opera';
var browser = 'Operaa';
switch (browser) {
    case 'Edge':
        console.log(`Edge를 사용하고 계시네요!`); 
    break;
    case 'Chrome':
    console.log(`저희 서비스가 지원하는 브라우저를 사용하고 계시네요.`); 
    break;
    case 'Firefox':
    console.log(`저희 서비스가 지원하는 브라우저를 사용하고 계시네요.`); 
    break;
    case 'Safari': 
    console.log(`저희 서비스가 지원하는 브라우저를 사용하고 계시네요.`); 
    break;
    case 'Opera': 
    console.log(`저희 서비스가 지원하는 브라우저를 사용하고 계시네요.`); 
    break;
    default:
        console.log(`현재 페이지가 괜찮아 보이길 바랍니다!`);
        break;
}

// 1-3 
var i = 0;
while(i <10) {
    console.log(`number` + (i+1));
    i++;
}

