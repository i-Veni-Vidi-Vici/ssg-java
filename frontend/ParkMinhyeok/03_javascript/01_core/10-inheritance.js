/**
 * 생성자함수간 상속 처리
 *
 * - Car 생성자
 * - Truck 생성자
 */
function Car(name) {
  this.name = name;
}

Car.prototype.run = function () {
  console.log(`${this.name}이/가 부릉부릉 달린다.`);
};

/**
 * 1. 부모 생성자 함수 호출
 * 2. 프로토타입 객체 새로 생성(부모 프로토타입을 상속)
 * 3. 프로토타입 객체 - 생성자함수 연결처리
 */
function Truck(name, capacity) {
  Car.call(this, name);

  this.capacity = capacity;
}
// 2. 프로토타입 생성
// Truck.prototype = Object.create(Car.prototype);
// Truck.prototype.constructor = Truck;

// const bongo = new Truck('봉고', 1000);
// console.log(bongo);
// bongo.run();

class FamilyCar extends Car {
  constructor(name, nums) {
    super(name);
    this.nums = nums;
  }

  tour() {
    console.log(`패밀리카 ${this.name}이 ${this.nums}명을 싣고 여행을 간다`);
  }

  run() {
    super.run();
    console.log('wooooooooooooooowww');
  }
}

const carnival = new FamilyCar('카니발', 7);
carnival.tour();
carnival.run();
