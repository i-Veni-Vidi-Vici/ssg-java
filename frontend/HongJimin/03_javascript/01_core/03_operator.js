// 동일 비교 연산산자 == , !=
// - 타입이 달라도, 암묵적 형변환 후, 값이 같다면 true를 반환

// 엄격 동일 비교 연산자 === !==
// - 타입과 값이 모두 동일해야 true를 반환
console.log(3 == "3"); // true 암묵적 형변환을 거쳐 동일한 타입(number)으로 변환후 비교
console.log(3 != "3");// false

console.log(3 === "3"); // false 암묵적 형변환 없이 타입/값을 모두 비교
console.log(3 !== "3"); // true 

// 주의해야 할 비교 예제
console.log(`1 == true : ${1 == true}`); // true(true가 1(number)으로 암묵적 형변환 처리)
console.log(`100 == true : ${100 == true}`); // false ->  100 == true : false
console.log(`1 === true : ${1 === true}`);// false -> 1 === true : false

console.log(`0 == false : ${0 == false}`);// true -> 0 == false : true
console.log(`0 == '' : ${0 == ""}`);// true -> 0 == '' : trues
console.log(`0 === false : ${0 === false}`); // false -> 0 === false : false
console.log(`0 === '' : ${0 === ""}`); // false -> 0 === '' : false

console.log(`undefined == null : ${undefined == null}`); // true -> undefined == null : true
console.log(`undefined === null : ${undefined === null}`);// false -> undefined === null : false

// 문자열 크기 비교
// - 사전 등재순으 로 비교
console.log(`apple < banana : ${`apple` < `banana`}`); // true -> apple < banana : true
console.log(`apple > banana : ${`apple` > `banana`}`); // false -> apple > banana : false

// 🎈🎈 단축 평가
// - a && b : a, b가 모두 true인 경우, true 반환
// - a | | b : a, b 둘 중 하나가 true인 경우 true 반환
// 🎈🎈 && 좌항이 true인 경우, 우항 반환 / 좌항이 false인 경우, 좌항 반환
console.log("apple" && "banana"); // banana -> 좌항이 true여서 우항값 반환
console.log(0 && "banana"); // 0 -> 좌항이 false

// 🎈🎈 || 좌항이 true인 경우, 좌항 반환 / 좌항이 false인 경우, 우항 반환
console.log("apple" || "banana"); // apple
console.log( 0 || "banana"); // banana

// 우항에 값이 아닌 코드도 작성 가능하다
const num = 10;
num % 2 == 0 && console.log("짝짝짝"); // 짝짝짝 -> 좌항이 참인 경우 우항을 실행
num % 2 != 0 && console.log("홀홀홀"); // 좌항이 거짓인 경우 우항을 실행하지 않는다.

num % 2 != 0 || console.log("짝짝짝"); // 짝짝짝 -> 좌항이 참인 경우, 우항을 실행하지 않는다.
num % 2 == 0 || console.log("홀홀홀"); // 좌항이 거짓인 경우, 우항을 실행

// 대입식에 단축평가 활용
const obj = null;
const value = obj && obj.value; // obj가 존재하면, obj.value를 대입
console.log(value); // null

const str = null;
const sth = str || '기본값'; // str가 존재하면, str반환, str가 존재하지 않으면, 기본값 반환
console.log(sth); // 기본값
