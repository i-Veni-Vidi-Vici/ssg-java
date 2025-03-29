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
console.log(`x + y + z = ${x + y + z}`); // 200(X) // Uncaught ReferenceError: x is not defined
// y = 99, z = 50

//3
let i; // 전역 i
for (i = 1; i <= 10; i++) {
	console.log(i); // 1~10까지 출력
}

(function(){
	console.log(`i = ${i}`);
})(); // i = 10(X) // i = 11
    
//4 
function foo(){
    const num = 100;
    return () => {
        console.log(`num = ${num}`);
    }
}
const num = 200;
const too = foo(); // () => {console.log(`num = ${num}`);}
too(); // num = 100;