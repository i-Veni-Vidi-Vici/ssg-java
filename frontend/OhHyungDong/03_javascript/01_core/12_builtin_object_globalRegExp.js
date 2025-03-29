/**
 * 정규표현식 : Regular Expression
 * - RegExp 객체 
 * - 문자열에 대해서 유효성 검사 / 검색 / 대체 등의 작업을 수행하는 표현식 
 * - 조건 / 반복처리 대비에서 굉장히 간결하게 코드작성이 가능하다.
 * - 학습비용이 요구되는 편 
 * - 언어독립적. 타 프로그래밍 언어에서 사용가능 
 *
 */

/**
 * 객체 생성 
 */

const re1 = /[0-9]/gi; // 리터럴로 생성
const re2 = new RegExp(/[0-9]/);
const re3 = new RegExp("[0-9]","gi");

console.log(re1);
console.log(re2);
console.log(re3);

/**
 * RegExp 메소드
 * - RegExp#exc
 * - RegExp#test
 * 
 * String 메소드
 * - String#split 
 * - String#replace 
 * - String#match 
 * - String#search 
 */
console.log(re1.exec("a1b2c3")); //[ '1', index: 1, input: 'a1b2c3', groups: undefined ] 검색 결과를 배열로 반환 
console.log(re1.exec("a1b2c3")); //true - 안에 숫자가 있는지 없는지 검사해서 숫자가 있으면 true 반환 없으면 null 반환 
console.log(re1.exec("abc")); //안에 숫자가 없어서 Null 출력 

console.log("a1b2c3".split(re1)); // [ 'a', 'b', 'c', '' ]
console.log("a1b2c3".replace(re1,"*")); //숫자를 *로 대체
console.log("a1b2c3".match(re1)); //['1','2','3'] 매칭된 결과를 배열로 반환 
console.log("a1b2c3".search(re1)); //1 매칭된 문자열의 인덱스 반환


/**
 * flag : 정규식 뒤에 붙임
 * - g global 전역비교 수행. 이게 없으면 매칭된 첫문자열만 처리 
 * - i ignore 대소문자 구분안함.
 * - m multiline 여러줄 데이터에 한해 행단위 검색 
 */

let target = 'Javascript jQuery Ajax sass';

console.log(target.replace(/a/,'<$&>')); //매칭된 결과를 가리키는 와일드 카드 J<a>vascript jQuery Ajax sass
console.log(target.replace(/a/g,'<$&>')); //J<a>v<a>script jQuery Aj<a>x s<a>ss
console.log(target.replace(/a/gi,'<$&>')); //J<a>v<a>script jQuery <A>j<a>x s<a>ss

/**
 * anchor 문자 
 * 
 * - ^ : 문자열의 시작 
 * - $ : 문자열의 끝 
 */
target = "JavaScript jQuery Ajax sass xxx";
console.log(target.replace(/j/gi,'<$&>'));//<J>avaScript <j>Query A<j>ax sass 
console.log(target.replace(/^j/gi,'<$&>'));//<J>avaScript jQuery Ajax sass xxx


target =`Javascript
jQuery
Ajax
sass
xxx
`
console.log(target.replace(/^j/gim,'<$&>'));
/**
 *  
<J>avascript
<j>Query
Ajax
sass
xxx
 */
console.log(target.replace(/x$/gim,'<$&>'));
/**
Aja<x>
sass
xx<x>
 */

console.log();

/**
 * ' . '문자 
 * - 아무 글자 하나를 의미 
 * - 개행문자는 포함 안됨 
 */

let re = /^a.b/;
console.log(re.test('acb')); // true , a로 시작하고 a b사이에 아무 글자가 하나 존재하면 무조건 true
console.log(re.test('acbbbbb')); // true , a로 시작하고 a b사이에 아무 글자가 하나 존재하면 무조건 true
console.log(re.test('a b')); // true , a로 시작하고 a b사이에 아무 글자가 하나 존재하면 무조건 true
console.log(re.test('ab')); // true , a로 시작하고 a b사이에 아무 글자가 하나 존재하면 무조건 true
console.log(re.test('a\nb')); // true , a로 시작하고 a b사이에 아무 글자가 하나 존재하면 무조건 true

re = /in.$/;//in + 한글자 끝나는것 
//test => true / false 출력 
console.log(re.test('going')); //true
console.log(re.test('inner')); //false
console.log(re.test('Holiday-in')); //false
console.log();

/**
 * []
 * - 문자 하나에 대한 값 목록 혹은 범위 지정 
 * - 범위는 아스키 코드 기반으로 지정 
 * - [] 안에서 ^로 시작하면 반전을 의미함.
 */
target = 'ABCDEFGhijklmn 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ 1234567890 !@#$%^&*()-_=+ \t\n'
console.log(target.replace(/[ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz]/g,'<$&>'));//A><B><C><D><E><F><G><h><i><j><k><l><m><n> 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ 1234567890 !@#$%^&*()
console.log(target.replace(/[ABCDEFGHIJKLMNOPQRSTUVWXYZ]/gi,'<$&>'));//<A><B><C><D><E><F><G><h><i><j><k><l><m><n> 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ 1234567890 !@#$%^&*()
console.log(target.replace(/[A-Z]/gi,'<$&>'));//<A><B><C><D><E><F><G><h><i><j><k><l><m><n> 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ 1234567890 !@#$%^&*()
console.log(target.replace(/[A-Za-z]/gi,'<$&>'));//<A><B><C><D><E><F><G><h><i><j><k><l><m><n> 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ 1234567890 !@#$%^&*()
console.log(target.replace(/[A-z]/gi,'<$&>'));// 영문자 검색이 아님 <A><B><C><D><E><F><G><h><i><j><k><l><m><n> 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ 1234567890 !@#$%<^>&*()
console.log(target.replace(/[0-9]/g,'<$&>'));//ABCDEFGhijklmn 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ <1><2><3><4><5><6><7><8><9><0> !@#$%^&*()
console.log(target.replace(/[가-힣]/g,'<$&>'));//ABCDEFGhijklmn <가><나><다><라><마><바><사>ㅋㅋㅎㅎㅓㅓㅏㅏ 1234567890 !@#$%^&*() 

//반전 
console.log(target.replace(/[^A-Za-z]/gi,'<$&>')); //영문자 빼고 모두 포함 및 추력
console.log(target.replace(/[A-Z^E]/gi,'<$&>')); //E가 아닌 영문자 찾기 실패 ^은 맨 앞에 사용할때만 반전의 의미를 갖는다.
console.log(target.replace(/[A-DF-Z]/gi,'<$&>')); //E가 아닌 영문자 찾기 성공 

/**
 * 단축문자 
 * \w word : 영문자 / 숫자 / _문자 
 * \d digit : 숫자 
 * \s whitespace : 공백 / 탭 / 개행문자 
 * 
 * \W \w 반전 
 * \D \d 반전 
 * \S \s 반전 
 */

target = 'ABCDEFGhijklmn 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ 1234567890 !@#$%^&*() \t\n'
console.log(target.replace(/\d/g,"<$&>")); //ABCDEFGhijklmn 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ <1><2><3><4><5><6><7><8><9><0> !@#$%^&*() 	
console.log(target.replace(/\w/g,"<$&>")); //<A><B><C><D><E><F><G><h><i><j><k><l><m><n> 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ <1><2><3><4><5><6><7><8><9><0> !@#$%^&*()
console.log(target.replace(/\s/g,"<$&>")); //ABCDEFGhijklmn< >가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ< >1234567890< >!@#$%^&*()< ><	><      >

console.log(target.replace(/\D/g,"<$&>")); //숫자 아닌거 
console.log(target.replace(/\W/g,"<$&>")); // 영문자, 숫자 _문자 아닌거 
console.log(target.replace(/\S/g,"<$&>")); // 공백 , 탭이 아닌거 

/**
 * () 그룹핑
 * | or 연산자
 */
target = "월요일에는 월요병, 화가 부르르르 화요일 홧병, 수수술한잔 하는 수요일, 목이 컥~ 목요일, 금방 오지 않는 금요일, 하지만 오늘은 금요일";
console.log(target.replace(/(수요일|목요일|금요일)/,"<$&>"));
console.log(target.replace(/[수목금]요일/g,"<$&>"));

/**
 * Escaping : \
 * - . ^ $ | [] 정규식에서 특수한 의미가 문자를 문자 그대로 찾고 싶은 경우 escaping이 필요하다.
 * - 다만 []안에서는 escaping을 사용하지 않는다.()는 escaping 필요 
 */

target = '3.4$'
console.log(target.replace(/\$/g,'<$&>'));//3.4<$>
console.log(target.replace(/\./g,'<$&>'));//3<.>4$
console.log(target.replace(/[.]/g,'<$&>'));//3<.>4$
console.log(target.replace(/[$]/g,'<$&>'));//3.4<$>


/**
 * 수량자 quantifier
 * - a* : a가 0개 이상 
 * - a+ : a가 1개 이상
 * - a? : a가 0개 또는 1개 
 * 
 */

target = "aabc abc bc";
console.log(target.replace(/a*b/,'<$&>'));// b앞에 a가 0개이상 있는거 찾음
console.log(target.replace(/a+b/,'<$&>'));
console.log(target.replace(/a?b/,'<$&>'));
/**
<aab>c abc bc
<aab>c abc bc
a<ab>c abc bc
 */

target = 'ABCDEFGhijklmn 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ 1234567890 !@#$%^&*() \t\n'
console.log(target.replace(/[A-Z]+[a-z]/g,'<$&>'));//<ABCDEFGh>ijklmn 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ 1234567890 !@#$%^&*()

/**
 * 수량자 
 * a{5} a가 5개
 * a{2,5} a가 2개이상 5개이하
 * a{5} a가 5개 이상 
 * 
 * // a{,5} :존재하지 않는 문법
 */
target = "aa aba abba abbba";
console.log(target.replace(/ab{0,}a/g,"<$&>"));//<aa> <aba> <abba> <abbba>
console.log(target.replace(/ab{1,}a/g,"<$&>"));//aa <aba> <abba> <abbba>
console.log(target.replace(/ab{0,1}a/g,"<$&>"));//<aa> <aba> abb abbba

//사용자 비밀번호 4자리 숫자여부 검사 
re = /^[0-9]{4}$/;
re = /^\d{4}$/;
console.log(re.test("1234"));
console.log(re.test("123456"));
console.log(re.test("abcd"));
console.log(re.test("123"));

/**
 * Look Around : 탐색
 * - 조회 / 검사에는 사용하지만 매칭결과에는 반영되지 않는다.
 * 
 * - Look Ahead : 전방 탐색 
 *  a(?=b) b가 뒤따르는 a 검사 
 *  a(?!b) b가 뒤따르지 않는 a 검사 
 * - Look behind : 후방 탐색 
 *  (?<=b)a b가 앞서 있는 a를 검사 
 *  (?<!b)a b가 앞서 있지 않은 a를 검사 
 */

target = "hello world hell tom hello jane hello world";
console.log(target.replace(/hello(?= world)/g, "<$&>")); //<hello> world hell tom hello jane <hello> world
console.log(target.replace(/hello(?! world)/g, "<$&>")); //<hello> world hell tom hello jane <hello> world

target = "hello world lottee world t wrold usim world";
console.log(target.replace(/(?<=hello )world /g,"<$&>"));//hello <world >lottee world t wrold usim world
console.log(target.replace(/(?<!hello )world /g,"<$&>"));//hello <world >lottee world t wrold usim world

/**
 * 복잡한 유효성 검사 처리하기
 * - 8 -12
 * - 숫자 포함 
 * - 영문자 포함
 * - 특수문자 포함 
 */

const arr = [
    /^.{8,12}$/,
    /\d/,
    /[A-Za-z]/,
    /[!@#$%]/,
];

target = "Pa$$word123";
const result = reArr.every((re) => re.test(target));
console.log(result ? '유효한 비밀번호입니다.' : '비밀번호가 유효핮 ㅣ않습니다.');

   

