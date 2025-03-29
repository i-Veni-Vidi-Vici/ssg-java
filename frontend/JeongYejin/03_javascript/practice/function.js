/**
 * ! 2. 함수
 * ! 2-1. min, max function
 */
const num1 = 10;
const num2 = 20;

function min (a, b){
    if (a < b)
        return a;
    return b;
};

function max (a, b){
    if (a < b)
        return b;
    return a;
};

console.log(`최소 값 : ${min(num1, num2)}`);
console.log(`최대 값 : ${max(num1, num2)}`);

/**
 * ! 2-2. pow function
 */

const x = 2;
const n = 10;

function pow (x, n){
    if (n > 0) {
        let result = 1;
        for (let i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    } else {
        return `${n}은 양의 정수이어야 합니다.`;
    }
}

console.log(pow(x, n));

/**
 * ! 2-3.
 */
const a = 10;
const b = 20;

const min2 = (a, b) => {
    // if (a < b)
    //     return a;
    // return b;
    return a < b ? a : b;
};

const max2 = (a, b) => {
    // if (a < b)
    //     return b;
    // return a;
    return a < b ? b : a;
};

console.log(`최소 값 : ${min2(a, b)}`);
console.log(`최대 값 : ${max2(a, b)}`);
