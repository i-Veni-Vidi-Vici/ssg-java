/**
 * object
 * - 속성/메소드를 가진 자료형
 * - js 유일한 객체형
 * - object / array / function 특별한 자료형 지원
 * - 속성은 속성명/속성값으로 구분되고, 모든 자료형을 지원
 * - 보통 속성명은 식별자(문자열)를 사용한다.
 */

/**
 * 객체생성
 * 1. literal로 생성 {}
 * 2. new 연산자 이용
 */

const user = {
    name : '홍길동',
    age : 23,
    married : true, 
    sns : ['tiktok', 'instagram', 'facebook'],
    // 속성값의 타입이 function인 경우, '메소드'라고 한다.
    hi : function() {
        // 현재객체의 속성을 참조하는 경우 this를 사용해야 한다. 
        console.log('Hi~🍳🍳🍳');
    },
    pet : {
        petName : '복실이',
        age : 3
    },
    100 : '홍길동100',
    "user-car" : '소나타',
    "user favorite food" : '물회'
}; // 코드블럭(if, for, function)이 아니므로 ;로 종결처리

console.log(user);

// 속성참조
// 1. dot notation
console.log(user.name);
console.log(user.age);
console.log(user.married);
console.log(user.sns);
console.log(user.pet);
console.log(user.hi); // 함수 속성을 보여줘

// 메소드 호출
user.hi();

// 2. bracket notation
// 식별자가 아닌 속성명은 bracket notation으로만 호출이 가능하다. 
console.log(user['name']);
console.log(user['age']);
console.log(user['married']);
console.log(user['sns']);
console.log(user['sns'][0]);
console.log(user['pet']);
user['hi']();

console.log(user[100]);
console.log(user['user-car']);
console.log(user['user favorite food']);

// bracket notation 사용시 주의사항
console.log(user['name']); // user의 name 속성
const name = 'age';
console.log(user[name]); // user의 name변수의 대입된 값 속성

/**
 * 모든 속성은 동적으로 추가/수정/삭제가 가능하다.
 */
// const obj = {};
const obj = new Object();
console.log(obj);

// 속성 추가
obj.id = 123;
obj.name = '친구';
console.log(obj); // {id: 123, name: '친구'}

// 속성 수정
obj.name = '바보';
console.log(obj); // {id: 123, name: '바보'}

// 속성값 삭제
obj.name = null; // {id: 123, name: null}

// 속성 삭제
delete obj.name;
console.log(obj); // {id: 123}

/**
 * 객체 단축 속성 등록
 * - property
 * - method
 */
const id = 'p-001';
const price = 3000;
// const product = {
//     id : id,
//     price : price
// };

// 속성명 : 변수명
// 속성값 : 변수값
const product = {
    id, price
};
console.log(product);

// 메소드 단축등록
const car = {
    name : '소나타',
    // run : function(){
    //     console.log(`${this.name}이 부릉부릉`);
    // }
    run() { // 메소드에서만 먹히는 방식
        console.log(`${this.name}이 부릉부릉`);
    }
};
car.run();

// 함수등록은 해당사항이 없다.
function foo() {}
// foo(){}

/**
 * 객체 사용법
 * - namespace와 같이 사용하는 것을 추천한다.
 * - 속성/메소드를 객체라는 namespace로 구분지어 관리할 수 있다. 
 */

const calculator = {
    plus(a, b) {
        return a + b;
    },
    minus(a, b){
        return a - b;
    },
    multiply(a, b){
        return a * b;
    },
    divide(a, b){
        return a / b;
    },
    remainder(a, b){
        return a % b;
    }
};

console.log(calculator.plus(10, 20)); // 30
console.log(calculator.minus(10, 20)); // -10
console.log(calculator.multiply(10, 20)); // 200
console.log(calculator.divide(10, 20)); // 0.5
console.log(calculator.remainder(10, 20)); // 10

/**
 * 객체 반복처리
 * - for..in문
 * - Object.keys()
 * - Object.values()
 */
const menu = {
    name : '순대국',
    price : 10000,
    options : ['안매운', '보통', '매운']
}

// for..in문 (enumberable: true인 속성들을 순회)
// - 객체의 모든 속성을 순회
for (const key in menu) {
    console.log(`key = ${key}, value = ${menu[key]}`);
}

// Object.keys() : key값만 배열로 반환
console.log(Object.keys(menu)); // [ 'name', 'price', 'options' ]
// ['순대국', 10000, ['안매운', '보통', '매운']]

// Object.values() : value값만 배열로 반환
console.log(Object.values(menu)); // [ '순대국', 10000, [ '안매운', '보통', '매운' ] ]

// in 연산자
// 객체에 속성이 존재하는지 여부 반환
const student = {
    name : '홍길동',
    age : 33, // 마지막 콤마는 문법적 오류를 유발하지 않는다. 
    // school : '오지라퍼스 Academy'
};

console.log("name" in student); // true
console.log("score" in student); // false

console.log(student.name !== undefined); // true
console.log(student.score !== undefined); // false

// student 객체에 school 속성이 없으면, school : 'SSG학교'를 추가하는 코드를 작성
("school" in student) || (student.school = 'SSG학교');
console.log(student);

/**
 * 객체 속성(property)과 flag
 * 
 * - value : 속성값
 * - writable : true/false(읽기전용)
 * - enumerable : true(for..in문에서 반복접근)/false
 * - configurable : true(속성삭제/다른 flag 수정)/false
 */
const coffee = {
    name : '아메리카노'
  };
  
  console.log(Object.getOwnPropertyDescriptor(coffee, 'name'));
  
  for (let key in coffee) {
    console.log(`key = ${key}`);
  }
  
  // 속성추가 (flag설정)
  Object.defineProperty(coffee, 'price', {value: 3000, writable: false, enumerable: false});
  // ReadOnly, 반복접근 불가
  console.log(Object.getOwnPropertyDescriptors(coffee));
  
  for (let key in coffee) {
    console.log(`key = ${key}`);
  } // key = name -> price가 나오지 않음