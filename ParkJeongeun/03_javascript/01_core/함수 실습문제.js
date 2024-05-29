// 2-1.
const num1 = 10;
const num2 = 20;

function min(a, b){
    a > b ? console.log('최소값 : ' + b) : console.log('최소값 : ' + a)
}
min(num1, num2);

function max(a, b){
    a > b ? console.log('최대값 : ' + a) : console.log('최대값 : ' + b)
}
max(num1, num2);

// 2-2.
const x = 2;
const n = 10;
function pow(x, n){
    if(typeof n == BigInt && n > 0){
        for(let i = 1; i < n; i++){
            x * x;
        }
    } else {
        console.log(n + '은 양의 정수여야 합니다. 다시 입력해주세요.');
    }    
}
pow(x, n);