// 한줄
/*
여러줄
*/

/**
 * 자바스크립트의 8가지 자료형
 * -undefined
 * -null
 * -string
 * -number
 * -boolean
 * -object
 * -bigint
 * -symbol
 */

//두가지 키워드를 통해 변수 선언
//cont(상수선언)
//let(변수선언) 진짜 변경되어야 할 값만 사용
//var(직접 사용할 필요 없다. 레거시브라우져 호환용)
const n = 123;
console.log(n);

let k ="🦄🦄🦄";
console.log(k);

/**
 * 1.undefined
 * - 아직 값이 할당되지 않은 상태를 가리키는 타입이자 값
 */
let a;
console.log(a, typeof a);
a = 123;
console.log(a, typeof a);

/**
 * 2. number
 * - 정수/실수를 모두 관리할 수 있는 숫자형
 */
let b = 1;
console.log(b, typeof b);

let c = 0.1;
console.log(c, typeof c);

//정수, 실수간의 연산은 모두 실수로써 처리된다
console.log(10/4); //2.5

/**
 * 3. string
 * - 문자열을 다루는 타입
 * - "", '', ``로 감싸서 리터럴을 생성
 */

const str1 = "홍길동";
const str3 = '이재용';
//es6(ES2015)에 추가된 Template String 문법
// ``안에서 개행/탭문자를 인식. ${}표현식을 통해 다른 변수 출력 가능
const str2 = `박지원`; 

console.log(str1, typeof str1);
console.log(str2, typeof str2);
console.log(str3, typeof str3);

const str = `안녕하세요
반갑습니다
개행테스트 입니다. 
${str1}을 호출 해봅니다`;

console.log(str);

/**
 * 4. boolean
 * - 논리형 타입 true | false
 */
const bool = true;
console.log(bool, typeof bool); //true boolean
console.log(!bool); //false

/**
 * 5. null
 * - 값 없음을 의미하는 타입이자 값
 * - 초기화된 값이 없음을 의미하는 undefined와 존재할 값이 없는 null은 다르다
 * - 기존 값을 제거하는 경우 반드시 undefined가 아닌 null을 사용해야 한다.
 */

let x = 123;
x = null;
console.log(x, typeof x); 
//null object (object 타입에 대한 type tag값(0)과 null 타입의 실제 값인 0이 동일해서 생긴 이슈)

/**
 * 6. bigint
 * -길이 제약없이 정수를 제어하는 타입
 */

const bigNum = 12881304803547024750247502n;
console.log(bigNum, typeof bigNum);

/**
 * 7. sybol
 * - 고유한 식별자를 생성하기 위한 타입
 * - 객체 속성명으로 사용
 */

const key = Symbol("key")
console.log(key, typeof key);

/**
 * 8. object
 * - js 자료형중 유일한 객체형 (나머지 7가지는 모두 primitive 타입)
 * - 속성 / 메소드를 가진 자료형
 * 
 * object의 하위타입
 * - object
 * - array
 * - function
 */

const obj = {
    id : 12345, 
    type : "객체"
};

console.log(obj, typeof obj);
console.log(obj.id, obj.type, typeof obj);

function foo(){
    console.log("JS is the best");
}
foo();
console.log(foo, typeof foo);


/**
 * 자바스크립트는 동적타입언어이다
 * - 정적 타입언어 (c, c++, java,)
 * - 동적 타입언어 (js, python, ...)
 */

let z;
console.log(z);
z = 123;
console.log(z);
z = "hong"
console.log(z);