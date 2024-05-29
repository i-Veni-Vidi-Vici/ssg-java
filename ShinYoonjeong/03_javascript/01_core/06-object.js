/**
 * object
 * - 속성/메소드를 가진 자료형
 * - js 유일한 객체형
 * - object/array/function 특별한 자료형 지원
 * - 속성은 속성명/속성값으로 구분되고, 모든 자료형을 지원.
 * - 보통 속성명은 식별자(문자열)를 사용한다.
 */

/**
 * 객체 생성
 * 1. literal로 생성 {}
 * 2. new 연산자
 */
const user = {
    name : '홍길동',
    age : 23,
    married : true,
    sns : ['tiktock', 'instagram', 'facebook'],
    // 속성 값의 타입이 function인 경우, '메소드'라고 한다.
    hi : function(){
        // 현재 객체의 속성을 참조하는 경우 this를 사용해야 한다.
        console.log(`Hi~🍕🍕🍕 ${this.name}`);
    },
    pet : {
        name : '복실이',
        age : 3
    }
}; // 코드블럭(if, for function등)이 아니므로 ;로 종결처리

console.log(user);

// 속성참조
// 1. dot notation
console.log(user.name);
console.log(user.age);
console.log(user.married);
console.log(user.sns[0]);
console.log(user.pet);
console.log(user.hi);

// 메소드 호출
user.hi();

// 2. bracket notation
