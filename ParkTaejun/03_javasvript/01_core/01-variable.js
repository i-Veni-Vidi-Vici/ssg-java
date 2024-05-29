// 한줄주석 
/*
    여러줄 주석
*/ 

// 인터프리터 방식 언어
//  - 소스ㅗㅋ드와 목적코드가 같은 언어

/**
 * 자바스크립트의 8가지 자료형 
 * 
 */

const n = 123;
console.log(n);

let k = '🥀'
console.log(k);


let a;
console.log(a, typeof a) ; // type 검사한 것 
a = 123; 
console.log(a, typeof a); // 123 number

let b = 1;
console.log(b, typeof b);
let c = 123.456;
console.log(c, typeof c); // 123.456 number

// 정수/실수간의 연산은 모두 실수로써 처리된다.
console.log(10/4);

const str1 = "홍길동";
const str2 = '신사임당';
const str3 = `이순신`; 


const str = `안녕하세요 
반갑습니다. ${str1}`; 
console.log(str);

console.log(str1, typeof str1); 
console.log(str2, typeof str2);
console.log(str3, typeof str3);

const bool = true;
console.log(bool, typeof bool);
console.log(!bool);

let x = 123;
x = null;
console.log(x, typeof x); //null object 
// type 했는데 왜 object ? -> 자바 스크립트의 근본적인 오류
// js 초기부터 object 타입에 대한 type tag와 실제값이 0이 동일하게 생긴 이슈

const bigNum = 12345678901234567890123456890n; //접미사 n을 통해 bigint를 명시
console.log(bigNum, typeof bigNum);

const key = Symbol("key");
console.log(key, typeof key); 

const obj = {
    id: 12345, 
    type : "객체"
};

console.log(obj);
console.log(obj, typeof obj);

const arr = [1, 2, 3, 4, 5];
console.log(arr, typeof arr);

function foo(){
    console.log('foooooooooooooooooooooooooo');
}

foo();
console.log(foo, typeof foo);

let z;
console.log(z);
z = 123;
console.log(z);
z = "홍길동"
console.log(z);