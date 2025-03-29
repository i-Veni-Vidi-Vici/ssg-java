/**
 * 정규표현식 Regular Expression
 *  - RegExp객체
 *  - 문자열에 대해서 유효성검사/검색/대체 등의 작업을 수행하는 표현식
 *  - 조건/반복처리 대비해서 굉장히 간결하게 코드작성이 가능
 *  - 학습비용이 요구되는 편
 *  - 언어독립적. 타 프로그래밍언어에서 사용가능 
 */

/**
 * 객체생성
 */
const re1 = /[0-9]/gi; // 리터럴로 생성
const re2 = new RegExp(/[0-9]/gi);
const re3 = new RegExp("[0-9]", "gi");

console.log(re1);
console.log(re2);
console.log(re3);

/**
 * RegExp 메소드
 *  - RegExp#exec
 *  - RegExp#test
 * 
 * String 메소드
 *  - String#lit
 *  - String#replace
 *  - String#match
 *  - String#search
 */

console.log(re1.exec("a1b2c3")); // [ '1', index: 1, input: 'a1b2c3', groups: undefined ]
console.log(re1.exec("abc")); // null
console.log(re1.test("a1b2c3")); // true (숫자가 있니?)
console.log(re1.test("abc")); // false

console.log("a1b2c3".split(re1)); // [ 'a', 'b', 'c', '' ]
console.log("a1b2c3".replace(re1, "*")); // a*b*c* 매칭된 결과를 대체
console.log("a1b2c3".match(re1)); // [ '1', '2', '3' ] 매칭된 결과를 배열로 반환
console.log("a3b4c5".search(re1)); // 1 매칭된 문자열의 인덱스 반환


/**
 * flag 옵션
 *  - g global : 전역비교 수행. 없으면 매칭된 첫 문자열만 처리
 *  - i ignore : 대소문자 구분 안함.
 *  - m multiline : 여러줄인 데이터에 한해 행단위 검색
 */
let target = 'Javascript jQuert Ajax sass';
console.log(target.replace(/a/, '<$&>')); // 매칭된 결과를 가리키는 와일드카드
console.log(target.replace(/a/g, '<$&>')); // J<a>v<a>script jQuert Aj<a>x s<a>ss
console.log(target.replace(/a/gi, '<$&>')); // J<a>v<a>script jQuert <A>j<a>x s<a>ss
console.log();

/**
 * anchor 문자
 *  - ^ : 문자열의 시작
 *  - $ : 문자열의 끝
 */
target = 'Javascript jQuert Ajax sass xxx';
console.log(target.replace(/j/gi, '<$&>')); // <J>avascript <j>Quert A<j>ax sass xxx
console.log(target.replace(/^j/gi, '<$&>')); // <J>avascript jQuert Ajax sass xxx
console.log(target.replace(/^j/g, '<$&>')); // Javascript jQuert Ajax sass xxx
console.log(target.replace(/x/g, '<$&>')); // Javascript jQuert Aja<x> sass <x><x><x>
console.log(target.replace(/x$/g, '<$&>')); // Javascript jQuert Ajax sass xx<x>

target = `Javascript
jQuert
Ajax
sass
xxx`;
console.log(target.replace(/^j/gim, '<$&>')); // m을 붙히면 각 줄에 대해서 찾기
console.log(target.replace(/x$/gim, '<$&>'));
console.log();


/**
 * . 문자
 *  - 아무글자 하나를 의미
 *  - 개행문자는 포함되지 않는다.
 */
let re = /^a.b/;
console.log(re.test('acb')); // true
console.log(re.test('acbbbbbb')); // true
console.log(re.test('a b')); // true (공백도 포함된다)
console.log(re.test('ab')); // false | a -> ok, . -> ok, b자리가 없어서 false

re = /in.$/;
console.log(re.test('going')); // true
console.log(re.test('inner')); // false
console.log(re.test('Holiday-in')); // false
console.log();


/**
 * []
 *  - 문자 하나에 대한 값 목록 or 범위 지정
 *  - 범위는 ascii코드 기반으로 지정해야한다.
 *  - []안에서 ^로 시작하면 반전을 의미한다.
 */
target = 'ABCDEFGhijklmn 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ 1234567890 !@#$%^&*() \t\n';
console.log(target.replace(/[ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz]/g, '<$&>')); // '<$&>' 모든걸 대상
console.log(target.replace(/[ABCDEFGHIJKLMNOPQRSTUVWXYZ]/gi, '<$&>'));
console.log(target.replace(/[A-Z]/gi, '<$&>'));
console.log(target.replace(/[A-Za-z]/g, '<$&>'));
console.log(target.replace(/[A-z]/g, '<$&>')); // 
console.log(target.replace(/[0123456789]/g, '<$&>')); // Z끝난후 a 사이에 특수문자가 있어서 그것들도 잡혀서 결과가 위와 다름
console.log(target.replace(/[0-9]/g, '<$&>')); // 
console.log(target.replace(/[가-힣]/g, '<$&>')); // 가 ~ 힣 까지만
console.log(target.replace(/[가-힣ㄱ-ㅎㅏ-ㅣ]/g, '<$&>')); // 가 ~ 힣 ~ ㄱ ~ ㅎ ~ ㅏ ~ ㅣ 전부다
// 반전
console.log(target.replace(/[^A-Za-z]/g, '<$&>')); // 영문자 빼고 전부다 <>
// E가 아닌 영문자 찾기
console.log(target.replace(/[A-Z^E]/g, '<$&>')); // 실패 ^은 맨앞에 사용할때만 반전의 의미를 가진다.
console.log(target.replace(/[A-DF-Z]/g, '<$&>')); // 성공
console.log();

/**
 * 단축문자
 * \w word : 영문자/숫자/_ 문자
 * \d digit : 숫자
 * \s whitespace : 공백/탭/개행문자
 * 
 * \W : \w 의 반전
 * \D : \d 의 반전
 * \S : \s 의 반전
 */
target = 'ABCDEFGhijklmn 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ 1234567890 !@#$%^&*()-_=+ \t\n';
console.log(target.replace(/\d/g, "<$&>")); // 숫자만
console.log(target.replace(/\w/g, "<$&>")); // 영문자,숫자,_ 
console.log(target.replace(/\s/g, "<$&>")); // 공백,탭,개행문자

console.log("반전");
console.log(target.replace(/\D/g, "<$&>")); // 숫자빼고
console.log(target.replace(/\W/g, "<$&>")); // 영문자,숫자,_ 빼고
console.log(target.replace(/\S/g, "<$&>")); // 공백,탭,개행문자 빼고

/**
 * () 그룹핑
 * | or연산자
 */
target = '월요일에는 월요병, 화가 부르르르 화요일 홧병, 수수술한잔 하는 수요일, 목이 컥~ 목요일, 금방 오지 않는 금요일, 하지만 오늘은 목요일';

console.log(target.replace(/(수요일|목요일|금요일)/g, "<$&>"));
console.log(target.replace(/[수목금]요일/g, "<$&>"));
console.log();

/**
 * Escaping \
 *  . ^ $ | [] 정규식에서 특수한 의미가 있는 문자를 문자 그대로 찾고싶은 경우 escaping이 필요하다.
 *  다만 [] 안에서는 escaping을 사용하지 않는다. (\는 escaping 필요)
 */
target = '3.4$';
console.log(target.replace(/\$/g, "<$&>")); // 3.4<$>
console.log(target.replace(/\./g, "<$&>")); // 3<.>4$

console.log(target.replace(/[$]/g, "<$&>")); // 3.4<$>
console.log(target.replace(/[.]/g, "<$&>")); // 3<.>4$
console.log();

/**
 * 수량자 quantifier
 * a* : a가 0개이상
 * a+ : a가 1개이상
 * a? : a가 0개 또는 1개
 */
target = "aabc abc bc";
console.log(target.replace(/a*b/g, '<$&>')); // 
console.log(target.replace(/a+b/g, '<$&>'));
console.log(target.replace(/a?b/g, '<$&>'));

target = 'ABCDEFGhijklmn 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ 1234567890 !@#$%^&*()-_=+ \t\n';
console.log(target.replace(/[A-Z]+[a-z]/g, '<$&>'));

/**
 * 수량자
 * a{5} : a가 5개
 * a{2,5} : a가 2개 이상 5개 이하
 * a{2,} : a가 2개 이상
 * //  a{,5} : 존재하지 않는 문법
 */
target = "aa aba abba abbba";
console.log(target.replace(/ab{0,}a/g, "<$&>")); // <aa> <aba> <abba> <abbba>
console.log(target.replace(/ab{1,}a/g, "<$&>")); // aa <aba> <abba> <abbba>
console.log(target.replace(/ab{0,1}a/g, "<$&>")); // <aa> <aba> abba abbba

// 사용자 비밀번호 4자리 숫자여부 검사
re = /^\d{4}$/;
// re = /^[\d]{4}$/;
// re = /^[0-9]{4}$/;
console.log(re.test("1234")); // true
console.log(re.test("123456")); // false
console.log(re.test("123x")); // false
console.log(re.test("abcd")); // false
console.log(re.test("123")); // false


/**
 * Look Around 탐색
 *  - 조회/검사에는 사용하지만. 매칭결과에는 반영되지 않는다.
 * 
 *  - Look Ahead 전방탐색
 *      a(?=b)  b가 뒤따르는 a를 검사
 *      a(?!b)  b가 뒤따르지 않는 a를 검사
 * 
 *  - Look Behind 후방탐색
 *      (?<=b)a  b가 앞서있는 a를 검사
 *      (?<!b)a  b가 앞서있지 않은 a를 검사
 */
target = "hello world hello tom hello jane hello world";
console.log(target.replace(/hello(?= world)/g, "<$&>")); // <hello> world hello tom hello jane <hello> world
console.log(target.replace(/hello(?! world)/g, "<$&>")); // hello world <hello> tom <hello> jane hello world


target = "hello world lotte world t world usim world";
console.log(target.replace(/(?<=hello )world/g, "<$&>")); // hello <world> lotte world t world usim world
console.log(target.replace(/(?<!hello )world/g, "<$&>")); // hello world lotte <world> t <world> usim <world>
console.log();


/**
 * 복잡한 유효성검사 처리하기
 *  - 8~12 자리
 *  - 숫자포함
 *  - 영문자포함
 *  - 특수문자포함
 */
const reArr = [
    /^.{8,12}$/,
    /\d/,
    /[A-Za-z]/,
    /[!@#$%]/
];

// target = "pw";
target = "Pa$$word123";
const result = reArr.every((re) => re.test(target));
console.log(result ? '유효한 비밀번호입니다.' : '비밀번호가 유효하지 않습니다.');
