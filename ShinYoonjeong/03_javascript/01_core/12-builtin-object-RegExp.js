/**
 * 정규표현식 Regular Expression
 * - RegExp객체
 * - 문자열에 대해서 유효성검사/검색/대체등의 작업을 수행하는 표현식
 * - 조건/반복처리 대비에서 괸장히 간결하게 코드작성이 가능.
 * - 학습비용이 요구되는 편.
 * - 언어독립적. 타 프로그래밍 언어에서 사용 가능
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
 * - RegExp#exec
 * - RegExp#test
 * 
 * String 메소드
 * - String#split
 * - String#replace
 * - String#match
 * - String#search
 */

console.log(re1.exec("a1b2c3")); // [ '1', index: 1, input: 'a1b2c3', groups: undefined ]
console.log(re1.exec("abc")); // null
console.log(re1.test("a1b2c3")); // true
console.log(re1.test("abc")); // false

console.log("a1b2c3".split(re1)); // ['a','b','c', '']
console.log("a1b2c3".replace(re1, "*")); // a*b*c*
console.log("a1b2c3".match(re1)); // [ '1', '2', '3' ] 매칭된 결과를 배열로 반환
console.log("a3b4c5".search(re1)); // 1 매칭된 문자열릐 인덱스 반환
/**
 * flag 옵션
 * -g global 전역비교 수행. 이게 없으면 매칭된 첫 문자열만 처리
 * -i ignore 대소문자 구분안함.
 * -m multiline 여러줄인 데이터에 한해 행단위 검색
 */
let target = 'Javascript jQuery Ajax sass'

console.log(target.replace(/a/, '<$&>')); // 매칭된 결과를 가리키는 와일드 카드

/**
 * anchor 문자
 * - ^ 문자열의 시작
 * - $ 문자열의 끝
 */
target = 'Javascript jQuery Ajax sass xxx';
console.log(target.replace(/j/gi, '<$&>'));
console.log(target.replace(/^j/gi, '<$&>'));

/**
 * . 문자
 * - 아무 글자 하나를 의미
 * - 개행문자는 포함되지 않는다.
 */
let re = /^a.b/;
console.log(re.test('acb'));
console.log(re.test('acbbbbbbb'));
console.log(re.test('a b'));
console.log(re.test('ab'));

re = /in.$/;
console.log(re.test('going'));

/**
 * []
 * - 문자 하나에 대한 값 목록 혹은 범위 지정
 * - 범위는 ascii코드 기반으로 지정
 * - []안에서 ^로 시작하면 반전을 의미
 */

/**
 * 단축문자
 * \w word 영문자/숫자/_ 문자
 * \d digit 숫자
 * \s whitespace 공백/탭/개행문자
 * 
 * \W \w 반전 
 * \D \d 반전
 * \S \s 반전
 */
/**
 * () 그룹핑
 * | or 연산자
 */
target = '월요일에는 월요병';
console.log(target.replace(/(수요일|목요일|금요일)/g, "<$&>"));

/**
 * Escaping
 * . ^ $ | [] 정규식에서 특수한 의미가 있는 문자를 문자 그대로 찾고 싶은 경우 escaping이 필요하다.
 * - 다만 []안에서는 escaping을 사용하지 않는다.
 */
target = '3.4$';
console.log(target.replace(/\$/g, '<$&>'));
console.log(target.replace(/\./g, '<$&>'));
/**
 * 수량자 quantifier
 * a* a가 0개이상
 * a+ a가 1개이상
 * a? a가 0개 또는 1개
 */
target = "aabc abc bc";
console.log(target.replace(/a*b/g, '<$&>'));
console.log(target.replace(/a+b/g, '<$&>'));
console.log(target.replace(/a?b/g, '<$&>'));
target = 'ABCDEGFhijklmn 가나다라마바사ㅋㅋㅎㅎㅓㅓㅏㅏ 1234567890 !@#$%^&*()\t\n';
console.log(target.replace(/[A-Z]+[a-z]/g, '<$&>'));

/**
 * 수량자
 * a{5} a가 5개
 * a{2,5} a가 2개 이상 5개 이하
 * a{2,} a가 2개 이상
 */
target = "aa aba abba abbba";
console.log(target.replace(/ab{0,}a/g, "<$&>"));
console.log(target.replace(/ab{1,}a/g, "<$&>"));
console.log(target.replace(/ab{0,1}a/g, "<$&>"));

// 사용자 비밀번호 4자리 숫자여부 검사
re = /[0-9]{4}$/;
console.log(re.test("1234"));
console.log(re.test("123456"));
console.log(re.test("123x"));
console.log(re.test("abcd"));
console.log(re.test("123"));

/**
 * Look Around 탐색
 * - 조회/검사에는 사용하지만, 매칭 결과에는 반영되지 않는다.
 * 
 * - Look Ahead 전방탐색
 *  a(?=b) b가 뒤따르는 a 검사
 *  a(?!b) b가 뒤따르지 않는 a를 검사
 * 
 * - Look behind 후방 탐색
 *  (?<=b)a b가 앞서있는 a를 검사
 *  (?<!b)a b가 앞서있지 않은 a를 검사
 */
target = "hello world hello tom hello jane hello world";
console.log(target.replace(/hello(?= world)/g, "<$&>"));

target = "hello world lotte world t world usim world";
console.log(target.replace(/(?<=hello)world/g, "<$&>"));

/**
 * 복잡한 유효성 검사 처리하기
 * - 8 ~ 12 자리
 * - 숫자 포함
 * - 영문자 포함
 * - 특수문자포함
 */
const reArr = [
    /^.{8,12}$/,
    /\d/,
    /[A-Za-z]/,
    /[!@#$%]/
];

target = "Pa$$word123";
const result = reArr.every((re) => {
    re.test(target)
});
console.log((result? '유효한 비밀번호입니다.' : '비밀번호가 유효하지 않습니다'));
