// 변수 grade의 값이 "손님"인 경우 "글 읽기", "일반 회원"인 경우 "글 읽기, 글 쓰기", 
//"운영자"인 경우 "글읽기, 글 쓰기, 글 삭제" 라는 값을 변수에 저장하여 아래와 같이 콘솔로 출력한다
var grade=['손님','일반회원','운영자'];
let authority;
for(let i in grade){
if(grade[i]=='손님')
    {
        authority='읽기'
        console.log(`${grade[i]}의 경우 "${authority}"가 가능합니다.`)    }
    else if(grade[i]=='일반회원'){
        authority='글 읽기','글 쓰기';
        console.log(`${grade[i]}의 경우 "${authority}"가 가능합니다.`) 
    }
    else if( grade[i]=='운영자')
        {
            authority= "글읽기, 글 쓰기, 글 삭제";
            console.log(`${grade[i]}의 경우 "${authority}"가 가능합니다.`) 
        }
    }

//삼항 연산자 code
console.log("-----------------삼항연산자 ");
var grade='손님';
authority=(grade=='손님')?'글 읽기':(grade=='일반회원')?'글 읽기,글 쓰기' : "글읽기, 글 쓰기, 글 삭제";
console.log(grade + "의 경우 " + authority + " 가 가능합니다.");

grade='일반회원'
authority=(grade=='손님')?'글 읽기':(grade=='일반회원')?'글 읽기,글 쓰기' : "글읽기, 글 쓰기, 글 삭제";
console.log(grade + "의 경우 " + authority + " 가 가능합니다.");

grade='운영자'
authority=(grade=='손님')?'글 읽기':(grade=='일반회원')?'글 읽기,글 쓰기' : "글읽기, 글 쓰기, 글 삭제";
console.log(grade + "의 경우 " + authority + " 가 가능합니다.");

//1-2switch
console.log(`-------------------switch문`);
var browser = 'Opera';
switch (browser) {
    case 'edge':
        console.log("Edge를 사용하고 계시네요!");
        break;
    case 'chrome':
        console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.');
        break;
    case 'Firefox':
        console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.');
        break;
    case 'Safari' :
        console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.');
        break;
    case 'Opera':
        console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.');
        break;
    default:
        console.log('현재 페이지가 괜찮아 보이길 바랍니다!');
}


//1-3 반복문
console.log(`------------------------반복문입니다`);
var i=0;
while (true) {
    console.log(`number`+"="+(i+1));
    i++;
    if(i>9)
        break;
}