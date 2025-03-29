/**
 * 
 */

/**
 * 1. 암묵적 형변환
 *  - string으로 변환
 *  - number으로 변환
 *  - boolean으로 변환
 */

console.log(10+"abc", typeof (10+"Abc"));

console.log(10+"20",10+"20",typeof (10+"20"));
console.log(10-"20",typeof (10-"20"));
console.log(10*"20",typeof (10*"20"));
console.log(10/"20",typeof (10/"20"));
console.log(10%"20",typeof (10%"20"));

// 숫자로 암묵적 형변환이 불가능한 경우 NaN을 반환 (Not a Number)
console.log(10*"abc", typeof (10*"abc")); //NaN

// 크기비교를 위해 숫자로 암묵적 형변화
console.log(10>"5", typeof (10>"5"));

// 논리형으로의 암묵적 형변환
// - 논리값으로 평가되어야 하는 곳에서 일어난다
// - Truthy value (true로 평가되는 값들) - 값이 있는 경우 123, 45.67,-100, "ㅋㅋㅋㅋㅋㅋㅋ",{}, []
// - Falsy value (false로 평가되는 값들) - 값이 없는 경우 0, 0.0, "", undefined, null, NaN
if(123) console.log('123은 true');
if(45.67) console.log('45.67은 true');
if(-100) console.log('-100은 true');
if("ㅋㅋㅋㅋㅋ") console.log('ㅋㅋㅋㅋㅋ은 true');
if({}) console.log('{}은 true');
if([]) console.log('[]은 true');
if(Infinity) console.log('infinity은 true\n');

if(!0)console.log('!0는 false입니다');
if(!0.0)console.log('!0는 false입니다');
if(!"")console.log('!0는 false입니다');
if(!undefined)console.log('!0는 false입니다');
if(!null)console.log('!0는 false입니다');
if(!NaN)console.log('!0는 false입니다');

/**
 * 2. 명시적 형변환
 *  - String(), toString() 문자열로 변환
 *  - Number(), parseInt(), parseFloat() 숫자로 변환
 *  - Boolean() 논리형으로 변환
 */
console.log(String(123), typeof String(123));

//123 string (123 원시값에 대해 임시적으로 wrapper객체를 생성해서 메소드 호출 가능)
console.log((123).toString(), typeof (123).toString()); 

console.log(Number("123.456"), typeof Number("123.456"));
console.log(parseInt("123.456"), typeof parseInt("123.456"));
console.log(parseFloat("123.456"), typeof parseFloat("123.456"));

console.log(Boolean("zzz"),typeof Boolean("zzzz"));
console.log(Boolean(!"zzz"),typeof Boolean("zzzz"));