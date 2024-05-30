//2-1. min, max function
function min (a, b) {
    const result = a - b;
    console.log(result < 0 ? a : b); 
}

function max (a, b) {
    const result = a - b;
    console.log(result > 0 ? a : b); 
}
min(30, 2);
max(3, 20); 

//2-2. pow function
function pow(x, n){
    let result = x;
    if(n < 1) {
        console.log("자연수를 입력해주세요");

    }else{
        for (let i = 1; i < n; i++) {
            result = result * x;
        }
        console.log(result);
    }

}
pow(2, 5);

//2-3. min, max function 화살표 함수
const min2 = (a, b) => {
    const result = a - b;
    if (result < 0) {
        return a;
    }
}

const max2 = (a, b) => {
    const result = a - b;
    if (result < 0) {
        return a;
    }
}
console.log(min2(4, 5));
console.log(max2(4, 5));

