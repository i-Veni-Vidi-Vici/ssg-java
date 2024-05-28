/**
 * if
 */
if(true) {
  // true
}
else {
  // false
}

/**
 * switch
 */
const value = 1;
switch (value) {
  case 1: console.log(1); break;
  case 2: console.log(2); break;
  default: break;
}

/**
 * for
 */
for(let i = 0; i < 10; i++) {
  console.log(i);
}

/**
 * while
 */
let j = 0;
while(true) {
  console.log(j++);
  if(j > 10) break;
}

/**
 * for..in  
 * - 객체의 enumberable: true인 속성에 대해 반복처리
 * - 배열에 대해 사용시 인덱스가 변수에 대입된다.
 * - 객체에 대해 사용시 속성명이 변수에 대입된다.
 */
const arr = ['가', '나', '다'];
// i : arr의 속성(인덱스)를 담을 변수
for(let i in arr) {
  console.log(i, arr[i]);
}

/**
 * for..of 
 * - Iterable 구현객체에 대한 반복문 
 * - 배열에 대해 사용시 요소가 변수에 대입된다.
 */
for(const value of arr) {
  console.log(value); // 가 나 다
}