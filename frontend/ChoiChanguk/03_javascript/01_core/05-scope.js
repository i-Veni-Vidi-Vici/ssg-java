/**
 * scope 변수 유효범위
 * 
 * - global scope
 *  - 코드영역의 가장 바깥부분
 *    global scope에서 선언된 변수는 local scope에서 참조할 수 있다
 *    모든 하위 scope에서 접근가능(읽기/쓰기)하므로, global scope의 변수 선언은 지양해야 한다
 *   
 * 
 * - local scope
 *    - 코드불럭{}안을 의미 (if, for, founction 등등)
 *    지역에 선언된 변수는 지역 안에서만 참조가 가능, 
 *    다른 지역 또는 전역에서는 참조할 수 없다
 */

let a=10; // 전역변수 선언
console.log(a);

function foo(){
let b=20;
console.log(`foo `,a);
console.log(`foo `,b);
}
foo();

function bar(){
    let x=20;
    if(true){
        let x=10;
        console.log(x);
    }
}

/**
 * let | const | var
 * - var 함수스코프를 지원(c-family언어가 가진 블럭스코프가 아닌)
 * - let / const 블럭스코프 지원
 * 
 * var는 레거시브라유져 호환용으로만 사용, 소스코드에는 작성 불필요
 */
//var의 구린점
var k=10;
var k=200;
console.log(k);

if(true){
    var k=300; // 전역변수다
}
console.log(k);

function koo(){
    // var은 함수 외에는 전역함수로 취급을 한다, 함수안에 var를 쓰면 지역변수로 적용
    var k=10;
    console.log(k);
}
koo();
console.log(k);

