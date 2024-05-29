/**
 * scope 변수 유효 범위 
 * - global scope
 *     코드 영역의 가장 바깥부분 
 *     global scope에서 선언된 변수는 local scope에서 참조 할 수 있다.
 *     모든 하위 scope에서 접근가능(읽기, 쓰기)하므로 global scope의 변수 선운은 지양해야한다.
 * 
 * - local scope
 *     코드 블럭{}안을 의미 (if, for, function)
 *     지역에 선언된 변수는 지역 안에서만 참조 가능, 다른 지역 또는 전역에서는 참조 할 수 없다.
 */

let a = 10; //전역변수 선언
console.log(a);

function foo(){
    let b = 20;

    console.log('foo a');
    console.log('foo',b);
}

foo()
//console.log(b); RefereenceError : b is not defined

if(true){
    let c= 30;
    console.log(c);
}

for(let i = 0 ; i< 10; i++){//지역변수 ( for ) 
    console.log(i);
}

let j;
for(j = 0; j < 10; j++){
    console.log(j);
}
console.log(j);

/**
 * Scope Chain
 * - 변수 사용 Local Scope -> Global Scope 순으로 찾게 된다.
 * - 변수가 존재하면 사용, 없으면 undefined등으로 처리한다.
 */

let x = 30;
function bar(){
    let x = 20;
    if(true){
       // let  x = 10;
        console.log(x);
    }
}
bar();

/**
 * let | const | var
 * - var : 함수 스코프를 가지고 있음.
 * - let / const 블럭 스코프 지원
 * 
 * var는 레거시 브라우져 호환용으로만 사용. 소스코드 작성에는 불필요함.
 */

if(ture){
    var k = 300; // 지역 스코프가 아니라 전역 스코프임
}
console.log(k); // 300

function foo(){
    var k  = 2100;
}
console.log(k);