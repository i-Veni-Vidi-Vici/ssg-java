/**
 * coersion 강제형변환
 * - implicit coersion 암묵적 형변환
 * - explicit coersion 명시적 형변환
 */

/**
 * 1. 암묵적 형변환
 * - string으로 변환
 * - number로 변환
 * - boolean으로 변환
 */
console.log(10+"abc", typeof (10 + "abc")); // 10abc string

console.log(10 + "2" , typeof(10 + "2")); // 102 string
console.log(10 - "2", typeof(10 - "2")); // 8 number
console.log(10 * "2", typeof(10 * "2")); // 20 number
console.log(10 / "2", typeof(10 / "2")); // 5 number
console.log(10 % "2", typeof(10 % "2")); // 0 number

// 숫자로 암묵적 형변환이 불가능한 경우 NaN을 반환 (Not a Number)
// NaN은 number타입이다
console.log(10 * "abc", typeof (10 * "abc")); // NaN number
// 크기비교를 위해 숫자로 암묵적 형변환
console.log(10 > "5"); // 10 > 5 형변환 후 처리 true

// 논리형으로의 암묵적 형변환
// - 논리값으로 평가되어야 하는 곳에서 일어난다.
// - Truthy value (true로 평가되는 값들) - 값이 있는 경우 : 123, 45.67, -100, "ㅋㅋㅋ", {}빈객체, []빈배열 , Infinity
// - Falsy value (false로 평가되는 값들) - 값이 없는 경우 : 0, 0.0, "", undefined, null, NaN
if(123) console.log('123는 true입니다.');
if(45.67) console.log('45.67는 true입니다.');
if(-100) console.log('-100는 true입니다.');
if("ㅋㅋㅋ") console.log('"ㅋㅋㅋ"는 true입니다.');
if({}) console.log('{}는 true입니다.');
if([]) console.log('[]는 true입니다.');
if(Infinity) console.log('Infinity는 true입니다.');

console.log();

if (!0) console.log('0은 false입니다.');
if (!0.0) console.log('0.0은 false입니다.');
if (!"") console.log('""은 false입니다.');
if (!undefined) console.log('undefined은 false입니다.');
if (!null) console.log('null은 false입니다.');
if (!NaN) console.log('NaN은 false입니다.');

/**
 * 2. 명시적 형변환
 * - String(), toString() 문자열로 변환
 * - Number(), parseInt(), parseFloat() 숫자로 변환
 * - Boolean(), !! 논리형으로 변환
 */
console.log(String(123),typeof(String(123))); // 123 string
console.log((123).toString(), typeof (123).toString()); // 123 string (123 원시값에 대해 임시적으로 Wrapper객체를 생성해서 메소드 호출가능)

console.log(Number("123.456"),typeof Number("123.456")); // 123.456 number
console.log(parseInt("123.456"),typeof parseInt("123.456")); // 123 number
console.log(parseFloat("123.456"),typeof parseFloat("123.456")); // 123.456 number

console.log(Boolean("ㅋㅋㅋ"),typeof Boolean("ㅋㅋㅋ")); // true Boolean
console.log(!!"ㅋㅋㅋ",typeof !!"ㅋㅋㅋ"); // true Boolean
