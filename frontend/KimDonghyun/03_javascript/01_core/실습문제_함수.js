// 2-1. min, max function
const num1 = 10;
const num2 = 20;
console.log("최소값 : " + min(num1, num2));
console.log("최대값 : " + max(num1, num2));

function min(a, b) {
  /*
  if (a < b) {
    return a;
  } else {
    return b;
  }
  */
  return a < b ? a : b;
}

function max(a, b) {
  /*
  if (a > b) {
    return a;
  } else {
    return b;
  }
  */
  return a > b ? a : b;
}

// 2-2. pow function
const x = 2;
const n = 10;

if (n < 1) {
  console.log(n + '은 양의 정수이어야 합니다.');
} else {
  console.log(pow(x, n));
}

function pow(x, n) {
  let result = x;

  for (let i = 1; i < n; i++) {
    result *= x;
  }

  return result;
}

// 2-3. min, max function 화살표 함수
const a = 10;
const b = 20;

const getMin = (a, b) => a < b ? a : b;
const getMax = (a, b) => a > b ? a : b;

console.log("최소값 : " + getMin(a, b));
console.log("최대값 : " + getMax(a, b));
