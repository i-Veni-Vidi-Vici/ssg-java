/* 2-1. min, max function */

const num1 = 10;
const num2 = 20;
// 코드 작성
function min (a, b) {
    return a <= b ? a : b;
}
function max (a, b) {
    return a >= b ? a : b;
}
console.log('최소값 : ' + min(num1, num2) + '\n최대값 : ' + max(num1, num2));


/* 2-2. pow function */

const x = 2;
const n = 10;
// 코드 작성
function pow (x, n) {
    return Math.pow(x, n);
}
if (n >= 1) {
    console.log(pow(x, n));
} else {
    console.log(n + '은 양의 정수이어야 합니다.');
}


/* 2-3. min, max function 화살표 함수 */

const a = 10;
const b = 20;
// 코드 작성
min = (a, b) => a <= b ? a : b;
max = (a, b) => a >= b ? a : b;
console.log('최소값 : ' + min(a, b) + '\n최대값 : ' + max(a, b));