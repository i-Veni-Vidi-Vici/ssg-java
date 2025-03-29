/**
 * scope 변수 유효범위
 * - global scope
 *      코드영역의 가장 바깥 부분
 *      global scope에서 선언된 변수는 local scope에서 참조할 수 있다.
 *      모든 하위 scope에서 접근 가능(읽기/쓰기)하므로 gloabl scope의 변수 선언은 지양해야 한다. 
 * 
 * - local scope
 *      코드블럭{}안을 의미 (if,for,function등)
 *      지역에 선언된 변수는 지역 안에서만 참조가능 다른 지역 또는 전역에선느 참조 할 수 없다. 
 */
let a = 10;
console.log(a);

function foo() {
    let b = 20;
    console.log(a);
    console.log(b);
}
foo();

if (true) {
    let c = 30; // 지역변수 (if블럭)
    console.log(c);
}

for (let i = 0; i < 10; i++) {
    console.log(i); // 지역변수 (for블럭)
}

let j; // 전역변수
for (j = 0; j < 10; j++) {
    console.log('for', j);
}
console.log(j);

/**
 * Scope Chain
 * - 변수사용 Local Scope -> Global Scope 순으로 찾게 된다.
 * - 변수가 존재하면 사용, 없으면 undefined등으로 처리한다. 
 */
let x = 30;
function bar() {
    let x = 20;
    if (true) {
        // let x = 10;
        console.log(x);
    }
}
bar();

/**
 * let | const | var
 * - var 함수스코프를 지원 (c-family언어가 가진 블럭스코프가 아닌)
 * - let/const 블럭스코프 지원 
 * 
 * var는 레거시브라우져 호환용으로만 사용. 소스코드에는 작성 불필요. 
 */
var k = 100;
var k = 200; // 변수재선언 가능 
console.log(k);


if (true) {
    var k = 300; // 전역변수 
}
console.log(k); // 300


function koo() {
    var k = 400; // 지역변수 
    console.log('koo',k); // 400
}
koo();
console.log(k); // 300

const m = 10;
