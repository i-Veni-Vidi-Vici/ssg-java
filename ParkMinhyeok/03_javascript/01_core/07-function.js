const bar = (name) => {
  console.log(`${name}`);
};
bar('park');

/**
 * 나머지 파라미터 Rest Parameter : 매개변수부에서 복수개의 값을 처리할수 있는 변수, 맨 마지막에 한 번만 사용하기
 * 전개연산자 Spread Operator : 배열의 요소를 뿌려서 전달
 * 파라미터 기본값
 */

function test1(...chars) {
  console.log(chars);
}

test1('가', '나', '다');

function test2(a, b, c) {
  console.log(a, b, c);
}

const arr = [1, 2, 3];
test2(...arr);

const arr1 = ['🍊'];
const arr2 = ['🍊', '🥩'];
test2(...arr1, ...arr2);

/**
 * 재귀호출함수
 * - 함수 안에서 함수 자신을 다시 호출하는 경우
 * - 종료 조건을 반드시 명시해야 한다.(stack over flow 오류가 발생할 수 있어 주의)
 * - 반복처리 보다 더 간단히 처리 가능한 경우 사용하면 좋다, (하노이의 탑)
 */

const factorial = (n) => {
  if (n === 1) return 1; // 종료조건
  return n * factorial(n - 1);
};
console.log(factorial(5));

const test = (n) => {
  return ++n;
};
console.log(test(1));

/**
 * Closure 함수
 * - 자유변수 free variable : 함수 지역범위에서 선언되지 않은 변수
 * - 모든 자유변수가 전역변수인 것은 아니다.
 *
 * 클로져 함수란? 자유변수를 가지고 외부로부터 닫힌 함수
 * - 클로져가 가진 자유변수
 */
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
const closuerCounter = closureCounterMaker();
closuerCounter();
closuerCounter();
closuerCounter();
cnt = 100;
closuerCounter();
closuerCounter();
closuerCounter();
