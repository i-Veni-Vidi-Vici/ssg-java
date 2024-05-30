/**
 * 생성자함수간 상속 처리
 * 
 * - Car 생성자
 * - Truck 생성자
 */
function Car(name) {
    this.name = name;
    
}
// 일반함수로 작성할 것(화살표 함수 사용금지)
Car.prototype.run = function(){
    console.log(`${this.name}이/가 부릉부릉 달린다.`);
};

/**
 * 1. 부모생성자 함수 호출
 * 2. 프로토타입객체 새로 생성(부모프로토타입을 상속)
 * 3. 프로토타입객체 - 생성자함수 연결 처리
 */
function Truck(name, capacity){
    // 1. 부모생성자호출
    Car.call(this, name);
    this.capacity=capacity;
}
// 2. 프로토타입 생성
Truck.prototype = Object.create(Car.prototype);
// 3. 프로토타입객체-생성자함수 연결처리
Truck.prototype.constructor = Truck;

const bongo = new Truck('봉고', 1000);
console.log(bongo.name, bongo.capacity);
bongo.run();

/**
 * class 문법 
 * - 생성자 함수 안에서 부모 생성자 호출가능
 * - 메소드는 자동으로 prototype에 작성됨.
 * - 메소드오버라이드
 */
class FamilyCar extends Car{
    /**
     * 생성자 함수
     */
    constructor(name, nums){
        super(name);
        this.nums = nums;
    }
    /**
     * 자동으로 FamilyCar.prototype객체에 메소드 등록
     */
    tour(){
        console.log(`패밀리카 "${this.name}"이 ${this.nums}명을 싣고 여행을 간다~`);
    }
    run(){
        super.run(); // 부모 메소드 호출가능\
        console.log("woooooooooow");
        
    }
    toString(){
        console.log('카니발 toString : ' + super.toString());
    }
}
const carnival = new FamilyCar('카니발', 7);
console.log(carnival.toString());
carnival.run();
carnival.tour();