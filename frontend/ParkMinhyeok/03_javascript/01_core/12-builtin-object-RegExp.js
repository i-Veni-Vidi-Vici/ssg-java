/**
 * 정규표현식 regular Expression
 * - RegExp객체
 * - 문자열에 대해서 유효성검사/검색/대체등의 작업을 수행하는 표현식
 * - 조건/반복처리 대비에서 굉장히 간결하게 코드작성이 가능.
 * - 학습비용이 요구되는 편.
 * - 언어독립적. 타 프로그래밍언어에서 사용가능
 */

/**
 * 객체생성
 */
const re1 = /[0-9]/gi; //리터럴로 생성
const re2 = new RegExp(/[0-9]/gi);
const re3 = new RegExp('[0-9]', 'gi');

console.log(re1);
console.log(re2);
console.log(re3);

/**
 * RegExp 메소드
 *  - RegExp#exec
 *  - RegExp#test
 *
 * String 메소드
 *  - String#split
 *  - String#replace
 *  - String#match
 *  - String#search
 */

console.log(re1.exec('a1b2c3')); // [ '1', index: 1, input: 'a1b2c3', groups: undefined ]
console.log(re1.exec('abc')); // null
console.log(re1.test('a1b2c3')); // true
console.log(re1.test('abc')); // false

console.log('a1b2c3'.split(re1)); // [ 'a', 'b', 'c', '' ]
console.log('a1b2c3'.replace(re1, '*')); // a*b*c*
console.log('a1b2c3'.match(re1)); // [ '1', '2', '3' ] 매칭된 결과를 반환
console.log('a3b4c5'.search(re1)); // 1 매칭된 문자열의 인덱스 반환

/**
 * flag 옵션
 * - g global 전역비교 수행. 이게 없으면 매칭된 첫문자열만 처리
 * - i ignore 대소문자 구분안함.
 * - m multiline 여러줄인 데이터에 한해 행단위 검색
 */
let target = 'Javascript jQuery Ajax sass';

// 매칭된 결과를 가리키는 와일드카드
console.log(target.replace(/a/, '<$&>')); // J<a>vascript jQuery Ajax sass
console.log(target.replace(/a/g, '<$&>')); // J<a>v<a>script jQuery Aj<a>x s<a>ss
console.log(target.replace(/a/gi, '<$&>')); // J<a>v<a>script jQuery <A>j<a>x s<a>ss
console.log();

/**
 * anchor 문자
 * - ^ 문자열의 시작
 * - $ 문자열의 끝
 */
target = 'Javascript jQuery Ajax sass xxx';
console.log(target.replace(/j/gi, '<$&>')); // <J>avascript <j>Query A<j>ax sass xxx
console.log(target.replace(/^j/gi, '<$&>')); // <J>avascript jQuery Ajax sass xxx
console.log(target.replace(/^j/g, '<$&>')); // Javascript <j>Query A<j>ax sass xxx

console.log(target.replace(/x/g, '<$&>')); // Javascript jQuery Aja<x> sass <x><x><x>
console.log(target.replace(/x$/g, '<$&>')); // Javascript jQuery Ajax sass xx<x>

target = `Javascript
jQuery
Ajax
sass
xxx`;

console.log(target.replace(/^j/gim, '<$&>'));
console.log(target.replace(/x$/gim, '<$&>'));
console.log();

/**
 * . 문자
 * - 아무글자 하나를 의미
 * - 개행문자는 포함되지 않는다.
 */
let re = /^a.b/;
console.log(re.test('acb'));
console.log(re.test('acbbbbbbbbbb'));
console.log(re.test('a b'));
console.log(re.test('ab')); // false

re = /in.$/;
console.log(re.test('going'));
console.log(re.test('inner')); // fase
console.log(re.test('Holiday-in')); // false
console.log();

/**
 * []
 * - 문자 하나에 대한 값 목록 혹은 범위 지정
 * - 범위는 ascii 코드 기반으로 지정
 * - [] 안에서 ^로 시작하면 반전을 의미
 */
target =
  'ABCDEFGhijklmn 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ 1234567890 !@#$%^&*() \t\n';
console.log(
  target.replace(
    /[ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz]/g,
    '<$&>'
  )
);
console.log(target.replace(/[A-Z]/gi, '<$&>'));
console.log(target.replace(/[0-9]/gi, '<$&>'));
console.log(target.replace(/[가-힣ㄱ-ㅎㅏ-ㅣ]/g, '<$&>'));
// 반전
console.log(target.replace(/[^A-Za-z]/gi, '<$&>'));
console.log(target.replace(/[A-Z^E]/gi, '<$&>')); // E가 아닌 영문자 찾기 실패(^은 맨 앞에 사용할때만 반전의 의미를 갖음)
console.log(target.replace(/[A-DF-Z]/gi, '<$&>')); // E가 아닌 영문자 찾기 성공

/**
 * 단축문자
 * \w word 영문자/숫자/_
 * \d digit 숫자
 * \s whitespace 공백/탭/개행문자
 *
 * \W \w 반전
 * \D \d 반전
 * \S \s 반전
 */

target =
  'ABCDEFGhijklmn 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ 1234567890 !@#$%^&*()-_=+ \t\n';
console.log(target.replace(/\d/g, '<$&>')); // ABCDEFGhijklmn 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ <1><2><3><4><5><6><7><8><9><0> !@#$%^&*()-_=+
console.log(target.replace(/\w/g, '<$&>')); // <A><B><C><D><E><F><G><h><i><j><k><l><m><n> 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ <1><2><3><4><5><6><7><8><9><0> !@#$%^&*()-<_>=+
console.log(target.replace(/\s/g, '<$&>')); // ABCDEFGhijklmn< >가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ< >1234567890< >!@#$%^&*()-_=+< ><	><>

console.log(target.replace(/\D/g, '<$&>'));
console.log(target.replace(/\W/g, '<$&>'));
console.log(target.replace(/\S/g, '<$&>'));
console.log();

/**
 * () 그룹핑
 * | or 연산자
 */
target =
  '월요일에는 월요병, 화가 부르르르 화요일 홧병, 수수술한잔 하는 수요일, 목이 컥~ 목요일, 금방 오지 않는 금요일, 하지만 오늘은 금요일';

console.log(target.replace(/(수요일|목요일|금요일)/g, '<$&>'));
console.log(target.replace(/[수목금]요일/g, '<$&>'));

/**
 * Escaping
 * - .^ $ | [] 정규식에서 특수한 의미가 문자를 문자 그대로 찾고 싶은 경우 escaping이 필요하다.
 * - 다만 []안에서는 escaping을 사용하지 않는다.
 */
target = '3.4$';
console.log(target.replace(/\$/g, '<$&>')); // 3.4<$>
console.log(target.replace(/\./g, '<$&>')); // 3<.>4$

console.log(target.replace(/[$]/g, '<$&>')); // 3.4<$>
console.log(target.replace(/[.]/g, '<$&>')); // 3<.>4$

/**
 * 수량자 quantifier
 * a* a가 0개이상
 * a+ a가 1개이상
 * a? a가 0개 또는 1개
 */
target = 'aabc abc bc';
console.log(target.replace(/a*b/g, '<$&>'));
console.log(target.replace(/a+b/g, '<$&>'));
console.log(target.replace(/a?b/g, '<$&>'));

target =
  'ABCDEFGhijklmn 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ 1234567890 !@#$%^&*()=+=+ \t\n';
console.log(target.replace(/[A-Z]+[a-z]/g, '<$&>'));

/**
 * 수량자
 * a{5} a가 5개
 * a{2,5} a가 2개이상 5개 이하
 * a{2,} a가 2개이상
 *
 * // a{,5} 존재하지 않는 문법
 */
target = 'aa aba abba abbba';
console.log(target.replace(/ab{0,}a/g, '<$&>')); // <aa> <aba> <abba> <abbba>
console.log(target.replace(/ab{1,}a/g, '<$&>')); // aa <aba> <abba> <abbba>
console.log(target.replace(/ab{0,1}a/g, '<$&>')); // <aa> <aba> abba abbba

// 사용자비밀번호 4자리 숫자여부 검사
re = /^[0-9]{4}$/;
re = /^\d{4}$/;
re = /^[\d]{4}$/;
console.log(re.test('1234')); //true
console.log(re.test('123456')); //fase
console.log(re.test('123x')); //fase
console.log(re.test('abcd')); //fase
console.log(re.test('123')); //fase

/**
 * Look Around 탐색
 * - 조회/검사에는 사용하지만, 매칭 결과에는 반영되지 않는다.
 *
 * - Look Ahead 전방탐색
 *    a(?=b) b가 뒤따르는 a를 검사
 *
 * - Look behind 후방탐색
 *    (?<=b)a b가 앞서있는 a를 검사
 *    (?<!b)a b가 앞서있는 않은 a를 검사
 */
target = 'hello world hello tom hello jane hello world';

console.log(target.replace(/hello(?= world)/g, '<$&>')); // <hello> world hello tom hello jane <hello> world
console.log(target.replace(/hello(?! world)/g, '<$&>')); // hello world <hello> tom <hello> jane hello world

target = 'hello world lotte world t world usim world';
console.log(target.replace(/(?<=hello )world/g, '<$&>')); // hello <world> lotte world t world usim world
console.log(target.replace(/(?<!hello )world/g, '<$&>')); // hello world lotte <world> t <world> usim <world>

/**
 * 복잡한 유효성검사 처리하기
 * - 8~12자리
 * - 숫자포함
 * - 영문자포함
 * - 특수문자포함
 */
const reArr = [/^.{8,12}$/, /\d/, /[A-Za-z]/, /[!@#$%]/];

target = 'ds1020304##';
const result = reArr.every((re) => re.test(target));
console.log(
  result ? '유효한 비밀번호 입니다.' : '비밀번호가 유효하지 않습니다.'
);
