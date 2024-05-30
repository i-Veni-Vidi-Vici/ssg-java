/**
 * 자바스크립트는 Prototype기반의 객체지향 언어이다.
 * - prototype을 이요해 상속을 구현함
 * - [[Prototype]]속성을 가지고, 부모 prototype 객체와 연결되어 있다.
 * - __prototype__포인터를 통해 접근할 수 있다. 
 */

const cars = [
    {
        name : "소나타",
        run () {
            console.log(`${this.name}이/가 부릉부릉 달린다.`);
        }
    },
    {
        name : "그랜져",
        run () {
            console.log(`${this.name}이/가 부릉부릉 달린다.`);
        }
    },
    {
        name : "봉고",
        run () {
            console.log(`${this.name}이/가 부릉부릉 달린다.`);
        }
    }
];

cars.forEach((car) => car.run());
console.log(cars);

// 생성자함수
// - 객체 생성을 목적으로 하는 함수.
// - new 연산자와 함께 호출할 때만 객체가 생성된다.
// - 매개 인자를 해당 객체 초기화하는 역할
// - 관례적으로 대문자로 시작하는 이름을 가진다.
function Car(name) {
    //this는 현재 객체를 가리킴
    this.name = name;
    this.run = function(){
        console.log(`${this.name}이/가 부릉부릉 달린다.`);
    };
}
Car.prototype.run = function(){ // prototype이라는게 이미 존재함
    console.log(`${this.name}이/가 부릉부릉 달린다.`);
}
// const car = new Car('굿모닝');
// console.log(car);

const cars2 = [
    new Car('소나타'),
    new Car('그랜져'),
    new Car('봉고')
];
cars2.forEach((car) => car.run());

/**
 * Car 생성자 함수
 * - prototype속성으로 프로토타입 객체를 참조한다.
 * 
 * Car.prototype 프로토타입 객체
 * - constructor속성으로 생성자 함수를 참조한다.
 * 
 * 생성된 Car 객체 (new Car())
 * - - [[Prototype]] 속성으로 프로토타입 객체를 참조한다.
 * - 프로토타입 객체를 통해 공통속성을 사용할 수 있다.
 */
console.log(Car.prototype.constructor === Car); // true
console.log(new Car('카니발').__proto__=== Car.prototype);// true

function A(){
    //현재 객체 this는 new연산자 호출 결과로 만들어질 객체
    // this.id = '가나다';
    // this.hello = function() {
    //     console.log('안녕');
    // }
}

A.prototype.id = 'ABC';
A.prototype.hello = function() {
    console.log('Hi');
};

const a = new A();
console.log(a.id); // 가나다
a.hello(); // 안녕

console.log(A.id); // static(생성자 함수) 속성
A.hello();

