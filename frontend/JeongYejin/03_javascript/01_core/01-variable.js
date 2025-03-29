// 한줄 주석
/* 여러줄 주석 */

// 인터프리터 방식 언어
// - 소스코드와 목적코드가 같은 언어

/**
 * * 안녕
 * ! 하세요
 * ? 저는
 * todo 정예진 입니다.
 * @param what
 */

/**
 * 자바스크립트의 8가지 자료형
 * - undefined
 * - string
 * - number
 * - boolean
 * - null
 * - object
 * 
 * - bigint
 * - symbol
 */

// 두가지 키워드를 통해 변수 선언
// let (변수선언)
// const (상수선언)
// var (직접 사용할 필요없다. 레거시브라우저 호환용)

const n = 123;
console.log(n);

let k = '🍟';
console.log(k);

/**
 * 1. undefined
 * - 아직 값이 할당되지 않은 상태를 가리키는 타입이자 값
 */
let a;
console.log(a, typeof a); // undefined undefined
a = 123;
console.log(a, typeof a); // 123 number

/**
 * 2. number
 * - 정수/실수를 모두 관리할 수 있는 숫자형
 */
let b = 1;
console.log(b, typeof b); // 1 number

let c = 123.456;
console.log(c, typeof c); // 123.456 number

// 정수/실수간의 연산은 모두 실수로써 처리됩니다.
console.log(10 / 4); // 2.5 

/**
 * 3. string
 * - 문자열을 다루는 타입
 * - "", '', ``로 감싸서 리터럴을 생성
 */
const str1 = "홍길동";
const str2 = '신사임당';
const str3 = `나혜석`; // ES6 추가된 Template String문법 : ``안에서 개행/탭문자를 인식, ${} 표현식을 통해 다른 변수출력가능
console.log(str1, typeof str1, str2, typeof str2, str3, typeof str3);
// 홍길동 string 신사임당 string 나혜석 string

const str = `안녕하세요~!
적당히 바람이 시원해 ${str2} 기분이 너무 좋아요
유후`;
console.log(str);

/**
 * 4. boolean
 * - 논리형타입 true | false
 */
const bool = true;
console.log(bool, typeof bool); // true boolean
console.log(bool); // false

/**
 * 5. null
 * - 값없음을 의미하는 타입이자 
 * - 초기화된 값이 없음을 의미하는 undefined와 존재할 값이 없는 null은 다르므로 유의해서 써야 한다.
 * - 기존값을 제거하는 경우 반드시 undefined가 아닌 null을 사용해야 한다.
*/

let x = 123;
x = null;
console.log(x, typeof x); // null object (js 초기부터 object타입에 대한 type tag와 실제값이 0이 동일하게 생긴 이슈)

/**
 * 6. bigint
 * - 길이 제약없이 정수를 제어하는 타입
 */

const bigNum = 123456789123456789123456789n; // 접미사 n을 통해 bigint를 명시
console.log(bigNum, typeof bigNum);

/**
 * 7. symbol
 * - 고유한 식별자를 생성하기 위한 타입
 * - 객체 속성명으로 사용
 */
const key = Symbol("key");
console.log(key, typeof key); // Symbol(key) symbol

/**
 * 8. object
 * - js자료형중 유일한 객체형 (나머지 가지는 모두 원시형)
 * - 속성/메소드를 가진 자료형
 * 
 * object의 하위타입
 * - object
 * - array
 * - function
 */
const obj = {
    id : 12345,
    type : "객체",
};
console.log(obj);
console.log(obj, typeof obj); // { id: 12345, type: '객체' } object

const arr = [1, 2, 3, 4, 5];
console.log(arr, typeof arr); // [ 1, 2, 3, 4, 5 ] object

function foo() {
    console.log("foooooooooooooooooo");
}

foo();
console.log(foo, typeof foo); // [Function: foo] function

/**
 * 자바스크립트는 동적타입언어이다.
 * - 정적타입언어 (c, c++, java)
 * - 동적타입언어
 */

let z;
console.log(z);
z = 123;
console.log(z);
z = "홍길동";
console.log(z);