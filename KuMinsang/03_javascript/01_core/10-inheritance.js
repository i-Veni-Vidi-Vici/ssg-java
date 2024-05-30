/**
 * 생성자 함수간 상속 처리
 * - Car 생성자
 * - Truck 생성자
 */
function Car(name){
    this.name = name;
}
Car.prototype.run = function(){
    console.log(`${this.name}이/가 부릉부릉 부르르릉~`);
};

car = new Car('🏍️');
car.run();

/** ****Car를 상속한 Truck객체 만들기****
 * 1. 부모생성자 함수 호출
 * 2. 프토로타입객체 새로 생성(부모프로토타입을 상속)
 * 3. 프로토타입객체-생성자함수 연결처리
 * ======레거시 코드 이다======
 */
function Truck(name, capacity){
    //1.부모 생성자 호출
    Car.call(this, name);
    this.capacity = capacity;
}

//2. 프로토타입 생성
Truck.prototype = Object.create(Car.prototype);
//3. 프로토타입객체-생성자함수 연결처리
Truck.prototype.constructor = Truck;

const bongo = new Truck('봉고', 1000);
console.log(bongo);
console.log(bongo.name, bongo.capacity);
bongo.run();

/**
 * 위의 상속처리가 너무 불편해서 class 문법이 추가됨
 * class 문법
 * - 생성자함수 안에서 부모생성자 호출가능
 * - 메소드는 자동으로 prototype에 작성됨
 * - 메소드 오버라이드(super 키워드 사용가능)
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
        console.log(`패밀리카 ${this.name}이 ${this.nums}명을 싣고 여행을 간다~`);
    }

    run(){
        super.run();    //부모 메소드 호출가능
        console.log("끼얏호우우우우~!");
    }
    toString(){
        console.log('카니발 toString : ' + super.toString());
    }
}

const familycar = new FamilyCar('카니발', 30);
familycar.run();
familycar.tour();
familycar.toString();
