// 3-1. 객체 리터럴로 계산기 객체 만들기
const calculator = {
  a : 10,
  b : 20,
  sum() {
    return this.a + this.b;
  },

  multi() {
    return this.a * this.b;
  }
};
console.log("합 : " + calculator.sum());
console.log("곱 : " + calculator.multi());


// 3-2. 객체 생성자로 계산기 객체 만들기
function Calculator() {
  this.a = 10;
  this.b = 20;
  this.sum = function() {
    return this.a + this.b;
  };
  this.multi = function() {
    return this.a * this.b;
  };
}
const cal = new Calculator();
console.log("합 : " + cal.sum());
console.log("곱 : " + cal.multi());
