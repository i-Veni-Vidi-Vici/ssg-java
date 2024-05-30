//2-1 min, max function
const num1 = 10;
const num2 = 20;

//최소값 함수
function min(a , b){
    return a < b ? a : b;
}
//최대값 함수
function max(a, b){
    return a > b ? a : b;
}
const minNum = min(num1, num2);
const maxNum = max(num1, num2);
console.log(`최소값 : ${minNum}`);
console.log(`최대값 : ${maxNum}`);

//2-2 pow function
const x = 2;
const n = 10;

function pow(x, n){
    if(!(typeof n === 'number' && Number.isInteger(n) && n>0))
        return `${n}은 양의 정수이어야 합니다`
    console.log();
    let result = 1;
    for(let i =0; i < n; i++)
        result = result * x;
    return result;
}

console.log(`${x} ^ ${n} = ${pow(x, n)}`); //1024
const n2 = -1;
console.log(pow(x, n2)); //1024
const n3 = 0.5;
console.log(pow(x, n3)); //1024

minDirectoin = (a,b) => a < b ? a : b;
maxDirectoin = (a,b) => a > b ? a : b;

console.log(`10와 20의 최소값 = ${minDirectoin(10,20)}`);
console.log(`10와 20의 최대값 = ${maxDirectoin(10,20)}`);
