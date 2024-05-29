//1
let z = 50;
(function(){
    let z = 55;
    z += 45;
    console.log(`z = ${z}`); //z = 100  내부 스코프의 변수를 연산
})();              
console.log(`z = ${z}`);   //z = 50 내부 스코프 연산을 우선하였으므로 초기 값을 유지


//2
let y = 99;
(function() {
    let x = 100;
    let y = 9;
    z = 1;
    console.log(`x + y + z = ${x + y + z}`); //110 (x=100, y= 9 z=1) 
})();
console.log(`y + z = ${y + z}`); //100 (y=99, z=1)
// console.log(`x + y + z = ${x + y + z}`);    
//error (z is not defined)

//3
let i; // 전역 i
for (i = 1; i <= 10; i++) {
	console.log(i); // 1~10까지 출력
}

(function(){
	console.log(`i = ${i}`); //11 (10까지 출력하고 11일때 조건을 만족하지 않아 반복문을 탈출하였다)
})();
    
//4
/**
 * ----예상-------
 * 함수식을 반환 값으로 갖는 함수
 * console.log로 num을 출력하는 함수식을 갖고 있다
 * 하지만 내부 함수식이 foo의 num에 접근하기 위해서는 this 키워드를  붙여주어야 한다
 * num을 못찾아서 undefined를 가지든지 오류가 날것으로 예상
 */ 
function foo(){
    let num = 100;
    return () => {
        console.log(`num = ${num}`);
    }
}
const num = 200;
const too = foo();  //함수를 반환 받아서 console.log(`num = ${num}`);을 실행하는 함수가 될것이다
console.log(foo);
foo.num = 777;  //num 값을 변경해보았음
too(); //100 (오류가 나지 않고 함수 내부의 초기 값을 참조함)
console.log(`foo.num = ${foo.num}`);    //777
const koo = foo();  //100 함수 정의시에 사용된 초기값이 바인딩 되는듯?
koo();  
console.log(foo);   //[Function: foo] { num: 777 } 속성으로 num:777이 추가됨

/**
 * 클로저(closure)
 * - 함수가 자신이 생성된 환경(lexical environment)에 있는 변수들을 기억하고 있는것
 * - 이를 통해 함수가 정의될 때의 변수 값들을 기억하고 참조함
 * - foo()는 클로저를 반환하고 반환된 함수는 num변수에 대한 참조를 유지함
 * - 클로저는 내부적으로 num을 가지고 있지 않으며 foo#num에 대한 참조를 유지한다
 * 
 * - 중간에 실행한 foo.num =777는 foo에 num=777 이라는 새로운 속성을 추가한 것
 * - 그러므로 전혀 영향을 줄 수 없다
 * - java의 객체, method 와 js의 function을 혼동하여 생긴 문제
 * - java의 객체와 같은 형태를 가지려면 object가 function을 가져야 할것이다
 * 
 * - 클로저가 내부에 중복되는 변수명을 가지면 클로저의 내부 변수를 우선하여 참조한다
 * - 
 *          ************이때 this 키워드는 사용할 수 없다 ***********
 * - this는 메소드 형태로 존재할 때만 사용가능하다.
 * - function 단독으로는 활용할 수 없다
 * - 클로저의 변수명이 중복되지 않게 작성 하는것이 중요 
 */