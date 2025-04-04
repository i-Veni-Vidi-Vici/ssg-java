// 1번
let z = 50; // 전역 global scope
(() => {
    let z = 55; // 지역 local scope
    z += 45;
    console.log(`z = ${z}`); // 100
})();
console.log(`z = ${z}`); // 50

// 2번
let y = 99; // 전역 
(() => {
    let x = 100;
    let y = 9; // 지역
    z = 1; // 전역 z
    console.log(`x + y + z = ${x + y + z}`); // 110
})();
console.log(`y + z = ${y + z}`); // 100
// console.log(`x + y + z = ${x + y + z}`); // Uncaught ReferenceError: x is not defined

// 3번 
let i; // 전역 i로 선언하면 반복문 블럭 이후에서도 접근할 수 있다.
for (i = 1; i <= 10; i++) {
    console.log(i); // 1~10까지 출력
}
console.log(`i = ${i}`); // 11

// var 변수 유효범위(scope)는 block-scope가 아니라 function-scope이다.
// function안에서만 유효. function바깥의 block은 모두 무시.
// 전역에 선언된 var는 전역객체 window의 속성으로 등록된다.
for (var j = 1; j <= 10; j++) {
    console.log(j); // 1~10까지 출력
}
(() => {
    console.log(`j = ${j}`); // j = 11
})();

(function () {
    var k = 10; // 지역변수
})();
// console.log(k); // Uncaught ReferenceError: k is not defined

//4 
function yoo() {
    const num = 100;
    return () => console.log(`num = ${num}`);
}
const num = 200;
const too = yoo(); // closure함수
console.log(too);
too(); // 100