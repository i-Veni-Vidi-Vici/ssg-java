/**
 * 동일비교연산자 ==, !=
 * - 타입이 달라도, 암묵적형변환 후 값이 같다면 true를 반화
 * 엄격동일비교연산자 ===, !==
 * - 타입과 값이 모두 동일해야 true를 반환
 */
console.log(3== "3"); // true 암묵적형변환을 거쳐 동일한 타입(number)으로 변환 후 비교
console.log(3 != "3"); // false

console.log(3 === "3"); // false 암묵적형변환 없이 타입/값을 모두 비교
console.log(3 !== "3"); // true

// 주의해야 할 비교예제
console.log(`1 == true : ${1 == true}`); // true (true가 1(number)으로 암묵적 형변환 처리)
console.log(`100 == true : ${100 == true}`); // false
console.log(`1 === true : ${1 === true}`); // false

console.log(`0 == false : ${0== false}`); // true (false가 0(number)로 암묵적 형변환 처리)
console.log(`0 == "" : ${0 == ""}`) // true (""이 0(number)로 암묵적 형변환 처리)
console.log(`0 === false : ${0 === false}`); // false
console.log(`0 === "" : ${0 === ""}`); // false

console.log(`undefined == null: ${undefined == null}`); // true
console.log(`undefined === null: ${undefined === null}`); // false


/**
 * 문자열 크기비교
 * - 사전등재순으로 비교
 */
console.log(`apple < banana : ${'apple'< 'banana'}`); // true
console.log(`apple > banana : ${'apple'> 'banana'}`); // false

/**
 * 단축 평가
 * - a && b : a, b가 모두 true인 경우 true 반환
 * - a || b : a, b 둘 중 하나가 true인 경우 true 반환
 */

// && 좌항이 true인 경우 우항을 반환, 좌항이 false일 경우, 좌항을 반환
console.log("apple" && "banana"); // banana
console.log(0 && "banana"); // 0

// || 좌항이 true인 경우 좌항을 반환, 좌항이 false인 경우, 우항을 반환
console.log("apple" || "banana"); // apple
console.log(0 || "banana"); // banana

// 우항에 값이 아닌 코드도 작성가능하다.
const num =10;
num %2 == 0 && console.log("짝짝짝"); // 좌항이 참인 경우 우항을 실행
num %2 != 0 && console.log("홀홀홀"); // 좌항이 거짓인 경우 우항을 실행하지 않는다.

num %2 == 0 || console.log("짝짝짝"); 
num %2 != 0 || console.log("홀홀홀"); 


// 대입식에 단축평가 활용
const obj = null;
const value = obj && obj.value; // obj가 존재하면, obj.value를 대입
console.log(value); //null

const str= null;
const sth = str || '기본값'; // str가 존재하면, str반환, str가 존재하지 않으면, 기본값 반환
console.log(sth); // 기본값