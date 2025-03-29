/**
 * 고차함수 high-order function
 * - 함수를 인자를 받거나 리턴하는 함수
 */

/**
 * sort(compareFunction):정렬된 기존배열 반환
 * - compareFunction : 두 요소를 비교후 정수를 반환
 */

const arr = [2, 1, 10, 20, 3];
// arr.sort(); // 기본 compare 함수는 문자단위 비교 (사전등재순)

arr.sort((a, b) => a - b);
console.log(arr);

/**
 * forEach(loopFunction) : 각 요소별로 처리할 함수를 전달
 * - for문 대신 반복처리 가능한 함수
 */

const vegitables = ['오이', '감자', '당근', '양파'];
vegitables.forEach((v, i) => console.log(v, i));

const newVegi = vegitables.map((value) => value);
console.log(newVegi);

const attachedStr = ['안녕', '잘가', '반가웠어'].map(
  (value) => `<p>${value}</p>`
);
console.log(attachedStr);

/**
 * reduce(aggFunction, initValue):resultValue 배열요소에 대한 연산후 결과값을 하나로 반환하는 함수
 */
const sum = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10].reduce((v, i) => {
  console.log(v, i);
  return v + i;
}, 0);
console.log(sum);
