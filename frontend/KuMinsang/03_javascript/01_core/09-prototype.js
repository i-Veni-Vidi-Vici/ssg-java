/**
 * 몰?루
 */
const cars = [
    {name : "소나타",
        run(){
            console.log(`${this.name}이/가 부릉부릉 달린다.`);
        }
    },
    {
        name : "그랜저",
        run(){
            console.log(`${this.name}이/가 부릉부릉 달린다.`);
        }
    },
    {name : "봉고",
        run(){
            console.log(`${this.name}이/가 부릉부릉 달린다.`);
        }
    }
];

cars.forEach((car) => car.run());
console.log(cars);

/**
 * 생성자함수
 * - 객체생성을 목적으로 하는 함수
 * - new 연산자와 함께 호출할때만 객체가 생성된다
 * - 매개인자를 해당객체 초기화 하는 역할
 * - 관례적으로 대문자로 시작하는 이름을 가진다.
 */

function Car(name){
    //this는 현재 객체를 가리킨다
    this.name1 = name;
    this.run = function(){
        console.log(`${this.name1}이/가 부릉부릉 달린다.`);       
    };
}

// const car = new Car('굿모닝');
// console.log(car);
/**
 * this를 안쓰면 name1이 클로저가 된다.
 * 다름을 기억해둘것
 */
const cars2 = [
    new Car('소나타'),
    new Car('그랜져'),
    new Car('봉고')
];

cars2.forEach((car) => car.run());

console.log(Car.prototype.constructor === Car); //true
console.log(new Car('카니발').__proto__ === Car.prototype);    //true

function A(){
    this.id = '가나다';
    this.hello = function(){
        console.log('안녕');
    }
}

A.prototype.id = 'ABC';
A.prototype.hello = function(){
    console.log('Hi');
}

A.id = 123;
A.hello = function(){
    console.log(456);
}