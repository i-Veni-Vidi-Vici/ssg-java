// 2 
// min, max

const num1 = 10;
const num2 = 20;
// 코드 작성

function min(a,b) {
    return a < b ? a : b
}

function max(a,b) {
    return a > b ? a : b
}

console.log('최솟값 :' ,min(num1,num2));
console.log('최댓값 :' ,max(num1,num2));



// pow fuction


const x = 2;
// const n = -1;
const n = 10;


function pow(x,n) {
    if(n >= 1) {
        let answer = 1;
        for(let i =0; i<n; i++){
            answer *= x;
        }
        return answer
    }
    else {
        return `${n}은 양의 정수이어야합니다.`;
    }
}

console.log(pow(x,n));

const a = 10;
const b = 20;


// 코드 작성

const max_2 = (a,b) => {
    return a < b ? a : b
}

const min_2 = (a,b) => {
    return a > b ? a : b
}

console.log('최솟값 :' ,min_2(a,b));
console.log('최댓값 :' ,max_2(a,b));


