/**
 * coersion 강제 형변환
 * implicit coersion : 암묵적 형변환
 * explicit coeersion : 암시적 형변화
 * 
 * 
 * 1. 암묵적 형변환
 * - string으로 변환
 * - number으로 변환
 * - boolean으로 변환
 */

console.log(10 + "abc" ,typeof(10+"abc")) // 10abc string

console.log(10 + "2", typeof(10 + "2"))
console.log(10 - "2", typeof(10 - "2"))
console.log(10 * "2", typeof(10 * "2"))
console.log(10 / "2", typeof(10 / "2"))
console.log(10 % "2", typeof(10 % "2"))

//숫자로 암묵적 형변환이 불가능한 경우 Nan을 반환 (Not a Number)
console.log(10 * "abc",typeof(10 * "abc")) //Nan number

//코기 비교를 위해 숫자로 암묵적 형변환
console.log(19 > "5") // 19 > 5 형 변환 후 cjfl

//논리형으로의 암묵적 형변환
//- 논리값으로 평가되어야 하는 곳에서 일어난다.
// - Truthy value(true로 평가되는 값들) - 값이 있는 경우 123, 45,-100,
// - Falsy value(false로 평가되는 값들) - 값이 없는 경우 0, 0.0,"",undefined, null , Nan

if(123) console.log(`123는 true 입니다.`);
if(45.67) console.log(`45.67는 true 입니다.`);
if(-100) console.log(`-100 true 입니다.`);
if("ㅋㅋㅋ") console.log(`"zㅋㅋㅋ" true 입니다.`);
if({}) console.log(`{}는 true 입니다.`);
if([]) console.log(`[]는 true 입니다.`);
if(Infinity) console.log(`Infinity는 true 입니다.`);

if(!0) console.log(`123는 true 입니다.`);
if(!0.0) console.log(`45.67는 true 입니다.`);
if(!"") console.log(`-100 true 입니다.`);
if(!undefined) console.log(`"zㅋㅋㅋ" true 입니다.`);
if(!null) console.log(`{}는 true 입니다.`);
if(!NaN) console.log(`[]는 true 입니다.`);

/**
 * 명시적 형변환 
 * - String(), toString() 문자열로 반환 
 * - Number()m parseInt(),parseDouble() 숫자로 실행
    Boolean(), !!논리형으로 변환
*/

console.log(String(123), typeof String(123)); //123 String
console.log((123).toString(),typeof(123).toString());; //123원시값에 대해서 임시적으로 Wrappr에 대한 객체를 생성해서 메소드 호출 가능)

console.log(Number("123.456"), typeof Number("123.456"));
console.log(parseInt("123.456"), typeof parseInt("123.456"));
console.log(parseFloat("123.456"), typeof parseFloat("123.45566"));
