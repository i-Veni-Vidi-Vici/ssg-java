/**
 * 함수의 여러가지 형태
 * 1. 즉시 실행함수
 * 2. 재귀함수
 * 3. 중첩함수
 * 4. 콜백함수
 * 5. 순수함수
 * 6. 클로져함수
 */

/**
 * 1. 즉시 실행함수(IIFE)
 * - Immediately Invoked Function Expreesion
 * - 선언과 실행을 동시에 작성하는 함수
 * - 1회용 (재사용할 수 없다.)
 * -
 */
console.log(".1 즉시 실행함수");
(() => {
  console.log("🎃");
})(); // -> 바로 실행이 됨

((bread) => {
  console.log(bread);
})("🥨");

//전역스코프에 변수 선언
let salad = "🥗";
console.log(salad);

//지역스코프에 변수 선언
(() => {
    // 지역변수를 선언하고, 값을 보호하기 위해서 IIFE를 사용함
  let salad = "🥗";
  console.log(salad);
}) ();
console.log();


/**
 * 2. 재귀호출 함수
 * - 함수 안에서 함수 자신을 다시 호출하는 경우
 * - 종료조건을 반드시 명시해야한다. (stackover flow오류가 발생할 수 있어 주의)
 */

// n! (factorial) = 1 * 2 * 3 * ... * n
// 5! = 5 * 4 * 3 * 2 * 1
console.log("2. 재귀호출 함수");
const factorial = (n) => {
    if(n == 1) return 1; // 종료 조건을 꼭 명시해야 함!!
    return n * factorial(n - 1);
};
console.log(factorial(5));
console.log();


/**
 * 3. 중첩함수
 * - 함수 내부에 함수를 선언해 사용
 * - 내부함수를 굳이 노출할 필요가 없는 경우 사용할 수 있다.
 */
// 10 -> 10, 3 -> 03
console.log("3. 중첩함수");
const outer = (n) => {
    const inner = (k) => k < 10 ? '0' + k : k;
    console.log(inner(n));
};
outer(15); // 15
outer(7); // 7
console.log();

/**
 * 4. 콜백함수 Callback 함수
 * - js의 함수는 일급객체(값)으로서 매개인자로 전달할 수 있고, 이를 함수 내부에서 호출할 수 있다.
 * - 
 */
console.log("4. 콜백함수");
const a = (f) => {
    f();
};
const b = () => console.log('🍳');
a(b); // b가 f라는 공간에 담기게 됨
console.log();

/**
 * 5. 순수/비순수 함수
 * - 모든 함수에는 입력/출력이 있다.
 * - 함수에는 부입력/부출력이 있을 수 있다. (명식적으로 전달한 매개인자/리턴값외에 외부스코프의 값을 입력/출력으로 사용할 수 있다.)
 * - 순수함수 : 외부상태에 의존하지 않는 함수
 * - 비순수함수 : 외부상태에 의존/변경하는 함수
 * 
 * - 되도록 순수함수를 사용하도록 하면 좋음!
 * - 순수함수를 이용해서 불변성을 추가하는 프로그래밍 방식이 함수형 프로그래밍
 */
console.log("5. 순수/비순수 함수");
console.log("5 - 1. 순수 함수");
const pureFunc = (n) => {
    return ++n;
}
console.log(pureFunc);
console.log();

console.log("5 - 2. 비순수 함수");
let count = 0;
const impureFunc = (n) => {
    count = count + 1;
    return ++n;
}
console.log(impureFunc(1));
console.log();

/**
 * 6. Closure 함수
 * - 자유변수 free variable : 함수 지역 범위에서 선언되지 않은 변수
 * - 모든 자유변수가 전역변수인 것은 아니다.
 * 
 * - 클로져함수란? 자유변수를 갖고 외부로부터 닫힌 함수
 */
console.log("6. Clousure 함수");
const word = "안녕";

//word는 greeting의 자유변수이다.
const greeting = (name) => {
    const word2 = "반가워";
    console.log(`${word}, ${name}. ${word2}`);
}
greeting('길동');

function yoo(){
    const num = 100;
    return () => console.log(`num = ${num}`);
}
const num = 200;
const too = yoo(); // closure함수
// const too = () => console.log(`num = ${num}`); // closure함수
console.log(too);
too(); // 100

let cnt = 0;
const globalCounter = () => console.log(++cnt);
globalCounter();
globalCounter();
globalCounter();
cnt = 100;
globalCounter();
globalCounter();
globalCounter();

const closureCounterMaker = () => {
  let cnt = 0;
  return () => console.log(++cnt);
};
const closureCounter = closureCounterMaker();
closureCounter();
closureCounter();
closureCounter();
// 자유변수 cnt는 외부에서 접근할 수 없다.