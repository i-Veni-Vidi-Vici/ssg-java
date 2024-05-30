/**
 * 자바스크립트는 Prototype기반의 객체지향언어이다.
 * - prototype을 이용해서 상속을 구현한다.
 * -[[Prototype]]속성을 가지고, 부모 prototype객체와 연결되어 있다.
 * __prototype_ 포인터를 통해 접근할 수 있다.
 */
const cars=[
    {
        name:"소나타",
        run(){
            console.log(`${this.name}이 부릉부릉 달린다.`);
        }
    },
    {
        name:"그랜져",
        run(){
            console.log(`${this.name}이 부릉부릉 달린다.`);
        }
    },
    {
        name:"봉고",
        run(){
            console.log(`${this.name}이 부릉부릉 달린다.`);
        }
    }
];

cars.forEach((car) => car.run());
console.log(cars);

/**
 * 생성자함수
 * - 객체 생성을 목적으로 하는 함수. 
 * - new연산자와 함께 호출할때만 객체가 생성된다.
 * - 매개인자를 해당객체 초기화하는 역할
 * - 관례적으로 대문자로 시작하는 이름을 가진다.
 */
function Car(name){
    // this는 현재객체를 가리킨다.
    this.name = name;
    this.run = function(){
        console.log(`${this.name}이 부릉부릉 달린다.`);
    }
    // const car = new Car('굿모닝');
    // console.log(car);
    const cars2 = [
        new Car('소나타'),
        new Car('그랜져'),
        new Car('봉고')
    ];

}