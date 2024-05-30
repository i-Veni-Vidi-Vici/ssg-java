//1
let z = 50;
(function(){
    let z = 55;
    z += 45;
    console.log(`z = ${z}`); // 100
})();              
console.log(`z = ${z}`); // 50

//2
let y = 99;
(function() {
    let x = 100;
    let y = 9;
    z = 1;
    console.log(`x + y + z = ${x + y + z}`); // 110
})();
console.log(`y + z = ${y + z}`); // 100
// console.log(`x + y + z = ${x + y + z}`); // 200 ★x is not defined

//3
let i; // 전역 i
for (i = 1; i <= 10; i++) {
	console.log(i); // 1~10까지 출력
}

(function(){
	console.log(`i = ${i}`); // 11
})();
    
//4 
function foo(){
    const num = 100;
    return () => {
        console.log(`num = ${num}`); // 100 ★여기서 출력X(밑에 too()에서 출력)
    }
}
const num = 200;
const too = foo();
too(); // 100