/**
 * 함수 function
 * 
 * 함수생성
 * 1. 함수선언식(호이스팅처리 됨) function foo(){}
 * 2. 함수표현식(호이스팅처리 안됨) const foo = function(){};
 * 
 * Hoisting이란?
 * - 실제실행전에 자바스크립트 실행엔진에 의해 함수선언식은 먼저 끌어올려서 처리됨.
 * 
 */

/**
 * 함수 선언식 Function Declaration
 */ 
foo('홍길동');
function foo(name) {
  console.log(`안녕, ${name}`);
}

foo('홍길동');

/**
 * 함수 표현식 Function Expression
 * - 우항의 선언된 함수명은 무시된다. 
 * - 함수는 선언된 변수명으로 호출해야 한다. 
 * - 보통은 이름을 생략한 익명함수를 우항에 작성한다.
 */
// bar('신사임당'); // ReferenceError: Cannot access 'bar' before initialization
const bar = function (name) {
  console.log(`잘가, ${name}`);
};

bar('신사임당');


/**
 * 자바스크립트에서 함수는 일급객체이다. 
 * 1. 변수에 대입가능해야 한다. 
 * 2. 함수호출시 전달이 가능해야 한다. 
 * 3. 함수반환값으로 사용할 수 있어야 한다. 
 * 
 * 함수형프로그래밍에서는 이 함수는 일급객체로 다루는 것이 중요하다. 
 * (자바는 람다를 통해서 우회적으로 위의 조건을 만족시킨다.)
 */
const func = function(){
  console.log(`🚗🚗🚗`);
};


/**
 * 매개변수/매개인자 
 */
const hi = function(name) {
  if(arguments.length !== 1 || typeof name != 'string')
    throw new Error(`name인자가 유효하지 않습니다 : ${name}`);
  console.log(`안녕, ${name}`); 

  // arguments 숨은 참조 변수 : 호출시 전달한 모든 매개인자를 배열로 가지고 있다.
  // 유효성검사용으로 사용가능하다.
  console.log(arguments);
  

};
const name = '이순신';
hi(name); // 안녕, 이순신
// hi(); // 안녕, undefined
// hi('이순신', '세종대왕'); // 안녕, 이순신 (선언되지 않은 매개변수 자리에는 전달하는 매개인자는 무시된다.)

/**
 * < ... >
 * 나머지 파라미터 Rest Parameter : 매개변수부에서 복수개의 값을 처리할 수 있는 변수,
 *  맨마지막에 한번만 사용하기
 * 전개 연산자 Spread Operator : 배열의 요소를 뿌려서 전달(매개인자/값)
 * 파라미터 기본값 : 매개인자가 존재하지 않는 경우(undefined) 지정한 기본값 사용가능
 */
function test1(a, b, c) { // 개수가 매번 달라진다면?
  console.log(a, b, c);
}

function test1(id, ...chars) { // 자바의 가변인자
  // chars 배열로써 처리
  console.log(id, chars);
}

test1(123, '가', '나', '다'); // 123 [ '가', '나', '다' ]
test1(456, '가', '나', '다', '라') // 456 [ '가', '나', '다', '라' ]

function test2(a, b, c) {
  console.log(a, b, c);
}

const arr = [1, 2, 3];
test2(arr[0], arr[1], arr[2]);
test2(...arr);

// 전개연산자는 여러개 나열이 가능하다.
const arr1 = ['🚗'];
const arr2 = ['🚑', '🚒'];
test2(...arr1, ...arr2); // 🚗 🚑 🚒

function test3(x, y = 8888, z) { // default, 따로 명시되지 않을 때 사용된다
  console.log(x, y, z); 
}

test3(10, 20, 30); // 10 20 30
test3(100); // 100 8888 undefined
test3(100, undefined, 200); // 100 8888 200
test3(100, null, 200); // 100 null 200

/**
 * 리턴값 처리
 * - 모든 자바스크립트 함수는 최소한 undefined를 리턴한다. 
 */
const hello = function(){
  // return 'ㅋㅋㅋ';
  return;
};

const result = hello();
console.log(result, typeof result); // 123 number

/**
 * 화살표함수 Arrow Function
 * - 익명함수를 간단히 작성할 수 있는 문법 (ES6)
 * - (매개변수부) => { 함수실행부 }
 * 
 * - 생성자함수로 사용할 수 없다.
 * - 함수 자체의 this가 없고, 부모스코프의 this를 가져와 사용한다.
 */

// const myArrow = function(a, b){
//   return a + b;
// };

// 1. function키워드를 생략하고, => 를 사용해 매개변수부와 몸통부 연결
// 2. 몸통부에 return절을 생략 (return구문 한출만 존재할 때)
// 3. 몸통부의 {} 생략 (실행코드 한줄인 경우)
// 4. 매개변수가 1개인 경우, 소괄호 생략가능

// const myArrow = function(a, b) => {
  //   return a + b;
  // }
  
  const myArrow = (a, b) => a + b;
  const myArrow2 = (k) => console.log(k);
  const myArrow3 = m => m * m;
  console.log(myArrow(10, 20));
  myArrow('🦽');
  console.log(myArrow3(3));
  
  