//2-1 MAX, MIN함수
console.log("2-1 MIN, MAX함수 ");
function max(a,b){
    if(a>b)
        return a;
    else return b;
}

function min(a,b){
    if(a>b)
    return b;
else return a;
}

const num1 = 10;   
const num2 = 20;

var max=max(num1,num2);
console.log("max : ",max);

var min=min(num1,num2);
console.log("min : ",min);

//2-2 pow function
console.log("2-2 pow function");
const x=2;
const n=10;

function pow(x,n)
{
    let multi =1;
    if(n<1)
        {
            return "자연수를 입력해주세요";
        }
    else{
        for(let i=0;i<n;i++)
            {
                multi*=x;
            }
            return multi;
    }
}
var pow=pow(x,n);
console.log("pow : ",pow);


console.log("2-3 화살표 함수");
//2-3 min max
const a = 10;   
const b = 20


max=(a,b)=>{
    return a>b?a:b
};
console.log("max : ", max(a,b));

min=(a,b)=>{
    return a>b?b:a
}
console.log("min : ", min(a,b));
