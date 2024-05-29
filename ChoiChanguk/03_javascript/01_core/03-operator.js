/**
 * 동일비교 연산자 ==, !=
 * - 타입이 달라도, 암묵적 형변환 후 값이 같다면 true를 반환
 * 
 * 엄격동일 비교 연산자 === !==
 * - 타입과 값이 모두 동일해야 true를 반환
 */

console.log(3=='3'); // true 암묵적형변환을 거쳐 동일한 타입(number)으로 변환 후 비교
console.log(3!='3'); // false

console.log(3==='3'); // false 암묵적 형변환 없이 타입/값 모두 비교
console.log(3!=='3'); // true 암묵적 형변환 없이 타입/값 모두 비교, 하나라도 달라서 true

// 주의해야 할 비교 예제
console.log(`1==true : ${1 == true}`); // true (true가 1로 암묵적 변환)
console.log(`100==true : ${100 == true}`);
console.log(`1 === true : ${1===true}`);

console.log(`0== false : ${ 0== false}`);
console.log(`0== '' : ${ 0== ''}`);
console.log(`0=== false : ${ 0=== false}`);
console.log(`0=== '' : ${ 0=== ''}`);

console.log(`undefined == null : ${undefined==null}`); // true
console.log(`undefined === null : ${undefined===null}`); // false

/**
 * 문자열 크기 비교
 * - 사전등재순으로 비교
 */
console.log(`a<b : ${'a'<'b'}`); // true
console.log(`a>b : ${'a'>'b'}`); // false

/**
 * 단축 평가
 * - a&&b : a,b가 모두 true인 경우 true반환
 * - a||b : a,b 둘 중 하나 true인 경우 true반환
 */

console.log(`apple && banana : ${'apple' && 'banana'}`);


