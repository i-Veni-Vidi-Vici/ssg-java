/**
 * 생성자함수간 상속 처리
 * 
 * - Car 생성자
 * - Truck 생성자
 */

function Car(name){
    this.name=name;
}

// 일반ㅂ함수로 작성할 것(화살표함수 사용금지)
Car.prototype.run=function(){
    console.log(`${this.name}이/가 부릉부릉~ 달립니다`);
};

/**
 * 1. 부모생성자함수 호출
 * 2. 프로토타입객체 새로 생성(부모프로토타입 상속)
 * 3. 프로토타입객체 - 생성자함수 연결처리
 */
function Truck(name, capacity){
    //1. 부모생성자 호출
    Car.call(this,name);
    
    this.capacity=capacity;
}

// 2. 프로토타입 생성
Truck.prototype = Object.create(Car.prototype);
// 3. 프로토타입객체 - 생성자함수 연결처리
Truck.prototype.consturctor=Truck;
// 이 순서를 하면 car를 상속한 Truck 객체를 만든거다

const bongo=new Truck('봉고',1000);
console.log(bongo);
console.log(bongo.name, bongo.capacity);
bongo.run();

/**
 * class 문법
 *  - 생성자 함수 안에서 부모 생성자(super()) 호출 가능
 *  - 메소드는 자동으로 prototype에 작성됨
 *  - 메소드 오버라이드(super키워드 사용가능)
 * 
 */
class FamilyCar extends Car{
    /**
     * 생성자함수
     */
    constructor(name, nums){
        super(name)
        this.nums=nums;
    }


    /**
     * 자동으로 FamilyCar.prototype객체에 메소드등록
     */
    tour(){
        console.log(`패밀리카"${this.name}"이 ${this.nums}명을 싣고 여행을 간다~`);
    }
    run(){
        super.run();
        console.log("wwwwwoooooooooooooooooooooooooooo~~~ 자동차");
    }
}

const carnival=new FamilyCar('카니발',7);
console.log(carnival);
carnival.run();
carnival.tour();
/**
 FamilyCar { name: '카니발', nums: 7 }
카니발이/가 부릉부릉~ 달립니다
wwwwwoooooooooooooooooooooooooooo~~~ 자동차 이 부분이 오버라이드 됐다
패밀리카"카니발"이 7명을 싣고 여행을 간다~
 */