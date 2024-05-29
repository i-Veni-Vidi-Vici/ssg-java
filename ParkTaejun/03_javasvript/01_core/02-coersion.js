console.log(10 + "abc", typeof (10+ "abc")); 




console.log(10 + "2", typeof (10 + "2"));
console.log(10 - "2", typeof (10 - "2"));
console.log(10 * "2", typeof (10 * "2"));
console.log(10 / "2", typeof (10 / "2"));
console.log(10 % "2", typeof (10 % "2"));

console.log(10 * "abc", typeof (10 * "abc")); // NaN number

console.log(10 > "5", typeof ( 10 > "5")); // 1p > 5 형변환 후 처리가 됨 형변한 후 처리 true


// 논리형으로의 암묵적 형변환
// 논리값으로 평가되어야 하는 곳에서 일어난다.


if(123) console.log(`123은 true 입니다. `);
if(45.67) console.log(`45.67은 true 입니다. `);
if(-100) console.log(`-100은 true 입니다. `);
if("ㅋㅋㅋ") console.log(`ㅋㅋㅋㅋ은 true 입니다. `);
if({}) console.log(`{}}은 true 입니다. `);
if([]) console.log(`[]]은 true 입니다. `);
if(Infinity) console.log(`Infinity은 true 입니다. `);

if (!0) console.log(`0은 false 입니다`);
if (!0.0) console.log(`0.0은 false 입니다`);
if (!"") console.log(`""은 false 입니다`);
if (!undefined) console.log(`undefined은 false 입니다`);
if (!null) console.log(`null은 false 입니다`);
if (!NaN) console.log(`NaN은 false 입니다`);


console.log(String(123), typeof String (!23));
console.log((123).toString(), typeof(123).toString()); //123 원시값에 대해 임시적으로 Wrapper 객체를 생성해서 메소드 호출가능

console.log(Number("!23.456"), typeof Number("123.456"));
console.log(parseInt("!23.456"), typeof parseInt("123.456"));
console.log(parseFloat("!23.456"), typeof parseFloat(" 123.456"));

console.log(Boolean("ㅋㅋㅋ"), typeof Boolean("ㅋㅋㅋㅋ")); //true boolean
console.log(!!"ㅋㅋㅋ", typeof !! ㅋㅋㅋ);



