/**
 * 함수의 여러가지 형태
 * 1. 즉시실행함수
 * 2. 재귀함수
 * 3. 중첩함수
 * 4. 콜백함수
 * 5. 순수함수
 * 6. 클로져함수
 */

/**
 * 1. 즉시실행함수(IIFE)
 *  - Immediately Invoked Function Expression
 *  - 선언과 실행을 동시에 작성하는 함수
 *  - 1회용 (재사용할 수 없다.)
 *  - 
 */
(() => {
  console.log("🥗");
})();

((food) => {
  console.log(food);
})('🍖');

// 전역스코프
let salad = "🥗";
salad = '🥙';
console.log(salad);

(() => {
  // 지역스코프 
  // 지역변수를 선언하고, 값을 보호하기 위해서 IIFE 사용한다.
  let salad = "🥗";
  console.log(salad);
})();

(() => {
  // 지역스코프 
  // 동일한 이름의 변수를 다른 스코프에 선언해 쓰는 것은 가능하다.
  let salad = "🥗";
  console.log(salad);
})();


/**
 * 2. 재귀호출함수
 *  - 함수 안에서 함수 자신을 다시 호출하는 경우
 *  - 종료조건을 반드시 명시해야 한다. (stackover flow 오류가 발생할수 있어 주의) 
 *  - 반복처리 보다 더 간단히 처리가능한 경우 사용하면 좋다. (하노이탑)
 */

// n! (factorial) = 1 * 2 * 3 * ... * n
// 5! = 5 * 4 * 3 * 2 * 1
const factorial = (n) => {
  if(n == 1) return 1; // 종료조건
  return n * factorial(n - 1);
};
console.log(factorial(5));

/**
 * 3. 중첩함수
 *  - 함수내부에 함수를 선언해 사용
 *  - 내부함수를 굳이 노출할 필요가 없는 경우 사용할 수 있다.  
 */
// 10 -> 10, 3 -> 03
const outer = (n) => {
  const inner = (k) => k < 10 ? '0' + k : k;
  console.log(inner(n));
};
outer(15); // 15
outer(7); // 07

/**
 * 4. 콜백함수 Callback
 *  - js의 함수는 일급객체(값)으로써 매개인자로 전달할 수 있고, 이를 함수 내부에서 호출할 수 있다. 
 * 
 */
const a = (f) => {
  f();
};
const b = () => console.log('🍳');
a(b);

/**
 * 5. 순수/비순수 함수
 *  - 모든 함수에는 입력/출력이 있다. 
 *  - 함수에는 부입력/부출력이 있을수 있다. (명시적으로 전달한 매개인자/리턴값외에 외부스코프의 값을 입력/출력으로 사용할 수 있다.)
 *  
 *  - 순수함수 : 의부상태에 의존/변경하지 않는 함수
 *  - 비순수함수 : 의부상태에 의존/변경하는 함수
 * 
 *  - 되도록 순수함수를 사용하도록 하면 좋다. 
 *  - 순수함수를 이용해서 불변성을 추가하는 프로그램밍 방식이 함수형 프로그래밍이다.
 */
const pureFunc = (n) => {
  return ++n;
};
console.log(pureFunc(1));

let count = 0;
const impureFunc = (n) => {
  count = count + 1;
  return ++n;
};
console.log(impureFunc(1));


/**
 * 6. Closure함수
 * - 자유변수 free variable : 함수 지역번위에서 선언되지 않은 변수
 * - 모든 자유변수가 전역변수인 것은 아니다.
 * 
 * 클로져함수란? 자유변수를 가지고 외부로부터 닫힌 함수
 * - 클로져가 가진 자유변수는 외부로부터 접근이 불가능하고, 안전하게 관리할 수 있다.
 */

const word = "안녕";
const greeting = (name) => {
  const word2 = "반가워";
  console.log(`${word},${name},${word2}`);
};
greeting('길동');

function yoo() {
  const num = 100;
  return () => console.log(`num = ${num}`);
}

const num = 200;
const too = yoo(); // closure함수 (자유변수 num(100)을 가지고 외부로부터 닫힌 함수)
// const too = () => console.log(`num = ${num});
console.log(too);
too(); // 100


let cnt = 0;
const globalCounter = () => console.log(++cnt);
globalCounter();
globalCounter();
globalCounter();
cnt = 100;

const closureCounterMaker = () => {
  let cnt = 0;
  return () => console.log(++cnt);
};

// 접근할 수 있는 방법이 없다 오염이 안 된다.
// 클로저 함수 너무 깊게 생각 x 
const closureCounter= closureCounterMaker();
closureCounterMaker();
closureCounterMaker();
closureCounterMaker();