/**
 * 함수 function
 * 
 * 함수생성
 * 1. 함수선언식 (호이스팅 처리됨) function foo() {} - 이놈은 선언보다 먼저 호출가능
 * 2. 함수표현식 (호이스팅 처리 안됨) const foo = function (){} - 선언보다 먼처 호출불가능
 * 
 * Hoisting이란?
 *  - 실제 실행전에 자바스크립트 실행엔진에 의해 함수 선언식은 먼저 끌어올려서 처리됨
 */

// 함수 선언식 Function Declaration
console.log('Function Declaration');
console.log('함수 선언전 호출'); 
foo('선언 전');
function foo(name){
    console.log(`안녕+${name}`);
};
foo('최창욱');

/**
 * 함수 표현식 Function Expression
 * - 우항의 선언된 함수명은 무시된다
 * - 함수는 선언된 변수명으로 호출해야 한다.
 * - 보통은 이름을 생략한 익명함수를 우항에 작성한다
 * */ 
console.log('Function Expression');
// bar라는 변수에 함수를 대입 했다
const bar=function barrrrrrrr(name){
    console.log(`잘자,${name}`);
};
bar('최창욱');

/**
 * 자바스크립트에서 함수는 일급객체이다
 * 1. 변수에 대입가능해야 한다.
 * 2. 함수호출 시 전달이 가능해야 한다.
 * 3. 함수의 반환값으로 사용할 수 있어야 한다.
 * 
 * 함수형 프로그래밍에서 이 함수는 일급객체로 다루는 것이 중요하다
 */

const func=function(){
    console.log('자동차 자동차');
};

const hi= function(name){
    // if(arguments.length!==1 || typeof name !='string')
    //     throw new Error(`name인자가 유효하지 않습니다 : ,${name}`);
    console.log(`안녕. ${name}`);
    // arguments 숨은 참조 변수 : 호출시 전달한 모든 매개인자를 배열로 가지고 있다
    // 유효성검사용으로 사용가능하다
    console.log(arguments);
}
hi('최창욱');
hi();// undefined
hi('이순신','세종대왕'); // 안녕, 이순신 (선언되지 않은 매개변수 자리에는 전달하는 매개인자는 무시된다)

/**
 * 위치에 따라 다른다 -> 생각해보면 당연하다
 * 나머지 파라미터 Rest Parameter : 매개변수부에서 복수개의 값을 처리할 수 있는 변수, 맨 마지막에 한 번만 사용하기
 * 전개연산자 Spread Oerator : 배열의 요소를 뿌려서 전달(매개인자/값)
 * 파라미터 기본값 : 매개인자가 존재하지 않는 경우 (undefined) 지정한 기본값 사용가능
 */
function test(a,b,c){
    console.log(a,b,c);
}
//function test1(id,...chars) 이렇게 끝에 한 번만 사용 가능하다
function test1(...chars){
 //chars 배열로써 처리
 console.log(chars);
}
test(1,2,3);
test1(1123,2,3,4,5,6);

function test2(a,b,c){
    console.log(a,b,c);
}
const arr=[7458,2,3,4,5]; // test1에 넣어서 사용해서 따로따로 숫자 사용하고 싶은데 -> 그냥 chars[0]+1처리하면 숫자 처리 된다
const arr1=['가','나','다'];
console.log("test2----------------");
// test2(...arr) = test2(arr[0],arr[1],arr[2])
console.log("test2 : ");
test1(...arr);// 매개변수가 a,b,c 3개라서 딱 자리에 맞춰서 들어가기 때문에 4,5 가 안나온다

console.log("test1 : ");
test1(...arr,...arr1);

function test3(x,y=125,z){
    console.log(x,y,z);
}
test3(10,20,30);
test3(100);
test3(100,undefined,200); // 100 125 200 // 기본값이 사용 됐다
test3(100,null,200); // 100 null 200

/**
 * 화살표함수 Arrow Function
 *  - 익명함수를 간단히 작성할 수 있는 문법 (ES6)
 *  - (매개변수부) => {함수실행부}
 * 
 *  - 생성자함수로 사용할 수 없다.
 *  - 함수 자체의 this가 없고, 부모스코프의 this를 가져와 사용한다.
 */

/**
const myArrow=function(a,b){
    return a+b;
};
 */

// 1. function 키워드를 생략하고, =>를 사용해 매개변수부와 몸통부 연결
// 2. 몸통부에 return절을 생략 (return구문 한 줄만 존재할 때)
// 3. 몸통부의 {} 생략 (실행코드가 한 줄일 때)
// 4. 매개변수가 1개인 경우, 소괄호 생략가능

// 1. function 키워드를 생략하고, =>를 사용해 매개변수부와 몸통부 연결
// 2. 몸통부에 return절을 생략 (return구문 한 줄만 존재할 때)
const myArrow1=(a,b)=>a+b;

// 3. 몸통부의 {} 생략 (실행코드가 한 줄일 때)
const myArrow2=(k)=> console.log(k);

// 4. 매개변수가 1개인 경우, 소괄호 생략가능
const myArrow3=m=>m*m;
console.log("myArrow = "+myArrow3(3));
const myArrow=function(a,b){
    return a+b;
};


/**
 * 리턴값 처리
 * - 모든 자바스크립트 함수는 최소한 undefined를 리턴한다
 */
const hello=function(){
    // return; 이렇게 하면 뭐하러 에러를 보내, undefined로 보내면 되지
    return 123;
}
const result=hello();
console.log(result, typeof  result); // 123 number

let num=123;
let a=123123
console.log("asdasdasd","asdasdasd","asdasdsad");