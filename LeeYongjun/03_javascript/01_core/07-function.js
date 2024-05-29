/**
 * 함수 function 
 * 
 * 함수생성
 * 1. 함수선언식 function foo(){} 
 * 2. 함수표현식 const foo = function(){};
 * 
 * Hoisting이란? 
 * - 실제 실행전에 자바스크립트 실행엔진에 의해 함수선언식은 먼저 끌어올려서 처리됨.
 *  
 */

// 함수 선언식 
function foo(name) {
    console.log(`안녕,${name}`);
};

foo('홍길동')

/**
 * 함수 표현식 Function Expressions
 * - 우항에 선언된 함수명은 무시된다.
 * - 함수는 선언된 변수명으로 호출해야 한다.
 * - 보통은 이름을 생략한 익명함수를 우항에 작성한다.
 */
const bar = function (name) {
    console.log(`잘가,${name}`);
};
bar('신사임당');

/**
 * 자바스크립트에서 함수는 일급객체이다. 
 * 1. 변수에 대입가능해야 한다. 
 * 2. 함수호출시 전달이 가능해야 한다. 
 * 3. 함수반환 값으로 사용할 수 있어야 한다. 
 * 
 * 함수형프로그래밍에서는 이 함수는 일급객체로 다루는 것이 중요하다, 
 * (자바는 람다를 통해서 우회적으로 위의 조건을 만족)
 */
const func = function () {
    console.log('👌👌👌');
};

/**
 * 매개변수/매개인자
 */
const hi = function (name) {
    if (arguments.length !== 1 || typeof name != 'string')
        throw new Error('name인자가 유효하지 않습니다 :', name);
    console.log(`안녕,${name}`);

    // arguments 숨은 참조 변수 : 호출시 전달한 모든 매개인자를 배열로 가지고 있다. 
    console.log(arguments);

};
hi('이순신'); // 안녕, 이순신
// hi();
// hi('이순신', '신사임당');

/**
 * 리턴값 처리
 * - 모든 자바스크립트 함수는 최소한 undefined를 리턴한다.
 */
const hello = function () {
    // return 123;
}
const result = hello();
console.log(result, typeof result);
