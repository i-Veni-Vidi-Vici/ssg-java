/**
 * 정규표현식
 * - RegExp
 * - 문자열에 대해서 유효성검사/검색/대체등의 작업을 수행하는 표현식
 * - 조건/반복처리 대비에서 굉장히 간결하게 코드작성이 가능
 * - 러닝커브가 높다
 * - 언어독립적, 타 프로그래밍 언어에서 사용가능
 */

/**
 * 객체생성
 */

const re1 = /[0-9]/gi; //리터럴로 생성
const re2 = new RegExp(/[0-9]/gi);
const re3 = new RegExp("[0-9]",'gi');

console.log(re1);
console.log(re2);
console.log(re3);

/**
 * RegExp 메소드
 * - RegExp#exec
 * - RegExp#test
 * 
 * String 메소드
 * - String#split
 * - String#replace
 * - String#match
 * - String#search
 */

console.log(re1.exec("a1b2c3")); // ['1', index : 1, input: 'a1b2c3', groups:undefined]
console.log(re1.exec("abc"));   //null
console.log(re1.test("a1b2c3"));    //true
console.log(re1.test("abc"));   //false

console.log("a1b2c3".split(re1));   // ['a', 'b', 'c', '']
console.log("a1b2c3".replace(re1, "*"));    // a*b*c*
console.log("a1b2c3".match(re1));    // ['1', '2', '3',]
console.log("a1b2c3".search(re1));    // 1 매칭된 문자열의 인덱스 반환

/**
 * flag 옵션
 * -g global 전역비교 수행 (설정하지 않으면 첫문자에만 검사 실행)
 * -i ignore 대소문자 구분안함
 * -m multiline 여러줄인 데이터에 한해 행당위 검색
 */
let target = 'Javascript JQuery Ajax sass';

//$& 매칭된 결과를 가리키는 와일드 카드
console.log(target.replace(/a/, '<$&>') );  //매칭된 결과를 가르키는 와일드 카드
console.log(target.replace(/a/g, '<$&>') );
console.log(target.replace(/a/gi, '<$&>') );
console.log();
/**
 * anchor문자
 * - ^ 문자열의 시작
 * - $ 문자열의 끝
 */
target = 'Javascript JQuery Ajax sass xxx';
console.log(target.replace(/j/gi, '<$&>')); //<J>avascript <J>Query A<j>ax sass xxx
console.log(target.replace(/^j/gi, '<$&>')); //<J>avascript JQuery Ajax sass xxx
console.log(target.replace(/^j/g, '<$&>')); // Javascript JQuery Ajax sass xxx
console.log(target.replace(/x/g, '<$&>')); // Javascript JQuery Aja<x> sass <x><x><x>
console.log(target.replace(/x$/g, '<$&>')); // Javascript JQuery Ajax sass xx<x>

target = `Javascript
jQuery
Ajax
sass
xxx
`

console.log(target.replace(/^j/gim, '<$&>'));   //sass
/*
<J>avascript
<j>Query
Ajax
sass
xxx
*/
console.log(target.replace(/x$/gim, '<$&>'));
/*
Javascript
jQuery
Aja<x>
sass
xx<x>
*/

/**
 *  . 문자
 * - 아무글자 하나를 의미
 * - 와일드카드 'ㅅ'?
 * - 개행문자는 포함되지 않는다.
 */

let re = /^a.b/;
console.log(re.test('acb'));    //true
console.log(re.test('abbbbbbbbbbb'));   //true
console.log(re.test('a b'));    //true
console.log(re.test('ab'));    //false 3글자가 아니어서 false 
//a로 시작하고 b로 끝나는 3글자 이상의 어떠한 문자열을 가지고 있는 문자열이어야 함

re = /in.$/;
console.log(re.test('goging'));//true
console.log(re.test('inner'));//false
console.log(re.test('Holiday-in'));//false

/**
 * []
 * - 문자 하나에 대한 값 목록 혹은 범위지정
 * - 범위는 ascii코드 기반으로 지정
 * - []안에서 ^로 시작하면 반전을 의미
 */
target = 'ABCDEFGhijklmn 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ 1234567890 !@#$%^&*() \t\n';
console.log(target.replace(/[ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz]/g, '<$&>'));
console.log(target.replace(/[ABCDEFGHIJKLMNOPQRSTUVWXYZ]/gi, '<$&>'));
console.log(target.replace(/[A-Z]/gi, '<$&>'));
console.log(target.replace(/[A-Z]/gi, '<$&>'));
console.log(target.replace(/[A-Za-z]/g, '<$&>'));
console.log(target.replace(/[A-z]/g, '<$&>'));  //특수문자도 들어감 안된다

console.log(target.replace(/[0-9]/g, '<$&>'));  //숫자 찾기
console.log(target.replace(/[0123456789]/g, '<$&>'));
console.log(target.replace(/[가-힇ㄱ-ㅎㅏ-ㅣ]/g, '<$&>'));  //한글 찾기
console.log();

//반전
console.log(target.replace(/[^A-Za-z]/g, '<$&>'));  //알파벳이 아닌 문자 찾기
console.log(target.replace(/[A-Z^E]/gi, '<$&>'));   //E가 아닌 영문자 찾기 실패 ^은 맨앞에 사용할때만 반전의 의미를 갖는다
console.log(target.replace(/[A-DF-Z]/g, '<$&>'));  // E가 아닌 영문자 찾기 성공
console.log();

/**
 * 단축문자
 * \w word 영문자/숫자/_문자
 * \d degit 숫자
 * \s space 공백
 */

/**
 * \W   \w 반전
 * \D   \d 반전
 * \S   \s 반전
 */

console.log(target.replace(/\d/g, '<$&>')); //ABCDEFGhijklmn 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ <1><2><3><4><5><6><7><8><9><0> !@#$%^&*() 	
console.log(target.replace(/\w/g, '<$&>')); //<A><B><C><D><E><F><G><h><i><j><k><l><m><n> 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ <1><2><3><4><5><6><7><8><9><0> !@#$%^&*() 	
console.log(target.replace(/\s/g, '<$&>')); //ABCDEFGhijklmn< >가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ< >1234567890< >!@#$%^&*()< ><	><>
console.log();
console.log(target.replace(/\D/g, '<$&>')); //ABCDEFGhijklmn 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ <1><2><3><4><5><6><7><8><9><0> !@#$%^&*() 	
console.log(target.replace(/\W/g, '<$&>')); //<A><B><C><D><E><F><G><h><i><j><k><l><m><n> 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ <1><2><3><4><5><6><7><8><9><0> !@#$%^&*() 	
console.log(target.replace(/\S/g, '<$&>')); //ABCDEFGhijklmn< >가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ< >1234567890< >!@#$%^&*()< ><	><>

/**
 * () 그룹핑
 * | or 연산자
 */
target = '월요일에는 월요병, 화가 부르르르 화요일 홧병, 수수술한잔 하는 수요일, 목이 컥~ 목요일, 금방 오지 않는 금요일, 하지만 오늘은 금요일';

console.log(target.replace(/(수요일|목요일|금요일)/g, "<$&>")); //월요일에는 월요병, 화가 부르르르 화요일 홧병, 수수술한잔 하는 <수요일>, 목이 컥~ <목요일>, 금방 오지 않는 <금요일>, 하지만 오늘은 <금요일>
console.log(target.replace(/(수목금)요일/g, "<$&>"));   //월요일에는 월요병, 화가 부르르르 화요일 홧병, 수수술한잔 하는 수요일, 목이 컥~ 목요일, 금방 오지 않는 금요일, 하지만 오늘은 금요일

/**
 * Escaping
 * - . ^ $ | [] 정규식에서 특수한 의미가 있는 문자를 문자 그대로 찾고 싶은 경우 escaping이 필요하다
 * - 다만 []안에서는 escaping을 사용하지 않는다
 */

target = '3.4$';
console.log(target.replace(/\$/g, '<$&>'));
console.log(target.replace(/\./g, '<$&>'));

console.log(target.replace(/[$]/g, '<$&>'));
console.log(target.replace(/[.]/g, '<$&>'));

 /**
  * 수량자 quantifier
  * a*      a가 0개 이상
  * a+      a가 1개 이상
  * a?      a가 0개 or 1개
  */
 target = "aabc abc bc";
console.log(target.replace(/a*b/g, '<$&>'));    //b를 찾아라, 대신 a가 앞에 존재하면 연속된 a도 포함하라
console.log(target.replace(/a?b/g, '<$&>'));    //b를 찾아라, 대신 a가 앞에 존재하면 a를 1개만 포함하라
console.log(target.replace(/a+b/g, '<$&>'));    //앞에 a를 1개 이상 포함한 b를 1개 찾아라


target = 'ABCDEFGhijklmn 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ 1234567890 !@#$%^&*() \t\n';
console.log(target.replace(/[A-Z]+[a-z]/g, '<$&>'));  //앞에 대문자를 포함한 소문자 1개를 찾아라

/**
 * 수량자
 * a{5} a가 5개
 * a{2,5} a가 2개이상 5개 이하
 * a{2,} a가 2개이상
 */
target = 'aa aba abba abbba'
console.log(target.replace(/ab{0,}a/g, "<$&>"));    //<aa> <aba> <abba> <abbba>
console.log(target.replace(/ab{1,}a/g, "<$&>"));    //aa <aba> <abba> <abbba>
console.log(target.replace(/ab{0,1}a/g, "<$&>"));   //<aa} <aba} abba abbba

//사용자비밀번호 4자리 숫자여부 검사
// re = /[0-9]{4,5}/;   //안됨. 4~5자리에 해당하는 문자열을 찾는거라 6을 제외한 숫자 12345를 합격 시킴
re = /^[0-9]{4}$/;
// re = /^\d{4}$/;
// re = /^[\d]{4}$/;
console.log('-----비밀번호 4자리 검사-----');
console.log(re.test("1234"));   //true
console.log(re.test("123456")); //false
console.log(re.test("123x"));   //false
console.log(re.test("abcd"));   //false
console.log(re.test("123"));    //false

/**
 * Look Around 탐색
 * - 조회/검사에는 사용하지만, 매칭결과에는 반영되지 않는다.
 * 
 * - Look Ahead 전방탐색
 *      a(?=b) b가 뒤따르는 a를 검사
 *      a(?!b) b가 뒤따르지 않는 a를 검사
 * - Look behind 후방탐색
 *      (?<=b)a b가 앞서있는 a를 검사
 *      (?<!b)a b가 앞서있지 않은 a를 검사
 */

target = "hello world hello tom hello jane hello world";
console.log(target.replace(/hello(?= world)/g, "<$&>"));    //world가 뒤따르는 hello를 검색

target = "hello world lotte world t world usim world";
console.log(target.replace(/(?<=hello )world/g, "<$&>"));   //hello가 앞서 있는 world를 검색
//사용할때 ?<=를 서치하는 문자와 붙여 써야한다. 
// 공백허용하지 않음

target = "hello world hello tom hello jane hello world";
console.log(target.replace(/hello(?! world)/g, "<$&>"));    // world가 뒤따르지 않는 hello를 찾는다

target = "hello world lotte world t world usim world";  
console.log(target.replace(/(?<!hello )world/g, "<$&>"));   //hello 가 앞에 있지 않은 world를 검색


/**
 * 복잡한 유효성검사 처리하기
 * - 8~12 자리
 * - 숫자포함
 * - 영문자포함
 * - 특수문자포함
 */

const reArr = [
    /^.{8,12}$/,
    /\d/,
    /[A-Za-z]/,
    /[!@#$%^&*]/
];

target = "pwjjjjjj1#"
const result = reArr.every((re) =>{return re.test(target)})
console.log(result ? '유효한 비밀번호' : '잘못된 비밀번호');